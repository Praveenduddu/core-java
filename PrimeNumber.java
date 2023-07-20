package de.zeroco.threads;

public class PrimeNumber extends Thread{
	public int number;
	public String result;
	
	public void run() {
		int count = 0;
		for(int i = 1; i <= number; i++) {
			if (number % i == 0) {
				count++;
			}
		}
		result = (count == 2) ? "It is prime" : "It is not prime";
		
	}

	public PrimeNumber(int number) {
		this.number = number;
	}

	public String getResult() {
		return result;
	}
}
