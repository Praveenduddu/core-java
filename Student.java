package de.zeroco.utility;

import java.io.Serializable;

public class Student implements Serializable {
	private String name;
	private String rollNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
}
