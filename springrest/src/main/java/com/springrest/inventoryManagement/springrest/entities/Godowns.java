package com.springrest.inventoryManagement.springrest.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Godowns {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int godown_Id;
	private String location;
	private int capacity;
	private String manager;
	private Date start_date;
	
	public Godowns(int godown_Id, String location, int capacity, String manager, Date start_date) {
		super();
		this.godown_Id = godown_Id;
		this.location = location;
		this.capacity = capacity;
		this.manager = manager;
		this.start_date = start_date;
	}
	public Godowns() {
		super();
	}
	public int getGodown_Id() {
		return godown_Id;
	}
	public void setGodown_Id(int godown_Id) {
		this.godown_Id = godown_Id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	@Override
	public String toString() {
		return "Godowns [godown_Id=" + godown_Id + ", location=" + location + ", capacity=" + capacity + ", manager="
				+ manager + ", start_date=" + start_date + "]";
	}
	
	
}
