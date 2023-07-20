package de.zeroco.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		System.out.println(timeTakenByInputStream("C:\\Users\\91834\\Desktop\\files\\Hello.txt"));
		System.out.println(timeTakenByFileReader("C:\\Users\\91834\\Desktop\\files\\Hello.txt"));
		System.out.println(timeTakenByBufferedReader("C:\\Users\\91834\\Desktop\\files\\Hello.txt"));
	}

	public static long timeTakenByInputStream(String filePath) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(filePath);
			while (inputStream.read() != -1) {
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		return (endTime - startTime);
	}
	
	public static long timeTakenByFileReader(String filePath) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(filePath);
			while (fileReader.read() != -1) {
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		return (endTime - startTime);
	}
	
	public static long timeTakenByBufferedReader(String filePath) {
		long startTime;
		long endTime;
		startTime = System.currentTimeMillis();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(filePath));
			while (bufferedReader.read() != -1) {
            }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		return (endTime - startTime);
	}
}
