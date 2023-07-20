package de.zeroco.util;

public class CountDuplicates {

	public static void main(String[] args) {
		//System.out.println(CountDuplicates.duplicatesInString("Now is the time to make real the promises of democracy. Now is the time to rise from the dark and desolate valley of segregation to the sunlit path of racial justice. Now is the time to lift our nation from the quicksands of racial injustice to the solid rock of brotherhood", "the"));
//		System.out.println(source.indexOf(key));
//		System.out.println(key.length());
//		System.out.println(source.substring(9));
	//	System.out.println(CountDuplicates.countKeyOccurances("praveen praveen praveen praveen", "n p"));
		System.out.println(CountDuplicates.countKeyOccurances("praveen praveen praveen", ""));
	//	System.out.println(CountDuplicates.countOccurrences("praveen praveen praveen praveen", "pra"));
	}

	//occuranceCountOfKey
	//countOfRepeatedValues
	//countOfDuplicateString
	//countOfRepeatedVariables
	//
	public static int countKeyOccurs(String source, String key) {
		if(Utility.isBlank(key) || Utility.isBlank(source)) return 0;
		char[] charSource = source.toLowerCase().toCharArray();
		char[] charKey = key.toLowerCase().toCharArray();
		int checkCount = 0;
		int finalCount = 0;
		for (int i = 0; i <= charSource.length - 1; i++) {
			if (charSource[i] == charKey[0]) {
				for (int j = 0, k = i; j <= charKey.length - 1 && k <= charSource.length - 1; j++, k++) {
					if (charSource[k] == charKey[j]) {
						checkCount++;
					}
				}
				if (checkCount == charKey.length)
					finalCount++;
				checkCount = 0;
			}
		}
		return finalCount;
	}
	
	public static int countKeyOccurances(String source, String key) {
		if(Utility.isBlank(key) || Utility.isBlank(source)) return 0;
		return (source.indexOf(key)!= -1) ? (1 + countKeyOccurances(source.substring(source.indexOf(key) + key.length()), key)) : 0;
	}
	
}
