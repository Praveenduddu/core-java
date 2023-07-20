package de.zeroco.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import de.zeroco.util.Utility;

import java.util.List;
import java.util.Stack;
import java.util.Iterator;
import java.util.LinkedList;

public class ListCollections {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(12);
		arrayList.add(35);
		arrayList.add(45);
		arrayList.add(55);
		arrayList.add(35);
		arrayList.add(65);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(35);
		list.add(85);
		list.add(55);
		list.add(95);
		list.add(15);
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(55);
		linkedList.add(66);
		linkedList.add(11);
		linkedList.add(22);
		linkedList.add(88);
		Vector<Integer> vector = new Vector<Integer>();
		vector.addElement(11);
		vector.addElement(21);
		vector.addElement(31);
		vector.addElement(41);
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(12);
		stack.add(22);
		stack.push(32);
		stack.push(42);
//		System.out.println(hasNumber(arrayList, 35));
//		System.out.println(getTheData(arrayList, 2));
//		System.out.println(getIndex(arrayList, 1, 5, 55));
//		System.out.println(getLastIndex(arrayList, 35));
//		System.out.println(getSize(arrayList));
//		System.out.println(isEmpty(arrayList));
//		System.out.println(getIterate(arrayList));
//		System.out.println(getTheElement(linkedList));
//		System.out.println(getDecIterate(linkedList));
//		System.out.println(getCapacity(vector));
//		System.out.println(searchElement(stack));
//		System.out.println(getSumOfEvenNumber(arrayList));
//		System.out.println(sumOfPrimeNumber(arrayList));
//		System.out.println(removeDuplicatesInList(arrayList));
		System.out.println(getUniqueDataInList(arrayList, list));
		System.out.println(getReverseList(linkedList));
	}

	public static boolean hasNumber(ArrayList<Integer> arrayList, int number) {
		return arrayList.contains(number);
	}
	
	public static Object getTheData(ArrayList<Integer> arrayList, int index) {
		return arrayList.get(index);
	}
	
	public static Object getIndex(ArrayList<Integer> arrayList, int startIndex, int endIndex, int number) {
		List<Integer> list = arrayList.subList(startIndex, endIndex);
		return list.indexOf(number);
	}
	
	public static Object getLastIndex(ArrayList<Integer> arrayList, int number) {
		return arrayList.lastIndexOf(number);
	}
	
	public static Object getSize(ArrayList<Integer> arrayList) {
		return arrayList.size();
	}
	
	public static Object isEmpty(ArrayList<Integer> arrayList) {
		return arrayList.isEmpty();
	}
	
	public static Object getIterate(ArrayList<Integer> arrayList) {
		Iterator<Integer> result = arrayList.iterator();
		String outPut = "";
		while(result.hasNext()) {
			outPut = result.next() + "-->" + outPut;
		}
		return outPut;
	}
	
	public static Object getTheElement(LinkedList<String> linkedList) {
		return linkedList.peek() + "," + linkedList.peekLast() + "," + linkedList.pollFirst() + "," + linkedList.peekFirst();
	}
	
	public static Object getDecIterate(LinkedList<String> linkedList) {
		Iterator<String> iterator = linkedList.descendingIterator();
		String outPut = "";
		while(iterator.hasNext()) {
			outPut = iterator.next() + "-->" + outPut;
		}
		return outPut;
	}
	
	public static Object getCapacity(Vector<Integer> vector) {
		vector.insertElementAt(51, 1);
		return vector.firstElement() + "," + vector.lastElement() + "," + vector.capacity() + "," + vector.elementAt(1);
	}
	
	public static Object searchElement(Stack<Integer> stack) {
		return stack.pop() + "," + stack.peek() + "," + stack.search(32);
	}
	
	public static int getSumOfEvenNumber(ArrayList<Integer> arrayList) {
		int sum = 0;
		for (Integer number : arrayList) {
			if (number % 2 == 0) sum = sum + number;
		}
		return sum;
	}
	
	public static int sumOfPrimeNumber(ArrayList<Integer> arrayList) {
		Iterator<Integer> iterator = arrayList.iterator();
		int sum = 0;
		while (iterator.hasNext()) {
			int element = Utility.getObjectToInt(iterator.next());
			for (int i = 2 ; i < element; i++) {
				if (element % i == 0) {
					sum = sum - element;
					break;
				}
			}
			sum = sum + element;
		}
		return sum;
	}
	
	public static ArrayList<Integer> removeDuplicatesInList(ArrayList<Integer> arrayList) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (Integer check : arrayList) {
			if(!list.contains(check)) {
				list.add(check);
			}
		}
		return list;
	}
	
	public static ArrayList<Integer> getUniqueDataInList(ArrayList<Integer> firstList, ArrayList<Integer> secondList) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Iterator<Integer> iterate = firstList.iterator();
		Iterator<Integer> iterator = secondList.iterator();
		while (iterate.hasNext()) {
			Integer element = iterate.next();
			if (!secondList.contains(element)) {
				arrayList.add(element);
			}
		}
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (!firstList.contains(element)) {
				arrayList.add(element);
			}
		}
		return arrayList;
	}
	
	public static LinkedList<Integer> getReverseList(LinkedList<Integer> linkedList) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Iterator<Integer> iterator = linkedList.descendingIterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}
	
}
