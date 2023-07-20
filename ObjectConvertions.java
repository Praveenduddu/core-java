package de.zeroco.utility;

import de.zeroco.util.Utility;

public class ObjectConvertions {

	public static void main(String[] args) {
		System.out.println(getObjectToInt(12));
		System.out.println(getObjectToDouble(32.3));
		System.out.println(getObjectToLong(123));
		System.out.println(getObjectToByte(13));
		System.out.println(getObjectToShort(123));
		System.out.println(getObjectToFloat(12.3));
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
}
