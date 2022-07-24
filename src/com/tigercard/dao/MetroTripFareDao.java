package com.tigercard.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tigercard.domain.MetroTripFare;
import com.tigercard.enums.FareType;

public class MetroTripFareDao {
	
	private static final Logger LOGGER = Logger.getLogger( MetroTripFareDao.class.getName() );

	private static MetroTripFareDao singleInstance;
	
	//This variable is used to mock the DB. Hence this class is stateful.
	private Map<String, MetroTripFare> metroTripFares;
	
	private MetroTripFareDao() {
		metroTripFares = new HashMap<>();
		generateMetroTripFares();
	}
	
	public static MetroTripFareDao getInstance() {
		if(singleInstance == null)
			singleInstance = new MetroTripFareDao();
		return singleInstance;
	}
	
	public MetroTripFare fetchMetroTripFareByFromZoneAndToZoneAndFareType(String fromZone, String toZone, FareType fareType) {
		return metroTripFares.get(constructKey(fromZone, toZone, fareType));
		
	}
	
	//This is a temporary function to mock the data in the database/cache hence there is side effect where it is pushing data into the global list
	public void generateMetroTripFares() {
		metroTripFares.put(constructKey("1", "1", FareType.PEAK), new MetroTripFare("1", "1", FareType.PEAK, 30));
		metroTripFares.put(constructKey("1", "2", FareType.PEAK), new MetroTripFare("1", "2", FareType.PEAK, 35));
		metroTripFares.put(constructKey("2", "1", FareType.PEAK), new MetroTripFare("2", "1", FareType.PEAK, 35));
		metroTripFares.put(constructKey("2", "2", FareType.PEAK), new MetroTripFare("2", "2", FareType.PEAK, 25));
		
		metroTripFares.put(constructKey("1", "1", FareType.OFFPEAK), new MetroTripFare("1", "1", FareType.OFFPEAK, 25));
		metroTripFares.put(constructKey("1", "2", FareType.OFFPEAK), new MetroTripFare("1", "2", FareType.OFFPEAK, 30));
		metroTripFares.put(constructKey("2", "1", FareType.OFFPEAK), new MetroTripFare("2", "1", FareType.OFFPEAK, 30));
		metroTripFares.put(constructKey("2", "2", FareType.OFFPEAK), new MetroTripFare("2", "2", FareType.OFFPEAK, 20));
		
		LOGGER.log(Level.INFO, "Metro Trip Fare: {0}", metroTripFares);
		
	}
	
	//This would typically be a where clause for the Database
	private String constructKey(String fromZone, String toZone, FareType fareType) {
		return fromZone + "-" + toZone + "-" + fareType.name();
	}
	
}
