package de.zeroco.utility;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateFormats {

	public static void main(String[] args) {
		System.out.println(getYearConvertion());
		System.out.println(getMonthConvertion());
		System.out.println(getDayConvertion());
		System.out.println(getWeekConvertion());
		System.out.println(getHourConvertion());
		System.out.println(displayTime());
		System.out.println(getEraDesignator());
		System.out.println(getTwoDigitYears());
		System.out.println(getNumberFormats());
		System.out.println(getClone());
		System.out.println(getDatePattern());
	}

	public static String getYearConvertion() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/YYYY/yy/YY");
		return simpleDate.format(date);
	}
	
	public static String getMonthConvertion() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("M/MMMM/MM/MMM");
		return simpleDate.format(date);
	}
	
	public static String getDayConvertion() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/DD/DDDD/dddd");
		return simpleDate.format(date);
	}
	
	public static String getWeekConvertion() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("FF/EE/FFFF/EEEE/uu");
		return simpleDate.format(date);
	}
	
	public static String getHourConvertion() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("hh/kk/HH/KK");
		return simpleDate.format(date);
	}
	
	public static String displayTime() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("hh:mm:ss:SS:aa - z");
		return simpleDate.format(date);
	}
	
	public static String getEraDesignator() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("G");
		return simpleDate.format(date);
	}
	
	public static Date getTwoDigitYears() {
		SimpleDateFormat simpleDate = new SimpleDateFormat();
		return simpleDate.get2DigitYearStart();
	}
	
	public static NumberFormat getNumberFormats() {
		SimpleDateFormat simpleDate = new SimpleDateFormat();
		return simpleDate.getNumberFormat();
	}
	
	public static Object getClone() {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy");
		Object year = simpleDate.clone();
		return year;
	}
	
	public static Date getDatePattern() {
		String date = "26/02/2000";
		SimpleDateFormat simpleDate = new SimpleDateFormat("yy/mm/dd");
		try {
			return simpleDate.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
