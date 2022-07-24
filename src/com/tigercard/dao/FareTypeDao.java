package com.tigercard.dao;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tigercard.domain.FareTypeRule;
import com.tigercard.enums.FareType;

public class FareTypeDao {
	
	private static final Logger LOGGER = Logger.getLogger( FareTypeDao.class.getName() );

	private static FareTypeDao singleInstance;

	//This variable is used to mock the DB. Hence this class is stateful.
	private List<FareTypeRule> fareTypes;
	
	private FareTypeDao() {
		fareTypes = new ArrayList<>();
		generateFareTypes();
	}
	
	public static FareTypeDao getInstance() {
		if (singleInstance == null) {
			singleInstance = new FareTypeDao();
		}
		return singleInstance;
	}
	
	public List<FareTypeRule> getList() {
		return fareTypes;
	}
	
	//This is a temporary function to mock the data in the database/cache hence there is side effect where it is pushing data into the global list
	public void generateFareTypes() {
		
		fareTypes.add(new FareTypeRule(DayOfWeek.MONDAY, DayOfWeek.FRIDAY, LocalTime.of(7,0), LocalTime.of(10, 30), FareType.PEAK));
		fareTypes.add(new FareTypeRule(DayOfWeek.MONDAY, DayOfWeek.FRIDAY, LocalTime.of(17,0), LocalTime.of(20, 0), FareType.PEAK));
		fareTypes.add(new FareTypeRule(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY, LocalTime.of(9,0), LocalTime.of(11, 0), FareType.PEAK));
		fareTypes.add(new FareTypeRule(DayOfWeek.MONDAY, DayOfWeek.FRIDAY, LocalTime.of(18,0), LocalTime.of(22, 0), FareType.PEAK));

		LOGGER.log(Level.INFO, "Fare Types: {0}", fareTypes);
	}
	
}
