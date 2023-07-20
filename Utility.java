package de.zeroco.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.zeroco.utility.Files;

public class Utility {
	public static final String[] FIRST_TWENTY = { "", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"ninteen"};
	public static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninty"};
	private static final String[] THOUSAND_AND_ABOVE = {"", "thousand", "Lakh", "Crore"};
	public static final String SOURCE = "C:\\Users\\91834\\Desktop\\files\\lisence.json";
	public static final String FILE_EXTENSION = ".zc_lic";
	public static String dataToReplace = "$no$";
	public static final char[] ARABIC_NUMBERS = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
	public static final char[] INDIAN_NUMBERS = {'०', '१', '२', '३', '४', '५', '६', '७', '८', '९'};


	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		Map<String, Object> linkedHash = new LinkedHashMap<String, Object>();
		linkedHash.put("first", 26);
		linkedHash.put("second", 26);
		linkedHash.put("third", 26);
		linkedHash.put("fourth", 26);
		Map<String, Object> linkedHashMap = new LinkedHashMap<String, Object>();
		linkedHashMap.put("first", 27);
		linkedHashMap.put("second", 27);
		linkedHashMap.put("third", 27);
		linkedHashMap.put("fourth", 27);
		Map<String, Object> linked = new LinkedHashMap<String, Object>();
		linked.put("first", 28);
		linked.put("second", 28);
		linked.put("third", 28);
		linked.put("fourth", 28);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		list.add(linkedHash);
		list.add(linkedHashMap);
		list.add(linked);
//		HashMap<String,Object> map = new HashMap<String, Object>();
//		map.put("name", "hello");
//		map.put(null, "hello1");
//		map.put("", "hello2");
//		map.put(null, "hello3");
//		map.put(null, "hello4");
//		System.out.println(map);
//		HashSet<Object> hashSet = new HashSet<Object>();
//		hashSet.add(null);
//		hashSet.add(2);
//		hashSet.add(3);
//		LinkedHashSet<Object> linkedHash = new LinkedHashSet<Object>();
//		linkedHash.add(null);
//		linkedHash.add(2);
//		linkedHash.add(4);
//		JSONObject object = new JSONObject();
//		object.put("Name", "Ram");
//		object.put("RollNumber", "18481A0334");
//		object.put("Place", "Madhapur");
//		String key[] = {"info", "item.request.auth", "item.response" };
//		String json = "[ {\"name\": \"John\",\"age\": 30,\"city\": \"New York\"},{\"name\": \"Jane\",\"age\": 25,\"city\":\"San Francisco\"},{\"name\": \"Bob\",\"age\": 40,\"city\":\"Seattle\"}] ";
//		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
//		String[] firstArray = {"a", "b", "c", "e", "f"};
//		String[] secondArray = {"b", "c", "d"};
//		System.out.println(Utility.isBlank(2));
//		System.out.println(Utility.hasData(-1222));
//		System.out.println(Utility.getTicket("Dear customer, Your ticket number is : {{HYDTS123456}}. Happy Journey", "{", "}"));
//		System.out.println(Utility.removeExtraSpace("   hello     is beautiful     word   "));
//		System.out.println(Utility.ConvertNumbersToWords(112));
//		System.out.println(Utility.getDifferenceBetweenDates("12/10/2021", "12/10/2022"));
//		System.out.println((getDateInFormat("23/03/2000", "MMM/yyyy/dd")));
//		System.out.println(calculateTheIntrest(100000, "23/04/2000", "23/05/2000", 10.25));
//		System.out.println(getDifferenceBetweenDate("26/02/2000", "27/04/2023"));
//		System.out.println(addDurationToDate("23/02/2000", "yyyy/MMMM/dd", "day", 2));
//		System.out.println(minusDurationToDate("23/02/2000", "yyyy/MMMM/dd", "year", 2));
//		System.out.println(calculateTheAge("2000-02-26"));
//		System.out.println(isValidDate(31, 14, 2000));
//		System.out.println(isValidDate("29/02/2000"));
//		System.out.println(isLeapYear("26/02/2000"));
//		System.out.println(getListOfFilePath("Sample"));
//		System.out.println(getNumberInFormat(3445));
//		System.out.println(concatDateAndTime("2023-03-28T00:00:00", "10:20"));
		//isValidPassword-String password-input-Password[@,#,&,$,!][0-9]{8,15}
		//isValidMobileNumber-String number-input-
//		System.out.println(isValidPassword("12345@$0Aa"));
//		System.out.println(isValidPhoneNumber("6234567890"));
//		System.out.println(getNameInFormat("Andhra Pradesh1"));
//		System.out.println(isValidEmail("hari@yahoo.in"));
//		System.out.println(getUniqueElementsInSet(linkedHash, hashSet)); 
//		System.out.println(Arrays.toString(getUniqueElementsInArray(secondArray, firstArray)));
//		System.out.println(JsonToMap("C:\\Users\\91834\\Desktop\\files\\Sample.json", "first.second.third.fourth"));
//		System.out.println(getValueByKey("{\"first\":{\"second\":{\"third\":\"hello world\"},\"forth\":{\"fifth\":\"welcome java\"}}}", "first.forth.fifth"));
//		System.out.println(generateLicence("praveen", 1, 20, "C:\\Users\\91834\\Desktop\\Sample\\"));
//		System.out.println(convertTextIntoImage("Krishna", "C:\\Users\\91834\\Desktop\\Sample\\output.png", 500, 300, 50, "Times New Roman", "png"));
//		System.out.println(getListFromJsonString(json, "name"));
//		System.out.println(removeKeysFromJson("C:\\Users\\91834\\Desktop\\Sample\\sample.json", key, "item", "api"));
//		System.out.println(getMapWithKeyValue(list, "first", 28));
		System.out.println(convertNumberToArabicNumber(12345));
//		System.out.println(convertNumberToIndianFormat(1234567));
		 
	}

	/**
	 * this method is check the given input is blank
	 * 
	 * @author praveen D
	 * @param input
	 * @return status
	 */
	public static boolean isBlank(Object input) {
		if (input == null) return true;
		else if (input instanceof String) {
			if (((String) input).trim().equals("")) return true;
		} else if (input instanceof Byte) {
			if ((byte) input <= 0) return true;
		} else if (input instanceof Short) {
			if ((short) input <= 0) return true;
		} else if (input instanceof Integer) {
			if ((int) input <= 0) return true;
		} else if (input instanceof Long) {
			if ((long) input <= 0) return true;
		} else if (input instanceof Float) {
			if ((float) input <= 0) return true;
		} else if (input instanceof Double) {
			if ((double) input <= 0.0) return true;
		} else if (input instanceof Boolean) {
			if ((boolean) input == false) return true;
		} else if (input instanceof Character) {
			if ((char) input == ' ') return true;
		} else if (input instanceof Map) {
			if (((Map<?, ?>) input).isEmpty()) return true;
		} else if (input instanceof Object[]) {
			if (((Object[]) input).length == 0) return true;
		} else if (input instanceof Collection) {
			if (((Collection<?>) input).isEmpty()) return true;
		}
		return false;
	}

	/**
	 * this method is checking that input have data
	 * 
	 * @author praveen D
	 * @param input
	 * @return status
	 */
	public static boolean hasData(Object input) {
		return !isBlank(input);
	}

	public static int getObjectToInt(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).intValue();
	}

	public static double getObjectToDouble(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).doubleValue();
	}

	public static long getObjectToLong(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).longValue();
	}

	public static byte getObjectToByte(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).byteValue();
	}

	public static short getObjectToShort(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).shortValue();
	}
	
	public static float getObjectToFloat(Object number) {
		if (Utility.isBlank(number)) return 0;
		return ((Number) number).floatValue();
	}
	
	/**
	 * this method is getting the ticket from the data
	 * 
	 * @param data
	 * @param startChar
	 * @param endChar
	 * @return
	 */
	public static String getTicket(String data, String startChar, String endChar) {
		if (Utility.isBlank(data) || Utility.isBlank(startChar) || Utility.isBlank(endChar))
			return null;
		return data.substring(data.indexOf(startChar) + 2, data.lastIndexOf(endChar) - 1);
	}

	/**
	 * this method remove the excess spaces in the sentence
	 * 
	 * @param sentence
	 * @return
	 */
	public static String removeExtraSpace(String sentence) {
		if (Utility.isBlank(sentence))
			return null;
		// return sentence.trim().replaceAll("\\s+", " ");
		String trmSpaceAtToEnds = sentence.trim();
		String[] splitBySpace = trmSpaceAtToEnds.split(" ");
		String finalSentence = "";
		for (int i = 0; i <= splitBySpace.length - 1; i++) {
			if (!splitBySpace[i].isEmpty())
				finalSentence = finalSentence + splitBySpace[i] + " ";
		}
		finalSentence = finalSentence.trim();
		return finalSentence;
	}

	/**
	 * 
	 * @param number
	 * @return
	 */
	public static String ConvertNumbersToWords(int number) {
		if(isBlank(number)) return null;
		if (number == 0)
			return "zero";
		int index = 0;
		String result = "";
		while (number > 0) {
			if (index == 0) {
				int lastThreeDigits = number % 1000;
				String word = convertLastNumbersToWords(lastThreeDigits);
				result = word + " " + THOUSAND_AND_ABOVE[index] + " " + result;
				number = number / 1000;
			} else {
				int lastTwoDigits = number % 100;
				String word = convertLastNumbersToWords(lastTwoDigits);
				result = word + " " + THOUSAND_AND_ABOVE[index] + " " + result;
				number = number / 100;
			}
			index++;
		}
		return result.trim();
	}

	public static String convertLastNumbersToWords(int number) {
		String word = "";
		if (number % 100 < 20) {
			word = FIRST_TWENTY[number % 100];
			number = number / 100;
		} else {
			word = FIRST_TWENTY[number % 10];
			number = number / 10;
			word = TENS[number % 10] + " " + word;
			number = number / 10;
		}
		if (number != 0) 
			return FIRST_TWENTY[number] + " hundred " + word;
		return word;
	}
	
	/**
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws ParseException
	 */
	public static String getDifferenceBetweenDates(String fromDate, String toDate) throws ParseException {
		if(isBlank(fromDate) || isBlank(toDate)) return null;
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		Date firstDate = simpleDate.parse(fromDate);
		Date secondDate = simpleDate.parse(toDate);
		long time = firstDate.getTime() - secondDate.getTime();
		long timeInMilliSec = time < 0 ? (time * -1) : time;
		long days = (timeInMilliSec / (1000 * 60 * 60 * 24));
		long months = (days / 30);
		long years = (months / 12);
		return years + " Years " + months + " Months " + days + " Days ";
	}
	
	/**
	 * 
	 * @param inputDate
	 * @param format
	 * @return
	 * @throws Exception
	 */
	public static String getDateInFormat(String inputDate, String format) throws Exception {
		if(isBlank(inputDate) || isBlank(format)) return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = simpleDateFormat.parse(inputDate);
		simpleDateFormat = new SimpleDateFormat(format);
		String dateInFormat = simpleDateFormat.format(date);
		return dateInFormat;
	}

	/**
	 * 
	 * @param balance
	 * @param startDate
	 * @param endDate
	 * @param roi
	 * @return
	 * @throws Exception
	 */
	public static String calculateTheInterest(int balance, String startDate, String endDate, double roi) throws Exception {
		if(isBlank(startDate) || isBlank(endDate) || isBlank(roi) || isBlank(balance)) return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date beginingDate = simpleDateFormat.parse(startDate);
		Date endingDate = simpleDateFormat.parse(endDate);
		long time = endingDate.getTime() - beginingDate.getTime();
		long days = time / (1000 * 60 * 60 * 24);
		double interest = balance * ((roi/100)/365) * days;
		return String.format("%.2f", interest);
	}
	
	/**
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static String getDifferenceBetweenDate(String startDate, String endDate) {
		if(isBlank(startDate) || isBlank(endDate)) return null;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate beginingDate = LocalDate.parse(startDate, dateFormat);
		LocalDate endingDate = LocalDate.parse(endDate, dateFormat);
	    Period period = Period.between(beginingDate, endingDate);
		return period.getYears() + " year " + period.getMonths() + " month " + period.getDays() +" day ";
	}
	
	/**
	 * this method is add the duration to given date and convert the date into given format
	 * @param inputDate
	 * @param format
	 * @param type
	 * @param duration
	 * @return
	 * @throws Exception
	 */
	public static String addDurationToDate(String inputDate, String format, String type, int duration) throws Exception {
		if(isBlank(format) || isBlank(type) || isBlank(duration) || isBlank(inputDate)) return null;
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
		return addDurationToDate(date, format, type, duration);
	}
	/**
	 * this method is add the duration to given date and convert the date into given format
	 * @param inputDate
	 * @param format
	 * @param type
	 * @param duration
	 * @return
	 */
	public static String addDurationToDate(Date inputDate, String format, String type, int duration) {
		if(isBlank(format) || isBlank(type) || isBlank(duration)) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String dates = simpleDate.format(inputDate);
		LocalDate localDate = LocalDate.parse(dates, formatter);
        Period period = Period.of((localDate.getYear()), (localDate.getMonthValue()), localDate.getDayOfMonth());
		Period addDuration = (type.toLowerCase() == "year") ? period.plusYears(duration) : (type.toLowerCase() == "month") ? period.plusMonths(duration) : (type.toLowerCase() == "day") ? period.plusDays(duration) : null;
		formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.of(addDuration.getYears(), addDuration.getMonths(), addDuration.getDays()).format(formatter);
	}
	
	/**
	 * this method is minus the duration to given date and convert the date into given format
	 * @param inputDate
	 * @param format
	 * @param type
	 * @param duration
	 * @return
	 * @throws Exception
	 */
	public static String minusDurationToDate(String inputDate, String format, String type, int duration) throws Exception {
		if(isBlank(format) || isBlank(type) || isBlank(duration) || isBlank(inputDate)) return null;
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);
		return minusDurationToDate(date, format, type, duration);
	}
	
	/**
	 * this method is minus the duration to given date and convert the date into given format
	 * @param inputDate
	 * @param format
	 * @param type
	 * @param duration
	 * @return
	 */
	public static String minusDurationToDate(Date inputDate, String format, String type, int duration) {
		if(isBlank(format) || isBlank(type) || isBlank(duration) || isBlank(inputDate)) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String dates = simpleDate.format(inputDate);
		LocalDate localDate = LocalDate.parse(dates, formatter);
        Period period = Period.of((localDate.getYear()), (localDate.getMonthValue()), localDate.getDayOfMonth());
		Period addDuration = (type.toLowerCase() == "year") ? period.minusYears(duration) : (type.toLowerCase() == "month") ? period.minusMonths(duration) : (type.toLowerCase() == "day") ? period.minusDays(duration) : null;
		formatter = DateTimeFormatter.ofPattern(format);
		return LocalDate.of(addDuration.getYears(), addDuration.getMonths(), addDuration.getDays()).format(formatter);
	}
	
	/**
	 * this method is use to calculate the age
	 * @param dateOfBirth
	 * @return
	 */
	public static int calculateTheAge(String dateOfBirth) {
		if(isBlank(dateOfBirth)) return 0;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate beginingDate = LocalDate.parse(dateOfBirth, dateFormat);
	    Period period = Period.between(beginingDate, LocalDate.now());
		return period.getYears();
	}
	
	/**
	 * this method is check the given date is valid 
	 * @param date
	 * @param month
	 * @param year
	 * @return status
	 */
	public static boolean isValidDate(int date, int month, int year) {
		if (isBlank(date) || isBlank(month) || isBlank(year)) return false;
		 if (month < 1 || month > 12) return false;
	        if (date < 1 || date > 31) return false;
	        if (month == 2) 
	        {
	            if (isLeapYear(year)) 
	            	return (date <= 29) ? true : false;
	            else 
	            	return (date <= 28) ? true : false;
	        }
	        if (month == 4 || month == 6 || month == 9 || month == 11) return (date <= 30) ? true : false;
	        return true;
	}
	
	/**
	 * this method is check the given date is valid
	 * @param inputDate
	 * @return status
	 */
	public static boolean isValidDate(String inputDate) {
		if (isBlank(inputDate)) return false;
		String[] fullDate = inputDate.split("/");
		int date = Integer.parseInt(fullDate[0]);
		int month = Integer.parseInt(fullDate[1]);
		int year = Integer.parseInt(fullDate[2]);
		if (month < 1 || month > 12) return false;
        if (date < 1 || date > 31) return false;
        if (month == 2) 
        {
            if (isLeapYear(year)) 
            	return (date <= 29) ? true : false;
            else 
            	return (date <= 28) ? true : false;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) return (date <= 30) ? true : false;
        return true;
	}
	
	/**
	 * this method is check the given date is leap year
	 * @param inputDate
	 * @return status
	 */
	public static boolean isLeapYear(String inputDate) {
		if (isBlank(inputDate)) return false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(inputDate, formatter);
		return (((localDate.getYear() % 4 == 0) && (localDate.getYear() % 100 != 0)) || (localDate.getYear() % 400 == 0)) ? true : false;
	}
	
	public static boolean isLeapYear(int year) {
		if (isBlank(year)) return false;
		return (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) ? true : false;
	}
	
	/**
	 * this method convert number into indian format
	 * @param inputNumber
	 * @return result
	 */
	public static String getNumberInFormat(int inputNumber) {
		if (Utility.isBlank(inputNumber)) return null;
        char[] number = Integer.toString(inputNumber).toCharArray();
        String result = "" + number[number.length - 1];
        int count = 0;
        for (int i = number.length - 2; i >= 0; i--) {
        	result = number[i] + result;
            count++;
            if (count % 2 == 0 && i > 0) {
                result = "," + result;
            }
        }
        return result + ".00";
    }
	
	public static String concatDateAndTime(String date, String time) {
		if (Utility.isBlank(date) || Utility.isBlank(time)) return null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.parse(date);
		LocalTime localTime = LocalTime.parse(time);
		localDateTime = localDateTime.plusHours(localTime.getHour()).plusMinutes(localTime.getMinute()).plusSeconds(localTime.getSecond());
		return localDateTime.format(formatter);
	}
	
	public static boolean isValidPassword(String password) {
		if (Utility.isBlank(password)) return false;
		return Pattern.compile("(?=.*[\\d])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$&!]).{8,15}").matcher(password).matches();
	}
	
	public static boolean isValidPhoneNumber(String number) {
		if (Utility.isBlank(number)) return false;
		return Pattern.compile("[6-9]\\d{9}").matcher(number).matches();
	}
	
	public static String getNameInFormat(String name) {
		if (Utility.isBlank(name)) return null;
//		return name.toLowerCase().replaceAll("([^a-z])", " ").trim().replaceAll(" ", "_");
		name = name.toLowerCase().replaceAll("([^a-z])", "_").trim();
		String result = name.endsWith("_") ? name.substring(0, name.length() - 1) : name;
		return result;
	}
	
	public static boolean isValidEmail(String email) {
		if (Utility.isBlank(email)) return false;
		return Pattern.compile("[A-Za-z0-9.]+@[A-Za-z0-9.]+").matcher(email).matches();
	}
	
	public static Set<Object> getUniqueElementsInSet(Set<Object> firstSet, Set<Object> secondSet) {
		if (isBlank(firstSet) || isBlank(secondSet)) return null;
//		Set<Object> set = firstSet;
//		set.removeAll(secondSet);
		TreeSet<Object> set = new TreeSet<Object>();
		Iterator<Object> iterate = firstSet.iterator();
		while (iterate.hasNext()) {
			Object element = iterate.next();
			if (!secondSet.contains(element)) {
				set.add(element);
			}
		}
		return set;
	}
	
	public static String[] getUniqueElementsInArray(String[] firstArray, String[] secondArray) {
		LinkedHashSet<Object> linkedHash = new LinkedHashSet<Object>(Arrays.asList(firstArray));
		LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<Object>(Arrays.asList(secondArray));
		String[] array = getUniqueElementsInSet(linkedHash, linkedHashSet).toArray(new String[0]);
		return array;
	}
	
	public static Map<String, Object> jsonToMap(String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = null;
		Map<String, Object> map = null;
		try {
			jsonNode = objectMapper.readTree(json);
			map = objectMapper.convertValue(jsonNode, new TypeReference<Map<String, Object>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static Object getValueByKey(String json, String key) {
		if (Utility.isBlank(key) || Utility.isBlank(json)) return null;
		String[] keys = key.split("\\.");
		Object specificValue = null;
		try {
			Map<String, Object> map = jsonToMap(json);
	        for (int i = 0; i < keys.length - 1; i++) {
	            map = (Map<String, Object>) map.get(keys[i]);
	        }
			specificValue = map.get(keys[keys.length - 1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return specificValue;
	}

	public static String generateLicence(String client, int from, int to, String destination) {
		if (Utility.isBlank(client) || Utility.isBlank(from) || Utility.isBlank(to)) return null;
		List<String> list = Files.readDataInFile(SOURCE);
		if (Utility.isBlank(destination)) {
			destination = System.getProperty("java.io.tmpdir");
		}
		if (!Files.isExists(destination)) {
			Files.createFolder(destination);
		}
		for (int i = from; i <= to; i++) {
			List<String> finalList = new ArrayList<String>();
			String fileName = (i < 10) ? client + 0 + i : client + i;
			String filePath = destination + fileName + FILE_EXTENSION;
			for (int j = 0; j < list.size(); j++) {
				String line = list.get(j);
				line = line.replace(dataToReplace, fileName);
				finalList.add(line);
			}
			Files.writeDataInFile(filePath, finalList);
		}
		return destination;
	}
	
	public static String generateLicence(String client, int from, int to) {
		return generateLicence(client, from, to, "");
	}
	
	public static Connection getConnection(String url, String user, String password, String schema) {
		Connection connection = null;
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection((url + schema), user, password);
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}
	
	public static Object closeConnection(Connection connection) {
		try {
			if (!connection.isClosed()) {
				connection.setAutoCommit(true);
				connection.close();
			}
		} catch (SQLException e) {
			return e;
		}
		return true;
	}
	
	public static String convertTextIntoImage(String text, String filePath, int imageWidth, int imageHeight, int textSize, String fontName, String imageType) {
		if (Utility.isBlank(text) || Utility.isBlank(filePath) || Utility.isBlank(imageWidth) || Utility.isBlank(imageHeight) || Utility.isBlank(textSize) || Utility.isBlank(fontName) || Utility.isBlank(imageType)) return null;
		BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setFont(new Font(fontName, Font.ITALIC, textSize));
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.BLACK);
		int textWidth = graphics.getFontMetrics().stringWidth(text);
		int textHeight = graphics.getFontMetrics().getHeight();
		int width = (imageWidth - textWidth) / 2;
		int height = (imageHeight - textHeight) / 2 + graphics.getFontMetrics().getAscent();
		graphics.drawString(text, width, height);
		try {
			ImageIO.write(image, imageType, new File(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}
	
	public static String getListFromJsonString(String json, String key) {
		if (Utility.isBlank(json)) return null;
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        try {
        	List<Map<String, Object>> list =  objectMapper.readValue(json, new TypeReference<List<Map<String, Object>>>() {});
        	result = getConcatenatedStringFromList(list, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getConcatenatedStringFromList(List<Map<String, Object>> list, String key) {
    	if (Utility.isBlank(list) || Utility.isBlank(key)) return null;
        String result = "";
        for (Map<String, Object> map : list) {
            if (map.containsKey(key)) {
                Object value = map.get(key);
                result = result + value + ",";
            }
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
	public static String removeKeysFromJson(String filePath, String[] key, String oldKey, String newKey) {
    	if (Utility.isBlank(key) || Utility.isBlank(filePath)) return null;
    	ObjectMapper objectMapper = new ObjectMapper();
    	String result = "";
    	Map<String, Object> map = jsonToMap(Files.readDataInJson(filePath));
		for (int j = 0; j < key.length; j++) {
			String[] keys = key[j].split("\\.");
			for (int i = 0; i < keys.length; i++) {
				if ((keys.length - 1) == i) {
					map.remove(keys[i]);
				} else if (map.get(keys[i]) instanceof List) {
					map.put(keys[i], removeKeyFromListOfMap((List<Map<String, Object>>) map.get(keys[i]),keys[keys.length - 1]));
				}
			}
		}
		try {
			result = objectMapper.writeValueAsString(map).replace(oldKey, newKey);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public static List<Map<String, Object>> removeKeyFromListOfMap(List<Map<String, Object>> list, String key) {
    	List<Map<String, Object>> map = new ArrayList<Map<String, Object>>();
    	for (Map<String, Object> nestedMap : list) {
    		nestedMap = removeKeyInMap(nestedMap, key);
    		map.add(nestedMap);
		}
    	return map;
    }
    
    @SuppressWarnings("unchecked")
	public static Map<String, Object> removeKeyInMap(Map<String, Object> map, String key) {
        for (String mapKey : map.keySet()) {
            Object value = map.get(mapKey);
            if (value instanceof Map) {
                Map<String, Object> nestedMap = removeKeyInMap((Map<String, Object>) value, key);
                map.put(mapKey, nestedMap);
            }
        }
        map.remove(key);
        return map;
    }

	public static List<File> getListOfFilePath(String fileName) {
		File[] roots = File.listRoots();
		List<File> foundFiles = new ArrayList<>();
		for (File root : roots) {
			List<File> rootFoundFiles = searchFiles(root.getAbsolutePath(), fileName);
			foundFiles.addAll(rootFoundFiles);
		}
		return foundFiles;
	}

	public static List<File> searchFiles(String directoryPath, String fileName) {
		List<File> foundFiles = new ArrayList<>();
		File directory = new File(directoryPath);
		if (directory.exists() && directory.isDirectory()) {
			File[] files = directory.listFiles();
			if (files != null) {
				for (File file : files) {
					if (file.getName().equalsIgnoreCase(fileName)) {
						foundFiles.add(file);
					}
					if (file.isDirectory()) {
						foundFiles.addAll(searchFiles(file.getAbsolutePath(), fileName));
					}
				}
			}
		}
		return foundFiles;
	}
	
	public static Map<String, Object> getMapWithKeyValue(List<Map<String, Object>> list, String key, Object value) {
		if (isBlank(list) || isBlank(key) || isBlank(value)) return null; 
		for (Map<String, Object> map : list) {
			if (map.containsKey(key) && map.get(key).equals(value)) {
				return map;
			}
		}
		return null;
	}
	
	/**
	 * this method is used to convert the given number into specified number format
	 * 
	 * @param number
	 * @param formatType
	 * @return formatNumber
	 */
//	public static String convertNumberToLocalizedFormat(int number, String formatType) {
//		if (isBlank(number)) return null;
//		String formatNumber = "";
//		String englishNumber = String.valueOf(number);
//		if (formatType.equalsIgnoreCase("ARABIC")) {
//			for (int i = 0; i < englishNumber.length(); i++) {
//				formatNumber += ARABIC_NUMBERS[(int) (englishNumber.charAt(i)) - 48];
//			}
//		} else if (formatType.equalsIgnoreCase("INDIAN")) {
//			for (int i = 0; i < englishNumber.length(); i++) {
//				formatNumber += INDIAN_NUMBERS[(int) (englishNumber.charAt(i)) - 48];
//			}
//		}
//		return formatNumber.isEmpty() ? englishNumber : formatNumber;
//	}
	
	public static String convertNumberToArabicNumber(int number) {
		if (isBlank(number)) return null;
		return convertNumberToLocalizedNumberString(number, ARABIC_NUMBERS);
	}
	
	public static String convertNumberToIndianNumber(int number) {
		if (isBlank(number)) return null;
		return convertNumberToLocalizedNumberString(number, INDIAN_NUMBERS);
	}
	
	public static String convertNumberToLocalizedNumberString(int number, char[] formatArray) {
		if (isBlank(number) || isBlank(formatArray)) return null;
		String localizedNumber = "";
		String englishNumber = String.valueOf(number);
		for (int i = 0; i < englishNumber.length(); i++) {
			localizedNumber += formatArray[(int) (englishNumber.charAt(i)) - 48];
		}
		return localizedNumber;
	}
	
}
