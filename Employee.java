package de.zeroco.javabean;

import java.io.Serializable;

public class Employee implements Serializable {
	int employeeId;
	String employeeName;
	long mobileNumber;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setEmployeeId(23289);
		employee.setEmployeeName("Praveen");
		employee.setMobileNumber(956543432);
		System.out.println(employee.getEmployeeId());
		System.out.println(employee.getEmployeeName());
		System.out.println(employee.getMobileNumber());
	}
}
