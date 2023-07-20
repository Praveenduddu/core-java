package de.zeroco.utility;

public class WrapperClass{

	public static void main(String[] args) {
//		System.out.println(getBoxingValue(10));
//		System.out.println(getUnboxingValue(20));
//		System.out.println(getStringToInt("40"));
//		System.out.println(Integer.highestOneBit(20));
//		System.out.println(Integer.lowestOneBit(20));
//		System.out.println(Integer.bitCount(20));
//		System.out.println(Integer.decode("0x123"));
//		System.out.println(Integer.sum(10, 20));
//		System.out.println(getOctalValue(23));
//		System.out.println(getHexaValue(310));
//		System.out.println(Integer.numberOfLeadingZeros(123));
//		System.out.println(Integer.numberOfTrailingZeros(123));
//		System.out.println(Integer.valueOf("20"));
//		System.out.println(Double.isFinite(0/10));
//		System.out.println(Character.isLetterOrDigit('1'));
//		System.out.println(Character.isWhitespace(' '));
//		System.out.println(getCharAtIndex("hello world", 6));
//		System.out.println(Character.getNumericValue('z'));
//		System.out.println(Character.digit('A', 16));
//		System.out.println(Character.getType('A'));
//		System.out.println(Character.MAX_CODE_POINT);
//		System.out.println(Character.SIZE);
//		System.out.println(Character.isIdentifierIgnorable('\u200C'));
//		System.out.println(Character.getName('A'));
//		System.out.println(Boolean.logicalAnd(true, false));
//		System.out.println(Boolean.logicalOr(true, false));
//		System.out.println(Boolean.logicalXor(true, true));
//		System.out.println(Double.parseDouble("12.2"));
		System.out.println(getBinaryCodeOfNumber(12));
	}

	public static Integer getBoxingValue(int value) {
		Integer result=Integer.valueOf(value); //explicitly
		return result;
	}
	
	public static int getUnboxingValue(Integer value) {
		int result=value.intValue(); //explicitly
		return result;
	}
	
	public static Integer getStringToInt(String number) {
		return Integer.parseInt(number);
	}
	
	public static String getOctalValue(int number) {
		return Integer.toOctalString(number);
	}
	
	public static String getHexaValue(int number) {
		return Integer.toHexString(number);
	}
	
	public static String getCharAtIndex(String sentence, int index) {
		return Character.toString((char) Character.codePointAt(sentence, index));
	}
	
	public static String getBinaryCodeOfNumber(Integer number) {
		return Long.toBinaryString(number);
	}
}
