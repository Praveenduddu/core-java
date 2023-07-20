package de.zeroco.utility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class SplitMethod {

	public static void main(String[] args) {
		StringTokenizer stringTokenizer = new StringTokenizer("this is");
		if (stringTokenizer.hasMoreElements()) {
			System.out.println(stringTokenizer.countTokens());
			System.out.println(stringTokenizer.nextElement());
			System.out.println(stringTokenizer.nextToken());
		}
		System.out.println(SplitMethod.splitByTabChar("hello 	the	 world 	is beautiful"));
		System.out.println(SplitMethod.splitByDot("hello.the	 world 	is beautiful"));
		System.out.println(SplitMethod.splitBySpace("heloo     world"));
		System.out.println(SplitMethod.splitByChar("abcdefg"));
	}

	public static String splitByTabChar(String sentence) {
		String[] words = sentence.split("\t");
		return Arrays.toString(words);
	}
	
	public static String splitByDot(String sentence) {
		String[] words = sentence.split("\\.");
		return Arrays.toString(words);
	}
	
	public static String splitBySpace(String sentence) {
		String[] words = sentence.split("\\s+");
		return Arrays.toString(words);
	}
	
	public static String splitByChar(String sentence) {
		String[] words = sentence.split("abc");
		return Arrays.toString(words);
	}

}
