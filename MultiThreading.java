package de.zeroco.threads;

public class MultiThreading {

	public static void main(String[] args) throws Exception {
		MultiThreading thread = new MultiThreading();
		MathOperations math = new MathOperations(2, 3);
		MathOperations mathOperations = new MathOperations(4, 5);
		PrimeNumber number = new PrimeNumber(7);
//		Streams stream = new Streams();
//		System.out.println(math.isAlive());
//		stream.start();
		math.start();
//		Thread.sleep(1);
//		System.out.println(math.isAlive());
//		math.join();
//		math.yield();
//		mathOperations.start();
//		mathOperations.join();
		number.start();
		number.join();
		System.out.println(number.getResult());
		thread.getNotify();
		System.out.println(math.isAlive());
//		System.out.println(math.isAlive());
//		mathOperations.yield();
//		System.out.println(math.getResult());
//		System.out.println(mathOperations.getResult());
	}

	public void getNotify() {
		synchronized (this) {
			notifyAll();
		}
	}
}
