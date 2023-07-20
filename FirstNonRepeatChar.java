package de.zeroco.strings;

public class FirstNonRepeatChar {

	public static void main(String[] args) {
		System.out.println(FirstNonRepeatChar.firstNonRepeatChar("praveen pra"));
	}

	public static char firstNonRepeatChar(String sentence) {
		char nonRepeatChar = 0;
		for (int i = 0; i <= sentence.length() - 1; i++) {
			if (sentence.indexOf(sentence.charAt(i)) == sentence.lastIndexOf(sentence.charAt(i))) {
				nonRepeatChar = sentence.charAt(i);
				break;
			}
		}
		return nonRepeatChar;
	}

}
