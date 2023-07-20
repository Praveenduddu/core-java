package de.zeroco.exception;

public class TypesOfExceptions {

	public static void main(String[] args) {
		System.out.println(TypesOfExceptions.division(10, 2));
		System.out.println(TypesOfExceptions.getCharacter("pavan", 2));
		int[] studentAges = {21, 23, 24, 20, 22};
		System.out.println(TypesOfExceptions.getStudentAge(studentAges, 0));
	}

	public static int division(int firstVariable, int secondVariable) {
		int divide = 0;
		try {
			divide = firstVariable / secondVariable;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		return divide;
	}

	public static char getCharacter(String name, int index) {
		char charByIndex = ' ';
		try {
			charByIndex = name.charAt(index);
		} catch (NullPointerException | StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			
		}
		return charByIndex;
	}

	public static int getStudentAge(int[] age, int index) {
		int ageByIndex = 0;
		try {
			ageByIndex = age[index];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return ageByIndex;
	}
	
}
