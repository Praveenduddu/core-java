package de.zeroco.utility;

import java.sql.Time;
import java.util.Date;

public class DateAndTime {
	public static final String[] DAYS = {"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "Seprember", "October", "November", "December"};
	
	public static void main(String[] args) {
		Date date = new Date();
		Date firstDate = new Date(2023, 04, 20);
		Date secondDate = new Date(2023, 04, 19);
		System.out.println(firstDate.after(secondDate));
		System.out.println(date.getTime());
		System.out.println(date.getTimezoneOffset());
		System.out.println(getFullDate(date.getDate(), date.getMonth(), date.getYear()));
		System.out.println(getFullTime(date.getHours(), date.getMinutes(), date.getSeconds()));
		System.out.println(getStringToDate("23/02/2000"));
		System.out.println(date.toGMTString());
		date.setDate(12);
		System.out.println(date.toLocaleString());
	}

	public static int getAnalogueClock(int hours) {
		return (hours > 12) ? (hours - 12) : hours;
	}
	
	public static int getPresentYears(int year) {
		return (year + 1900);
	}
	
	public static String getFullDate(int date, int month, int year) {
		return date + "-" + MONTHS[month] + "-" + getPresentYears(year);
	}
	
	public static String getFullTime(int hour, int min, int sec) {
		return (hour <= 12) ? getAnalogueClock(hour) + ":" + min + ":" + sec + " AM" : getAnalogueClock(hour) + ":" + min + ":" + sec + " PM";
	}
	
	public static long getStringToDate(String date) {
		return Date.parse(date);
	}
}
