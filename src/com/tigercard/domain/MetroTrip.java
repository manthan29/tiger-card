package com.tigercard.domain;

import java.time.LocalDateTime;

public class MetroTrip {

	private String user;
	private String fromZone;
	private String toZone;
	private LocalDateTime journeyTime;
	
	//can llok at storing the year and week as a separate attribute to boost the query time
	
	private int calculatedFare;
	
	private MetroTripFare metroTripFare;
	private CappingLimit cappingLimit;
	
	

	public MetroTrip(String user, String fromZone, String toZone, LocalDateTime journeyTime, int calculatedFare) {
		super();
		this.user = user;
		this.fromZone = fromZone;
		this.toZone = toZone;
		this.journeyTime = journeyTime;
		this.calculatedFare = calculatedFare;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFromZone() {
		return fromZone;
	}

	public void setFromZone(String fromZone) {
		this.fromZone = fromZone;
	}

	public String getToZone() {
		return toZone;
	}

	public void setToZone(String toZone) {
		this.toZone = toZone;
	}

	public LocalDateTime getJourneyTime() {
		return journeyTime;
	}

	public void setJourneyTime(LocalDateTime journeyTime) {
		this.journeyTime = journeyTime;
	}

	public int getCalculatedFare() {
		return calculatedFare;
	}

	public void setCalculatedFare(int calculatedFare) {
		this.calculatedFare = calculatedFare;
	}

	public MetroTripFare getMetroTripFare() {
		return metroTripFare;
	}

	public void setMetroTripFare(MetroTripFare metroTripFare) {
		this.metroTripFare = metroTripFare;
	}

	public CappingLimit getCappingLimit() {
		return cappingLimit;
	}

	public void setCappingLimit(CappingLimit cappingLimit) {
		this.cappingLimit = cappingLimit;
	}

	@Override
	public String toString() {
		return "MetroTrip [user=" + user + ", fromZone=" + fromZone + ", toZone=" + toZone + ", journeyTime="
				+ journeyTime + ", calculatedFare=" + calculatedFare + "]";
	}
	
	

}
