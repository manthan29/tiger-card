package com.tigercard.service.intf;

import java.time.LocalDateTime;

import com.tigercard.domain.MetroTrip;

public interface FareCalculationIntf {

	public MetroTrip createMetroTrip(String user, LocalDateTime journeyTime, String fromZone, String toZone);
}
