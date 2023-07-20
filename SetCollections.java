package de.zeroco.utility;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;

public class SetCollections {

	public static void main(String[] args) {
		HashSet<Integer> hashSet = new HashSet<Integer>();
		hashSet.add(12);
		hashSet.add(41);
		hashSet.add(31);
		hashSet.add(61);
		hashSet.add(81);
		hashSet.add(11);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(32);
		arrayList.add(42);
		arrayList.add(52);
		arrayList.add(62);
		arrayList.add(32);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(72);
		list.add(83);
		list.add(91);
		list.add(62);
		list.add(32);
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(89);
		array.add(29);
		array.add(69);
		array.add(59);
		array.add(49);
		LinkedHashSet<Integer> linkedHash = new LinkedHashSet<Integer>();
		linkedHash.add(12);
		linkedHash.add(45);
		linkedHash.add(53);
		linkedHash.add(89);
		linkedHash.add(12);
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(12);
		treeSet.add(45);
		treeSet.add(53);
		treeSet.add(89);
		treeSet.add(12);
		treeSet.add(39);
//		System.out.println(getData(hashSet, 2));
//		System.out.println(removeDuplicatesInList(arrayList));
//		System.out.println(list.size());
//		System.out.println(getIntersectionInLists(arrayList, list));
//		System.out.println(treeSet.ceiling(56) + " , " + treeSet.floor(44));
//		System.out.println(treeSet.descendingSet());
//		System.out.println(treeSet.first() + " , " + treeSet.last());
//		System.out.println(treeSet.lower(53) + " , " + treeSet.higher(45));
//		System.out.println(hashSet);
//		System.out.println(getUnionOfLists(arrayList, list));
		System.out.println(getUniqueElementsInLists(arrayList, list));
		System.out.println(getSortedList(array));
	}

	public static Object getData(HashSet<Integer> hashSet, int index) {
		Object[] result = hashSet.toArray();
		return result[index];
	}
	
	public static Object removeDuplicatesInList(ArrayList<Integer> arrayList) {
		HashSet<Integer> hashSet = new HashSet<Integer>(arrayList);
		return hashSet;
	}
	
	public static Object getIntersectionInLists(ArrayList<Integer> arrayList, ArrayList<Integer> list) {
		ArrayList<Integer> array = new ArrayList<Integer>(arrayList);
		array.retainAll(list);
		HashSet<Integer> hashSet = new HashSet<Integer>(array);
		return hashSet;
	}
	
	public static Object getUnionOfLists(ArrayList<Integer> arrayList, ArrayList<Integer> list) {
		LinkedHashSet<Integer> linkedHash = new LinkedHashSet<Integer>(arrayList);
		linkedHash.addAll(list);
		return linkedHash;
	}
	
	public static Object getUniqueElementsInLists(ArrayList<Integer> arrayList, ArrayList<Integer> list) {
		TreeSet<Integer> set = new TreeSet<Integer>(arrayList);
		TreeSet<Integer> treeSet = new TreeSet<Integer>(list);
		treeSet.removeAll(arrayList);
		set.removeAll(list);
		set.addAll(treeSet);
		return set;
	}
	
    public static TreeSet<Object> getSortedList(List<Object> list) {
    	TreeSet<Object> set = new TreeSet<Object>(list);
		return set;
	}
}
