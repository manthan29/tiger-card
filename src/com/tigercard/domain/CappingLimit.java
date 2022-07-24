package com.tigercard.domain;

import com.tigercard.enums.CappingType;

public class CappingLimit {

	private String fromZone;
	private String toZone;
	private CappingType cappingType;
	private int capAmount;
	
	public CappingLimit(String fromZone, String toZone, CappingType cappingType, int capAmount) {
		super();
		this.fromZone = fromZone;
		this.toZone = toZone;
		this.cappingType = cappingType;
		this.capAmount = capAmount;
	}
	
	public String getFromZone() {
		return fromZone;
	}
	public String getToZone() {
		return toZone;
	}
	public CappingType getCappingType() {
		return cappingType;
	}
	
	
	public int getCapAmount() {
		return capAmount;
	}

	@Override
	public String toString() {
		return "CappingLimit [fromZone=" + fromZone + ", toZone=" + toZone + ", cappingType=" + cappingType
				+ ", capAmount=" + capAmount + "]";
	}
	
	
	
}
