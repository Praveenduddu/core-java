package de.zeroco.strings;

public class TypesOfMethods {

	public static void main(String[] args) {
		System.out.println(TypesOfMethods.lowerCase(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.upperCase(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.trims(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.charArray(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.charsAt(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.contain(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.getvalueOf());
		System.out.println(TypesOfMethods.indexsOf(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.interns(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.lengths(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.replaces(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.subStrings(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.splits(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.stringStartWith(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.stringEndWith(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.replacesAll(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.concation(" The world is so beautiful to see "));
		System.out.println(TypesOfMethods.reverseString(new StringBuffer("hello world")));
		System.out.println(TypesOfMethods.stringCapacity(new StringBuffer("hello world")));
		System.out.println(TypesOfMethods.insert(new StringBuffer("hello world")));
		System.out.println(TypesOfMethods.deleteChar(new StringBuffer("hello world")));
		System.out.println(TypesOfMethods.appends(new StringBuilder("hello world ")));
		System.out.println(TypesOfMethods.rangeOfSubString(new StringBuilder("hello world ")));
	}

	public static String lowerCase(String sentence) {
		return sentence.toUpperCase();
	}

	public static String upperCase(String sentence) {
		return sentence.toLowerCase();
	}

	public static String trims(String sentence) {
		return sentence.trim();
	}

	public static String interns(String sentence) {
		return sentence.intern();
	}

	public static String getvalueOf() {
		return String.valueOf("10");
	}

	public static String[] splits(String sentence) {
		return sentence.split(" ");
	}

	public static char[] charArray(String sentence) {
		return sentence.toCharArray();
	}

	public static String replaces(String sentence) {
		return sentence.replace(" ", ",");
	}

	public static int indexsOf(String sentence) {
		return sentence.indexOf("z");
	}

	public static int charsAt(String sentence) {
		return sentence.charAt(3);
	}

	public static int lengths(String sentence) {
		return sentence.length();
	}

	public static String subStrings(String sentence) {
		return sentence.substring(2);
	}

	public static boolean contain(String sentence) {
		return sentence.contains("world");
	}

	public static boolean stringStartWith(String sentence) {
		return sentence.startsWith(" ");
	}

	public static boolean stringEndWith(String sentence) {
		return sentence.endsWith(" ");
	}

	public static String replacesAll(String sentence) {
		return sentence.replaceAll("\\s", "1++");
	}

	public static String concation(String sentence) {
		return sentence.concat("It is beautiful");
	}

	public static StringBuffer reverseString(StringBuffer sentence) {
		return sentence.reverse();
	}

	public static int stringCapacity(StringBuffer sentence) {
		return sentence.capacity();
	}

	public static StringBuffer insert(StringBuffer sentence) {
		return sentence.insert(3, "yes");
	}
	
	public static StringBuffer deleteChar(StringBuffer sentence) {
		return sentence.deleteCharAt(2);
	}
	
	public static StringBuilder appends(StringBuilder sentence) {
		return sentence.append("it is beauty");
	}
	
	public static String rangeOfSubString(StringBuilder sentence) {
		return sentence.substring(0, 1);
	}
	
	public static int indexsOfs(StringBuffer sentence) {
		return sentence.indexOf("h");
	}
}
