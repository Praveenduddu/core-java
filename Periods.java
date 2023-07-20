package de.zeroco.utility;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import de.zeroco.util.Utility;

public class Periods {
	public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {
		System.out.println(getPeriod("23/02/2000", "02/04/2020"));
		System.out.println(getDaysBetweenDates("23/02/2000", "02/04/2020"));
		System.out.println(getMonthsBetweenDates("23/02/2000", "02/04/2020"));
		System.out.println(getYearsBetweenDates("23/02/2000", "02/04/2020"));
		System.out.println(getWeeksBetweenDates("23/02/2000", "02/04/2020"));
		System.out.println(getDatesOfDayInMonth("January", "sunday", 3022));
		System.out.println(getWeekDayForDate("25/04/2023"));
	}

	public static Period getPeriod(String firstDate, String secondDate) {
		if(Utility.isBlank(firstDate) || Utility.isBlank(secondDate)) return null;
		LocalDate startDate = LocalDate.parse(firstDate, dateFormat);
		LocalDate endDate = LocalDate.parse(secondDate, dateFormat);
	    Period period = Period.between(startDate, endDate);
	    return period;
	}
	
	public static long getDaysBetweenDates(String firstDate, String secondDate) {
		if(Utility.isBlank(firstDate) || Utility.isBlank(secondDate)) return 0;
		LocalDate startDate = LocalDate.parse(firstDate, dateFormat);
		LocalDate endDate = LocalDate.parse(secondDate, dateFormat);
		return ChronoUnit.DAYS.between(startDate, endDate);
	}
	
	public static long getMonthsBetweenDates(String firstDate, String secondDate) {
		if(Utility.isBlank(firstDate) || Utility.isBlank(secondDate)) return 0;
		LocalDate startDate = LocalDate.parse(firstDate, dateFormat);
		LocalDate endDate = LocalDate.parse(secondDate, dateFormat);
		return ChronoUnit.MONTHS.between(startDate, endDate);
	}
	
	public static long getYearsBetweenDates(String firstDate, String secondDate) {
		if(Utility.isBlank(firstDate) || Utility.isBlank(secondDate)) return 0;
		LocalDate startDate = LocalDate.parse(firstDate, dateFormat);
		LocalDate endDate = LocalDate.parse(secondDate, dateFormat);
		return ChronoUnit.YEARS.between(startDate, endDate);
	}
	
	public static long getWeeksBetweenDates(String firstDate, String secondDate) {
		if(Utility.isBlank(firstDate) || Utility.isBlank(secondDate)) return 0;
		LocalDate startDate = LocalDate.parse(firstDate, dateFormat);
		LocalDate endDate = LocalDate.parse(secondDate, dateFormat);
		return ChronoUnit.WEEKS.between(startDate, endDate);
	}
	
	public static String getDatesOfDayInMonth(String inputMonth, String day, int year) {
		if(Utility.isBlank(inputMonth)) return null;
		Month month = Month.valueOf(inputMonth.toUpperCase());
		DayOfWeek dayOfWeek = DayOfWeek.valueOf(day.toUpperCase());
		String dates = "";
		LocalDate localDate = Year.of(year).atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(dayOfWeek));
		while(localDate.getMonth() == month) {
			dates = dates + localDate + ";";
			localDate = localDate.with(TemporalAdjusters.next(dayOfWeek));
		}
		return dates;
	}
	
	public static String getWeekDayForDate(String date) {
		if(Utility.isBlank(date)) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(date, formatter);
		String weekDay = localDate.format(DateTimeFormatter.ofPattern("EE"));
		return weekDay;
	}
	
}
