package de.zeroco.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class School {

	public static void main(String[] args) {
		System.out.println(getSerializedObject("C:\\Users\\91834\\Desktop\\files\\Java.txt", "Ram", "18481A0334"));
		System.out.println(getDeserializedObject("C:\\Users\\91834\\Desktop\\files\\Java.txt"));
	}

	public static String getSerializedObject(String filePath, String name, String rollNumber) {
		Student student = new Student();
		student.setName(name);
		student.setRollNumber(rollNumber);
		ObjectOutputStream objectOutputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(student);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return filePath;
	}
	
	public static Object getDeserializedObject(String filePath) {
		Object object = null;
		ObjectInputStream objectInputStream = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(filePath);
			objectInputStream = new ObjectInputStream(fileInputStream);
			object = (Student) objectInputStream.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectInputStream.close();
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return object;
	}
}
