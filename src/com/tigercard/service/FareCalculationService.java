package com.tigercard.service;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.tigercard.dao.CappingLimitDao;
import com.tigercard.dao.FareTypeDao;
import com.tigercard.dao.MetroTripDao;
import com.tigercard.dao.MetroTripFareDao;
import com.tigercard.domain.CappingLimit;
import com.tigercard.domain.FareTypeRule;
import com.tigercard.domain.MetroTrip;
import com.tigercard.domain.MetroTripFare;
import com.tigercard.enums.CappingType;
import com.tigercard.enums.FareType;
import com.tigercard.service.intf.FareCalculationIntf;

public class FareCalculationService implements FareCalculationIntf {
	
	private static FareCalculationService singleInstance;
	
	private FareCalculationService() {}
	
	public static FareCalculationService getInstance() {
		if (singleInstance == null)
			singleInstance = new FareCalculationService();
		return singleInstance;
	}
	
	

	@Override
	public MetroTrip createMetroTrip(String user, LocalDateTime journeyTime, String fromZone, String toZone) {

		int year = journeyTime.getYear();
		int week = journeyTime.get(WeekFields.ISO.weekOfWeekBasedYear());

		List<MetroTrip> weekTrips = MetroTripDao.getInstance()
				.getMetroTripsByUserAndYearAndWeek(user, year, week);
		
		List<MetroTrip> dayTrips = null;
		int dayTotal = 0;
		int weekTotal = 0;

		if (weekTrips != null) {
			
			dayTrips = weekTrips.stream()
					.filter(metroTrip -> metroTrip.getJourneyTime().getDayOfWeek() == journeyTime.getDayOfWeek())
					.collect(Collectors.toList());

			dayTotal = dayTrips.stream()
					.map(MetroTrip::getCalculatedFare).reduce(0, Integer::sum);

			weekTotal = weekTrips.stream().map(MetroTrip::getCalculatedFare).reduce(0,
					Integer::sum);
						
		}
		
		if(dayTrips == null)
			dayTrips = new ArrayList<>();
		
		int dayCap = findCap(fromZone, toZone, dayTrips, CappingType.DAILY);
		int weekCap = findCap(fromZone, toZone, weekTrips, CappingType.WEEKLY);
		
		int dayCapRemaining = dayCap - dayTotal;
		int weekCapRemaining = weekCap - weekTotal;
		
		MetroTripFare metroTripFare = MetroTripFareDao.getInstance().fetchMetroTripFareByFromZoneAndToZoneAndFareType(fromZone, toZone, identifyFareType(journeyTime));
		
		int currentMetroTripFare = calculateFinalFare(metroTripFare.getFare(), dayCapRemaining, weekCapRemaining);
		
		MetroTrip metroTrip = new MetroTrip(user, fromZone, toZone, journeyTime, currentMetroTripFare);
		MetroTripDao.getInstance().addMetroTrip(metroTrip);

		return metroTrip;
	}

	private int findCap(String currentTripFromZone, String currentTripToZone, List<MetroTrip> pastTrips, CappingType capType) {
		CappingLimitDao cappingLimitDao = CappingLimitDao.getInstance();
		int dayCap = 0;
		if(pastTrips != null) {
			for (Iterator<MetroTrip> iterator = pastTrips.iterator(); iterator.hasNext();) {
				MetroTrip metroTrip = iterator.next();
				CappingLimit cappingLimit = cappingLimitDao.fetchMetroTripFareByFromZoneAndToZoneAndFareType(metroTrip.getFromZone(), metroTrip.getToZone(), capType);
				dayCap = dayCap < cappingLimit.getCapAmount() ? cappingLimit.getCapAmount() : dayCap;
			}
		}
		CappingLimit cappingLimit = cappingLimitDao.fetchMetroTripFareByFromZoneAndToZoneAndFareType(currentTripFromZone, currentTripToZone, capType);
		dayCap = dayCap < cappingLimit.getCapAmount() ? cappingLimit.getCapAmount() : dayCap;
		return dayCap;
	}
	
	private FareType identifyFareType(LocalDateTime journeyTime) {
		FareTypeDao fareTypeDao = FareTypeDao.getInstance();
		List<FareTypeRule> fareTypes = fareTypeDao.getList();
		
		for (FareTypeRule fareType : fareTypes) {
			if(fareType.getDayOfWeekRange().isValidValue(journeyTime.getDayOfWeek().getValue()) 
					&& fareType.getTimeRangeSeconds().isValidValue(journeyTime.toLocalTime().toSecondOfDay())) {
				return fareType.getFareType();
			}
		}
		return FareType.OFFPEAK;
	}
	
	private int calculateFinalFare(int tripFare, int dayCapRemaining, int weekCapRemaining) {
		
		int smallest = dayCapRemaining < weekCapRemaining ? dayCapRemaining : weekCapRemaining;
		smallest = smallest < tripFare ? smallest : tripFare;
		return smallest;
	}

}
