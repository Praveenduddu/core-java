package de.zeroco.utility;

import de.zeroco.exception.Animal;
import de.zeroco.exception.Dog;
import de.zeroco.util.Utility;

public class Exceptions {

	public static void main(String[] args) {
		try {
			Animal animal = new Animal();
			Dog dog = (Dog) animal;
			System.out.println(dog.sound());
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}

	public static String convertDeciToWords(double number) {
		String num = String.valueOf(number);
		String[] sepDeci = num.split("\\.");
		String outPut = Utility.ConvertNumbersToWords(Integer.parseInt(sepDeci[0])) + " and " + Utility.ConvertNumbersToWords(Integer.parseInt(sepDeci[1]));
		return outPut;
	}
}
