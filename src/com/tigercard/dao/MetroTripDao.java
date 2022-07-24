package com.tigercard.dao;

import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tigercard.domain.MetroTrip;

public class MetroTripDao {
	
	private static MetroTripDao singleInstance;
	
	private Map<String, List<MetroTrip>> metroTripsByUserAndYearAndWeek;

	private MetroTripDao() {
		metroTripsByUserAndYearAndWeek = new HashMap<>();
	}
	
	public static MetroTripDao getInstance() {
		if(singleInstance == null)
			singleInstance = new MetroTripDao();
		return singleInstance;
	}
	
	public List<MetroTrip> getMetroTripsByUserAndYearAndWeek(String user, int year, int week){
		return metroTripsByUserAndYearAndWeek.get(constructKey(user, year, week));
	}
	
	public void addMetroTrip(MetroTrip metroTrip) {
		int year = metroTrip.getJourneyTime().getYear();
		int week = metroTrip.getJourneyTime().get(WeekFields.ISO.weekOfWeekBasedYear());
		String key = constructKey(metroTrip.getUser(), year, week);
		List<MetroTrip> metroTrips = metroTripsByUserAndYearAndWeek.get(key);
		if (metroTrips == null) {
			metroTrips = new ArrayList<>();
		}
		metroTrips.add(metroTrip);
		metroTripsByUserAndYearAndWeek.put(constructKey(metroTrip.getUser(), year, week), metroTrips);
	}

	// This would typically be a where clause for the Database
	private String constructKey(String user, int year, int week) {
		return user + "-" + year + "-" + week;
	}
}
