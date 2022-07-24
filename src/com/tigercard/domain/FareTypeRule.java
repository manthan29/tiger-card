package com.tigercard.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ValueRange;

import com.tigercard.enums.FareType;

public class FareTypeRule {
	
	private DayOfWeek fromDay;
	private DayOfWeek toDay;
	
	private LocalTime fromTime;
	private LocalTime toTime;
	
	private FareType fareType;
	
	
	public FareTypeRule(DayOfWeek fromDay, DayOfWeek toDay, LocalTime fromTime, LocalTime toTime, FareType fareType) {
		super();
		this.fromDay = fromDay;
		this.toDay = toDay;
		this.fromTime = fromTime;
		this.toTime = toTime;
		this.fareType = fareType;
	}

	public ValueRange getTimeRangeSeconds() {
		return ValueRange.of(fromTime.toSecondOfDay(), toTime.toSecondOfDay());
	}
	
	public ValueRange getDayOfWeekRange() {
		return ValueRange.of(fromDay.getValue(), toDay.getValue());
	}
	
	public FareType getFareType() {
		return fareType;
	}

	@Override
	public String toString() {
		return "FareType [fromDay=" + fromDay + ", toDay=" + toDay + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ ", fareType=" + fareType + "]";
	}
	
	
	
}
