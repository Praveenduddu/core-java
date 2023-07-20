package de.zeroco.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import de.zeroco.util.Utility;



public class MapCollections {

	public static void main(String[] args) {
		HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
//		hashMap.put(7, "ram");
//		hashMap.put(1, "sam");
//		hashMap.put(3, "ravi");
//		hashMap.put(2, "kiran");
//		hashMap.put(4, "jaggu");
//		System.out.println(hashMap.entrySet());
//		hashMap.put(null, null);
//		System.out.println(hashMap);
//		LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
//		linkedHashMap.put(1, 2);
//		linkedHashMap.put(2, 6);
//		linkedHashMap.put("kiran", 5);
//		linkedHashMap.put("ravi", 7);
//		linkedHashMap.put(null, null);
//		System.out.println(linkedHashMap);
//		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
//		treeMap.put(3, "praveen");
//		treeMap.put(4, "ram");
//		treeMap.put(5, "sam");
//		treeMap.put(6, "gopi");
//		TreeMap<Object, Object> treeMap1 = new TreeMap<Object, Object>();
//		treeMap1.put(6, "gopi");
//		treeMap1.put(7, "praveen");
//		treeMap1.put("second", "ram");
//		treeMap1.put("third", "sam");
//		System.out.println(treeMap);
//		System.out.println(treeMap1);
		TreeMap<String, String> tree = new TreeMap<String, String>();
		tree.put("ram", "9573458149");
		tree.put("sam", "8332819666");
		tree.put("bheem", "9987573727");
		tree.put("kiran", "7276528542");
		System.out.println(tree.entrySet());
//		System.out.println(linkedHashMap);
//		System.out.println(hashMap.entrySet());
//		System.out.println(linkedHashMap.values());
//		System.out.println(linkedHashMap.keySet());
//		System.out.println(getSortMap(linkedHashMap));
//		System.out.println(treeMap.ceilingKey(8.2));
//		System.out.println(treeMap.ceilingEntry(8.2));
//		System.out.println(treeMap.floorKey(8.2));
//		System.out.println(treeMap.floorEntry(8.2));
//		System.out.println(treeMap.higherKey(8.3));
//		System.out.println(treeMap.higherEntry(8.3));
//		System.out.println(treeMap.lowerKey(8.3));
//		System.out.println(treeMap.lowerEntry(8.3));
//		System.out.println(hashMap.computeIfAbsent(1, key -> "praveen"));
//		System.out.println(hashMap.computeIfAbsent(6, key -> "praveen"));
//		System.out.println(hashMap.computeIfPresent(1, (key, value) -> "praveen"));
//		System.out.println(hashMap);
//		System.out.println(getUnionOfMaps(hashMap, treeMap));
//		System.out.println(getIntersectionKeys(hashMap, treeMap));
//		System.out.println(getIntersectionValues(hashMap, treeMap));
//		System.out.println(getUniqueKeysInMap(hashMap, treeMap));
//		System.out.println(getUniqueValuesInMap(hashMap, treeMap));
//		System.out.println(getPhoneNumber(tree, "sam"));
//		System.out.println(tree.descendingKeySet());
//		System.out.println(tree.navigableKeySet());
//		System.out.println(tree.headMap("kiran"));
//		System.out.println(addPhoneNumber(tree, "ram", "7276894568"));
//		System.out.println(tree);
//		System.out.println(editPhoneNumber(tree, "sam", "8956342156"));
//		System.out.println(tree);
//		System.out.println(countOccurrenceOfWord("the world is beautiful with the green trees"));
	}
	
	public static Map<Object, Object> getSortMap(Map<Object, Object> map) {
		if (Utility.isBlank(map)) return null;
		Map<Object, Object> treeMap = new TreeMap<Object, Object>(map);
		return treeMap;
	}
	
	public static Map<Object, Object> getUnionOfMaps(Map<Object, Object> firstMap, Map<Object, Object> secondMap) {
		if (Utility.isBlank(firstMap) || Utility.isBlank(secondMap)) return null;
		TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>(firstMap);
		treeMap.putAll(secondMap);
		return treeMap;
	}
	
	public static TreeSet<Object> getIntersection(List<Object> firstList, List<Object> secondList) {
		if (Utility.isBlank(firstList) || Utility.isBlank(secondList)) return null;
		TreeSet<Object> treeSet = new TreeSet<Object>();
		Iterator<Object> iterator = firstList.iterator();
		while (iterator.hasNext()) {
			Object element = iterator.next();
			if (secondList.contains(element)) {
				treeSet.add(element);
			}
		}
		return treeSet;
	}
	
	public static TreeSet<Object> getIntersectionKeys(Map<Object, Object> firstMap, Map<Object, Object> secondMap) {
		if (Utility.isBlank(firstMap) || Utility.isBlank(secondMap)) return null;
		ArrayList<Object> firstList = new ArrayList<Object>(firstMap.keySet());
		ArrayList<Object> secondList = new ArrayList<Object>(secondMap.keySet());
		return getIntersection(firstList, secondList);
	}
	
	public static TreeSet<Object> getIntersectionValues(Map<Object, Object> firstMap, Map<Object, Object> secondMap) {
		if (Utility.isBlank(firstMap) || Utility.isBlank(secondMap)) return null;
		ArrayList<Object> firstList = new ArrayList<Object>(firstMap.values());
		ArrayList<Object> secondList = new ArrayList<Object>(secondMap.values());
		return getIntersection(firstList, secondList);
	}
	
	public static TreeSet<Object> getUniqueElements(List<Object> firstList, List<Object> secondList) {
		if (Utility.isBlank(firstList) || Utility.isBlank(secondList)) return null;
		TreeSet<Object> treeSet = new TreeSet<Object>(firstList);
		treeSet.removeAll(secondList);
		return treeSet;
	}
	
	public static TreeSet<Object> getUniqueKeysInMap(Map<Object, Object> firstMap, Map<Object, Object> secondMap) {
		if (Utility.isBlank(firstMap) || Utility.isBlank(secondMap)) return null;
		ArrayList<Object> firstList = new ArrayList<Object>(firstMap.keySet());
		ArrayList<Object> secondList = new ArrayList<Object>(secondMap.keySet());
		return getUniqueElements(firstList, secondList);
	}
	
	public static TreeSet<Object> getUniqueValuesInMap(Map<Object, Object> firstMap, Map<Object, Object> secondMap) {
		if (Utility.isBlank(firstMap) || Utility.isBlank(secondMap)) return null;
		ArrayList<Object> firstList = new ArrayList<Object>(firstMap.values());
		ArrayList<Object> secondList = new ArrayList<Object>(secondMap.values());
		return getUniqueElements(firstList, secondList);
	}
	
	public static Object getPhoneNumber(Map<String, String> map, String name) {
		if (Utility.isBlank(map) || Utility.isBlank(name)) return null;
		return map.get(name);
	}
	
	public static Object addPhoneNumber(Map<String, String> map, String name, String number) {
		if (Utility.isBlank(map) || Utility.isBlank(name) || Utility.isBlank(number)) return null;
		return map.computeIfAbsent(name, key -> number);
	}
	
	public static Object editPhoneNumber(Map<String, String> map, String name, String number) {
		if (Utility.isBlank(map) || Utility.isBlank(name) || Utility.isBlank(number)) return null;
		return map.computeIfPresent(name, (key, value) -> value+","+number);
	}
	
	public static Object countOccurrenceOfWord(String sentence) {
		if (Utility.isBlank(sentence)) return null;
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		String[] words = sentence.split("\\s+");
		for (String word : words) {
            if (!treeMap.containsKey(word)) {
                treeMap.put(word, 1);
            } else {
                treeMap.put(word, treeMap.get(word) + 1);
            }
        }
		return treeMap;
	}
}
