package com.tigercard.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tigercard.domain.CappingLimit;
import com.tigercard.enums.CappingType;

public class CappingLimitDao {
	
	private static final Logger LOGGER = Logger.getLogger( CappingLimitDao.class.getName() );


	private static CappingLimitDao singleInstance;

	// This variable is used to mock the DB. Hence this class is stateful.
	private Map<String, CappingLimit> cappingLimits;

	private CappingLimitDao() {
		cappingLimits = new HashMap<>();
		generateCappingLimits();
	}

	public static CappingLimitDao getInstance() {
		if (singleInstance == null) {
			singleInstance = new CappingLimitDao();
		}
		return singleInstance;
	}

	public CappingLimit fetchMetroTripFareByFromZoneAndToZoneAndFareType(String fromZone, String toZone, CappingType cappingType) {
		return cappingLimits.get(constructKey(fromZone, toZone, cappingType));

	}

	// This is a temporary function to mock the data in the database/cache hence
	// there is side effect where it is pushing data into the global list
	public void generateCappingLimits() {
		cappingLimits.put(constructKey("1", "1", CappingType.DAILY), new CappingLimit("1", "1", CappingType.DAILY, 100));
		cappingLimits.put(constructKey("1", "2", CappingType.DAILY), new CappingLimit("1", "2", CappingType.DAILY, 120));
		cappingLimits.put(constructKey("2", "1", CappingType.DAILY), new CappingLimit("2", "1", CappingType.DAILY, 120));
		cappingLimits.put(constructKey("2", "2", CappingType.DAILY), new CappingLimit("2", "2", CappingType.DAILY, 80));

		cappingLimits.put(constructKey("1", "1", CappingType.WEEKLY), new CappingLimit("1", "1", CappingType.WEEKLY, 500));
		cappingLimits.put(constructKey("1", "2", CappingType.WEEKLY), new CappingLimit("2", "2", CappingType.WEEKLY, 600));
		cappingLimits.put(constructKey("2", "1", CappingType.WEEKLY), new CappingLimit("2", "2", CappingType.WEEKLY, 600));
		cappingLimits.put(constructKey("2", "2", CappingType.WEEKLY), new CappingLimit("2", "2", CappingType.WEEKLY, 400));
		
		LOGGER.log(Level.INFO, "Capping Limits: {0}", cappingLimits);

	}

	// This would typically be a where clause for the Database
	private String constructKey(String fromZone, String toZone, CappingType cappingType) {
		return fromZone + "-" + toZone + "-" + cappingType.name();
	}

}
