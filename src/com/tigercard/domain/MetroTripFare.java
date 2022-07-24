package com.tigercard.domain;

import com.tigercard.enums.FareType;

public class MetroTripFare {

	private String fromZone;
	private String toZone;
	private FareType fareType;
	private int fare;

	
	
	public MetroTripFare(String fromZone, String toZone, FareType fareType, int fare) {
		super();
		this.fromZone = fromZone;
		this.toZone = toZone;
		this.fareType = fareType;
		this.fare = fare;
	}

	public String getFromZone() {
		return fromZone;
	}

	public String getToZone() {
		return toZone;
	}

	public FareType getFareType() {
		return fareType;
	}

	public int getFare() {
		return fare;
	}

	@Override
	public String toString() {
		return "MetroTripFare [fromZone=" + fromZone + ", toZone=" + toZone + ", fareType=" + fareType + ", fare="
				+ fare + "]";
	}

	
}
