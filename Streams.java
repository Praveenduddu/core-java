package de.zeroco.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import de.zeroco.util.Utility;

public class Streams extends Thread {

	public static void main(String[] args) {
//		Runnable run = () -> System.out.println("hello");
//		run.run();
//		Object[] array = {4, 8, 2, 5, 6, 9, 1, 3};
//		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		List<Object> lists = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		String[] firstArray = {"a", "b", "c", "e", "f"};
		String[] secondArray = {"b", "c", "d"};
//		List<String> names = Arrays.asList("ram", "sam", "raju", "bheem", "raghu", "somu");
//		System.out.println(getSortedArray(array));
//		System.out.println(sumOfEvenNumbersInList(list));
//		System.out.println(productOfOddNumbersInList(list));
//		list.stream().map(n -> n * 2).forEach(n -> System.out.println(n));
//		getFilterNamesFromList(names, "sa").forEach(n -> System.out.println(n));
//		System.out.println(list.stream().count());
//		System.out.println(list.stream().findAny());
//		System.out.println(list.stream().findFirst());
//		System.out.println(getMultiplesOfGivenNumber(12, 10));
//		System.out.println(convertListToSet(lists));
		System.out.println(Arrays.toString(getUniqueElementsInArray(firstArray, secondArray)));
	}

//	public void run() {
//		Object[] array = {4, 8, 2, 5, 6, 9, 1, 3};
//		System.out.println(getSortedArray(array));
//	}
	
	public static List<Object> getSortedArray(Object[] array) {
		if (Utility.isBlank(array)) return null;
		List<Object> list = Arrays.asList(array);
		return list.stream().sorted().collect(Collectors.toList());
	}
	
	public static int sumOfEvenNumbersInList(List<Integer> list) {
		if (Utility.isBlank(list)) return 0;
		return list.stream().filter(number -> number % 2 == 0).mapToInt(Integer :: intValue).sum();
	}
	
	public static Integer productOfOddNumbersInList(List<Integer> list) {
		if (Utility.isBlank(list)) return 0;
		return list.stream().filter(number -> number % 2 != 0).reduce(1, (firstNumber, secondNumber) -> firstNumber * secondNumber);
	}
	
	public static Stream<Object> getFilterNamesFromList(List<String> list, String startingLetters) {
		if (Utility.isBlank(list) || Utility.isBlank(startingLetters)) return null;
		return list.stream().filter(name -> name.startsWith(startingLetters)).map(String :: toUpperCase);
	}
	
	public static List<Object> getMultiplesOfGivenNumber(int number, int size) {
		if (Utility.isBlank(number) || Utility.isBlank(size)) return null;
		return Stream.iterate(1, element -> element + 1).filter(element -> element % number == 0).limit(size).collect(Collectors.toList());
	}
	
	public static Set<Object> convertListToSet(List<Object> list) {
		if (Utility.isBlank(list)) return null;
		return list.stream().collect(Collectors.toSet());
	}
	
	public static String[] getUniqueElementsInArray(String[] firstArray, String[] secondArray) {
		return Arrays.stream(firstArray).filter(element -> !Arrays.asList(secondArray).contains(element)).toArray(String[] :: new);
	}
}
