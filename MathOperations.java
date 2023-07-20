package de.zeroco.threads;

public class MathOperations extends Thread {
	public int firstValue;
	public int secondValue;
	public int result;
	
	public MathOperations(int firstValue, int secondValue) {
		this.firstValue = firstValue;
		this.secondValue = secondValue;
	}

	public void run() {
//		productOfTheValues(firstValue, secondValue);
		sumOfTheValues(firstValue, secondValue);
	}

	public synchronized int sumOfTheValues(int firstValue, int secondValue) {
		try {
			this.wait(5000);
			for (int i = 0; i <= 10; i++) {
				result = firstValue + secondValue;
				firstValue++;
				secondValue++;
				System.out.println(result + ".....");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int productOfTheValues(int firstValue, int secondValue) {
		for (int i = 0; i <= 10; i++) {
			result = firstValue * secondValue;
			firstValue++;
			secondValue++;
			System.out.println(result + "-------");
		}
		return result;
	}
	
	public int getResult() {
		return result;
	}

}
