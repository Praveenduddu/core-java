package de.zeroco.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import de.zeroco.util.Utility;

public class Calenders {
	
	public static void main(String[] args) throws Exception {
//		System.out.println(getIndianStandardTime());
//		System.out.println(getTypeOfCalendar());
//		System.out.println(getFirstDayInWeek());
//		System.out.println(getTimeRegion());
//		System.out.println(getWeeksInYear());
//		System.out.println(getYear());
//		System.out.println(isDateSupported());
//		System.out.println(getMaximum());
//		System.out.println(getMinimum());
//		System.out.println(setTimes());
//		System.out.println(isDateAfter());
//		System.out.println(getDate());
//		System.out.println(getMonths());
//		System.out.println(getWeek());
//		System.out.println(getYear());
//		System.out.println(getChangeInYears());
//		System.out.println(getChangeInMonths());
//		System.out.println(getMaximumInYear());
		System.out.println(changeDurationToDate("23/02/2000", "yy/MMM/dd", "year", -2));
		System.out.println(getDaysBetweenDates("23/02/2000", "23/03/2000"));
		System.out.println(getDayOfWeek("23/02/2000"));
	}
	
	public static Date getIndianStandardTime() {
		return Calendar.getInstance().getTime();
	}
	
	public static String getTypeOfCalendar() {
		return Calendar.getInstance().getCalendarType();
	}
	
	public static int getFirstDayInWeek() {
		return Calendar.getInstance().getFirstDayOfWeek();
	}
	
	public static TimeZone getTimeRegion() {
		return Calendar.getInstance().getTimeZone();
	}
	
	public static int getWeeksInYear() {
		return Calendar.getInstance().getWeeksInWeekYear();
	}
	
	public static int getYear() {
		Calendar calendar = Calendar.getInstance();
		Object calendarCopy = calendar.clone();
		return Calendar.getInstance().getWeekYear();
	}
	
	public static boolean isDateSupported() {
		return Calendar.getInstance().isWeekDateSupported();
	}
	
	public static int getMaximum() {
		return Calendar.getInstance().getActualMaximum(Calendar.DATE);
	}
	
	public static int getMinimum() {
		return Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH);
	}
	
	public static long setTimes() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();
	}
	
	public static boolean isDateAfter() {
		return Calendar.getInstance().after("26/02/2000");
	}
	
	public static int getDate() {
		return Calendar.getInstance().get(Calendar.DATE);
	}
	
	public static int getMonths() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}
	
	public static int getWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}
	
	public static int getYears() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static int getChangeInYears() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		return calendar.get(Calendar.YEAR);
	}
	
	public static int getChangeInMonths() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 3);
		return calendar.get(Calendar.MONTH);
	}
	
	public static int getMaximumInYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getActualMaximum(Calendar.YEAR);
	}
	
	public static String changeDurationToDate(String inputDate, String format, String type, int duration) throws Exception {
		if (Utility.isBlank(inputDate) || Utility.isBlank(format) || Utility.isBlank(type)) return null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		calendar.setTime(dateFormat.parse(inputDate));
		if (type.toLowerCase() == "year") 
			calendar.add(calendar.YEAR, duration);
		else if (type.toLowerCase() == "month") 
			calendar.add(calendar.MONTH, duration);
		else if (type.toLowerCase() == "day") 
			calendar.add(calendar.DAY_OF_MONTH, duration);
		dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(calendar.getTime());
	}
	
	public static String getDaysBetweenDates(String fromDate, String toDate) throws ParseException {
		if (Utility.isBlank(fromDate) || Utility.isBlank(toDate)) return null;
		Calendar endDate = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		endDate.setTime(dateFormat.parse(toDate));
		Calendar startDate = Calendar.getInstance();
		startDate.setTime(dateFormat.parse(fromDate));
		long time = endDate.getTimeInMillis() - startDate.getTimeInMillis();
		long days = time / (60 * 60 * 1000 * 24);
		return days + " days";
	}
	
	public static String getDayOfWeek(String date) throws ParseException {
		if (Utility.isBlank(date)) return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));
	    return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.ENGLISH);
	}
	
}
