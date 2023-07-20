package de.zeroco.utility;

import java.time.*;

public class Durations {

	public static void main(String[] args) {
		System.out.println(getDifferenceInHour());
		System.out.println(addSeconds());
		System.out.println(minusSeconds());
	}

	public static long getDifferenceInHour() {
		Duration duration = Duration.between(LocalTime.NOON,LocalTime.MAX);
		return duration.getSeconds() / (60 * 60);
	}
	
	public static Duration addSeconds() {
		Duration duration = Duration.between(LocalTime.of(1, 40), LocalTime.of(1, 42));
		return duration.plusMillis(1000);
	}
	
	public static Duration minusSeconds() {
		Duration duration = Duration.between(LocalTime.of(1, 40), LocalTime.of(1, 42));
		return duration.minusSeconds(2);
	}
}
