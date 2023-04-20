package com.springrest.inventoryManagement.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	private String employeeName;
	private String employeeUserName;
	private String employeeEmail;
	private String employeePassword;
	private String employeePhoneNo;
	private int employeeGoDownId;
	
	public Employee(int employeeId, String employeeName, String employeeUserName, String employeeEmail,
			String employeePassword, String employeePhoneNo, int employeeGoDownId) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeUserName = employeeUserName;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeePhoneNo = employeePhoneNo;
		this.employeeGoDownId = employeeGoDownId;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

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

	public String getEmployeeUserName() {
		return employeeUserName;
	}

	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeePhoneNo() {
		return employeePhoneNo;
	}

	public void setEmployeePhoneNo(String employeePhoneNo) {
		this.employeePhoneNo = employeePhoneNo;
	}

	public int getEmployeeGoDownId() {
		return employeeGoDownId;
	}

	public void setEmployeeGoDownId(int employeeGoDownId) {
		this.employeeGoDownId = employeeGoDownId;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeUserName="
				+ employeeUserName + ", employeeEmail=" + employeeEmail + ", employeePassword=" + employeePassword
				+ ", employeePhoneNo=" + employeePhoneNo + ", employeeGoDownId=" + employeeGoDownId + "]";
	}
	
	
}
