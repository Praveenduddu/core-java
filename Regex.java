package de.zeroco.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.zeroco.util.Utility;

public class Regex {

	public static void main(String[] args) {
//		System.out.println(checkCharIsMatch("praveen"));
//		System.out.println(checkCharInRange("dpraveen"));
//		System.out.println(occurrenceOfChar("prave"));
//		System.out.println(charOccurrence("praveenpra"));
//		System.out.println(isDigitInString("123"));
//		System.out.println(isWhiteSpaceInString("   "));
//		System.out.println(isValidLanNumber("08674246365"));
//		System.out.println(isValidPassword("Praveen12"));
//		System.out.println(isWordMatch("the to toStrong is very beautiful in very world", "to"));
		System.out.println(countTheOccurrenceOfWord("praveen praveen praveen", "n p"));
		System.out.println(getModifySentence("a earth is beartiful that a venus", "a", "the"));
		System.out.println(getPositionsOfWord("The world is beautiful", "world"));
		System.out.println(getWordInRegion("The world is to the end", "to", 0, 15));
	}

	public static boolean checkCharIsMatch(String name) {
		return Pattern.matches("p......", name);
	}

	public static boolean checkCharInRange(String name) {
		return Pattern.matches("[a-zA-Z && [^def]]", name);
	}

	public static boolean occurrenceOfChar(String name) {
		return Pattern.matches("[praveen]*", name);
	}
	
	public static boolean charOccurrence(String name) {
		return Pattern.matches("[praveen]+", name);
	}
	
	public static boolean isDigitInString(String number) {
		return Pattern.matches("\\d+", number);
	}
	
	public static boolean isWhiteSpaceInString(String space) {
		return Pattern.matches("\\s*", space);
	}
	
	public static boolean isWordWithInTheRange(String name) {
		return Pattern.matches("\\w+{10}", name);
	}
	
	public static boolean isValidLanNumber(String LanNumber) {
		if (Utility.isBlank(LanNumber)) return false;
		return Pattern.matches("[0][8][6][7][4][0-9]{6}", LanNumber);
	}
	
	public static boolean isValidPassword(String password) {
		if (Utility.isBlank(password)) return false;
		return Pattern.matches("[A-Z]{1,}[a-z]{1,}[0-9]{1,}", password);
	}
	
	public static String isWordMatch(String sentence, String word) {
		if (Utility.isBlank(word) || Utility.isBlank(sentence)) return null;
		Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(sentence);
		String match = "";
		while (matcher.find()) {
		    match = matcher.group() + "," + match;
		}
		return match;
	}
	
	public static int countTheOccurrenceOfWord(String sentence, String word) {
		Matcher matcher = Pattern.compile(word, Pattern.CASE_INSENSITIVE).matcher(sentence);
		int count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}
	
	public static String getModifySentence(String sentence, String oldWord, String newWord) {
		if (Utility.isBlank(sentence) || Utility.isBlank(oldWord) || Utility.isBlank(newWord)) return null;
		return sentence.replaceFirst(oldWord, newWord);
	}
	
	public static String getPositionsOfWord(String sentence, String word) {
		if (Utility.isBlank(sentence) || Utility.isBlank(word)) return null;
		Matcher matcher = Pattern.compile(word).matcher(sentence);
		if (matcher.find()) {
			return matcher.start() + " , " + matcher.end();
		}
		return "No Match Found";
	}
	
	public static String getWordInRegion(String sentence, String regex, int regionStart, int regionEnd) {
		if (Utility.isBlank(sentence) || Utility.isBlank(regex) || Utility.isBlank(regionEnd) || Utility.isBlank(regionStart)) return null;
		Matcher matcher = Pattern.compile(regex).matcher(sentence);
		matcher.region(regionStart, regionEnd);
		if (matcher.find()) {
			return matcher.group() + " , " + matcher.start() + " , " + matcher.end();
		}
		return "No Match Found";
	}
}
