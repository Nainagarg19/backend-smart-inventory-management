package com.springrest.inventoryManagement.springrest.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="user_name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="phone_no")
	private String phoneNo;
	@Column(name="type")
	private int type;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Godowns godowns;

	public Employee(int id, String name, String userName, String email, String password, String phoneNo, int type,
			Godowns godowns) {
		super();
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
		this.type = type;
		this.godowns = godowns;
	}

	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Godowns getGodowns() {
		return godowns;
	}

	public void setGodowns(Godowns godowns) {
		this.godowns = godowns;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", password="
				+ password + ", phoneNo=" + phoneNo + ", type=" + type + ", godowns=" + godowns + "]";
	}
	
	
	
	
}
