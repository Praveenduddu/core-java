package de.zeroco.exception;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import de.zeroco.exception.UnderAgeException;
import de.zeroco.exception.UnsufficientFundsException;

public class UserDefinedException {

	public static void main(String[] args) throws UnsufficientFundsException {
		System.out.println(UserDefinedException.checkEligibity(18));
		System.out.println(UserDefinedException.isEven(4));
		System.out.println(UserDefinedException.withdrawalAmount(3000));
	}

	public static String checkEligibity(int age) {
		if (age < 18)
			throw new UnderAgeException("You are not eligible to vote");
		return "You are eligible to vote";
	}

	public static String isEven(int value) {
		if (value % 2 != 0)
			throw new ArithmeticException("Give number is not even");
		return "Given number is even";
	}

	public static String withdrawalAmount(int amount) throws UnsufficientFundsException {
		if (amount < 2000)
			throw new UnsufficientFundsException("Unsufficient Balance");
		return "Withdrawl successful";
	}
}
