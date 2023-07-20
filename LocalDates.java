package de.zeroco.utility;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

public class LocalDates {

	public static void main(String[] args) throws ParseException {
		System.out.println(getDateInFormat("02/2000/23", "MM/yyyy/dd"));
		System.out.println(getDayInYear());
		System.out.println(getPresentTime());
		System.out.println(isLeapYears());
		System.out.println(getTomorrowDate());
		System.out.println(getYesterdayDate());
		System.out.println(getStringToDate());
	}

	public static LocalDate getDateInFormat(String inputDate, String format) throws ParseException {
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
		LocalDate dates = LocalDate.parse(inputDate, dateFormat);
		return dates;
	}
	
	public static LocalDate getPresentTime() {
		LocalDate date = LocalDate.now();
		return date;
	}
	
	public static LocalDate getDayInYear() {
		LocalDate date = LocalDate.ofYearDay(2023, 45);
		return date;
	}
	
	public static boolean isLeapYears() {
		LocalDate date = LocalDate.of(2000, 02, 23);
		return date.isLeapYear();
	}
	
	public static LocalDate getTomorrowDate() {
		LocalDate date = LocalDate.now();
		return date.plusDays(1);
	}
	
	public static LocalDate getYesterdayDate() {
		LocalDate date = LocalDate.now();
		return date.minusDays(1);
	}
	
	public static LocalDate getStringToDate() {
		LocalDate date = LocalDate.parse("2000-02-23");
		return date;
	}
	
}
