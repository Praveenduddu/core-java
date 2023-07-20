package de.zeroco.strings;

public class RemoveDuplicatesInString {

	public static void main(String[] args) {
		System.out.println(RemoveDuplicatesInString.removeDuplicates("praveen praveen praveen", "pra"));
	}

	public static StringBuilder removeDuplicates(String source, String key) {
		StringBuilder result = new StringBuilder();
		for (char c : source.toCharArray()) {
			if (key.indexOf(c) == -1) {
				result.append(c);
			}
		}
		return result;
	}

}
