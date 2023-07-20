package de.zeroco.utility;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.TreeSet;

public class Array {

	public static void main(String[] args) {
		Object[] firstArray = new Object[3];
		firstArray[0] = 12;
		firstArray[1] = "hello";
		firstArray[2] = 12.3;
		Object[][] thirdArray = new Object[3][2];
		thirdArray[0][0] = 12;
		thirdArray[0][1] = 24;
		thirdArray[1][0] = 12;
		thirdArray[1][1] = 24;
		thirdArray[2][0] = 12;
		thirdArray[2][1] = 24;
		Object secondArray[] = {12, 23, 54, 65, 72, 2, 65};
		Object forthArray[][] = {{12, 34}, {15, 18}};
		Object[] numbers = {23, 45, 11, 3, 76, 56, 11, 45, 65};
		Object[] array = new Object[5];
		Spliterator<Object> spliterator = Arrays.spliterator(numbers);
		int count = 0;
		spliterator.forEachRemaining((value) -> array[count] = value);
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.deepToString(forthArray));
//		System.out.println(secondArray[1]);
//		System.out.println(Arrays.deepToString(thirdArray));
//		System.out.println(thirdArray.length);
//		System.out.println(Arrays.toString(getSortedArray(numbers)));
//		System.out.println(getDuplicatesInArray(numbers));
//		System.out.println(Arrays.binarySearch(numbers, 11));
//		System.out.println(Arrays.toString(getUnionOfArray(numbers, secondArray)));
		System.out.println(Arrays.toString(getReverseArray(secondArray)));
		System.out.println(Arrays.toString(array));
		System.out.println(getUniqueElementsInArray(secondArray, numbers));
		Arrays.fill(array, secondArray);
		System.out.println(Arrays.deepToString(array));
		System.out.println(Arrays.toString(Arrays.copyOf(secondArray, 4)));
	}

	public static Object[] getSortedArray(Object[] array) {
		Arrays.sort(array);
		return array;
	}
	
	public static TreeSet<Object> getDuplicatesInArray(Object[] array) {
		TreeSet<Object> treeSet = new TreeSet<Object>();
		for (int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) treeSet.add(array[i]);
			}
		}
		return treeSet;
	}
	
	public static Object[] getUnionOfArray(Object[] firstArray, Object[] secondArray) {
		TreeSet<Object> treeSet = new TreeSet<Object>();
		treeSet.addAll(Arrays.asList(firstArray));
		treeSet.addAll(Arrays.asList(secondArray));
		Object[] array = {};
		array = treeSet.toArray(array);
		return array;
	}
	
	public static Object[] getReverseArray(Object[] array) {
		Object[] reverse = new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			reverse[i] = array[array.length - i - 1];
		}
//		return Collections.reverse(Arrays.asList(array));
		return reverse;
	}
	
	public static TreeSet<Object> getUniqueElementsInArray(Object[] firstArray, Object[] secondArray) {
		TreeSet<Object> treeSet = new TreeSet<Object>();
		for (int i = 0; i < firstArray.length; i++) {
			int count = 0;
			for (int j = 0; j < secondArray.length; j++) {
				if (firstArray[i] == secondArray[j]) count++;
			}
			if (count == 0) treeSet.add(firstArray[i]);
		}
		return treeSet;
	}
	
}
