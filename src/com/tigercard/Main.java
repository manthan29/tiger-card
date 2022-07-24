package com.tigercard;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.tigercard.domain.MetroTrip;
import com.tigercard.service.FareCalculationService;
import com.tigercard.service.intf.FareCalculationIntf;

public class Main {
	
	private static final Logger LOGGER = Logger.getLogger( Main.class.getName() );

	public static void main(String[] args) {
		
		FareCalculationIntf fareCalculationService = FareCalculationService.getInstance();
		
		int totalFare = 0;
		
		MetroTrip metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 25, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 25, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 25, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 25, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 25, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 26, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 26, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 26, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 26, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 26, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 27, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 27, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 27, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 27, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 27, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 28, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 28, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 28, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 28, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 28, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 29, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 29, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 29, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 30, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 30, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 30, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 30, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 30, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 31, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 31, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 31, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 31, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 07, 31, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 8, 1, 10, 20), "2", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 8, 1, 10, 45), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 8, 1, 16, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 8, 1, 18, 15), "1", "1");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		metroTrip = fareCalculationService.createMetroTrip("1", LocalDateTime.of(2022, 8, 1, 19, 00), "1", "2");
		totalFare = totalFare + metroTrip.getCalculatedFare();
		LOGGER.log(Level.INFO, "{0}",metroTrip);
		
		LOGGER.log(Level.INFO, "Total Fare : {0}", totalFare);
		

	}
	
	

}
