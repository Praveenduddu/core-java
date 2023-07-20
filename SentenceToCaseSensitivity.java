package de.zeroco.util;

public class SentenceToCaseSensitivity {

	public static void main(String[] args) {
		System.out.println(SentenceToCaseSensitivity.toPascalCasing("hello world"));
		System.out.println(SentenceToCaseSensitivity.toCamelCasing("hello world"));
		System.out.println(SentenceToCaseSensitivity.toSentenceCasing("World Is Very Small"));
	}

	public static String toPascalCasing(String sentence) {
		String[] getSentence = sentence.split(" ");
		for (int i = 0; i <= getSentence.length - 1; i++) {
			getSentence[i] = (getSentence[i].substring(0, 1).toUpperCase())
					+ (getSentence[i].substring(1).toLowerCase());
		}
		String sentenceInPascal = (String.join(",", getSentence)).replace(",", "");
		return sentenceInPascal;
	}

	public static String toCamelCasing(String sentence) {
		String[] getSentence = sentence.split(" ");
		for (int i = 1; i <= getSentence.length - 1; i++) {
			getSentence[i] = (getSentence[i].substring(0, 1).toUpperCase())
					+ (getSentence[i].substring(1).toLowerCase());
		}
		String sentenceInCamel = (String.join(",", getSentence)).replace(",", "");
		return sentenceInCamel;
	}

	public static String toSentenceCasing(String sentence) {
		String[] getSentence = sentence.split(" ");
		if (true) {
			getSentence[0] = (getSentence[0].substring(0, 1).toUpperCase())
					+ (getSentence[0].substring(1).toLowerCase());
		}
		if (true) {
			for (int j = 1; j <= getSentence.length - 1; j++) {
				getSentence[j] = getSentence[j].toLowerCase();
			}
		}
		String sentenceCasing = (String.join(",", getSentence)).replace(",", " ");
		return sentenceCasing;
	}
}
