package com.springrest.inventoryManagement.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemId;
	
	private int quantity;
	private String itemName;

	
	public Stock(int itemId, int quantity, String itemName) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.itemName = itemName;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Stock [itemId=" + itemId + ", quantity=" + quantity + ", itemName=" + itemName + "]";
	}
	
		
}
