package com.springrest.inventoryManagement.springrest.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Inwards {
	@Id
	private int inwards_Id;
	private int godown_id;
	private String item_name;
	private String supplier_name;
	private Date date_of_supply;
	private int invoice_no;
	private int quantity;
	private String recieved_by;
	private int reciept_no;
	private String checked_by;
	private int item_id;
	public Inwards(int inwards_Id, int godown_id, String item_name, String supplier_name, Date date_of_supply,
			int invoice_no, int quantity, String recieved_by, int reciept_no, String checked_by, int item_id) {
		super();
		this.inwards_Id = inwards_Id;
		this.godown_id = godown_id;
		this.item_name = item_name;
		this.supplier_name = supplier_name;
		this.date_of_supply = date_of_supply;
		this.invoice_no = invoice_no;
		this.quantity = quantity;
		this.recieved_by = recieved_by;
		this.reciept_no = reciept_no;
		this.checked_by = checked_by;
		this.item_id = item_id;
	}
	public Inwards() {
		super();
	}
	public int getInwards_Id() {
		return inwards_Id;
	}
	public void setInwards_Id(int inwards_Id) {
		this.inwards_Id = inwards_Id;
	}
	public int getGodown_id() {
		return godown_id;
	}
	public void setGodown_id(int godown_id) {
		this.godown_id = godown_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public Date getDate_of_supply() {
		return date_of_supply;
	}
	public void setDate_of_supply(Date date_of_supply) {
		this.date_of_supply = date_of_supply;
	}
	public int getInvoice_no() {
		return invoice_no;
	}
	public void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getRecieved_by() {
		return recieved_by;
	}
	public void setRecieved_by(String recieved_by) {
		this.recieved_by = recieved_by;
	}
	public int getReciept_no() {
		return reciept_no;
	}
	public void setReciept_no(int reciept_no) {
		this.reciept_no = reciept_no;
	}
	public String getChecked_by() {
		return checked_by;
	}
	public void setChecked_by(String checked_by) {
		this.checked_by = checked_by;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	@Override
	public String toString() {
		return "Inwards [inwards_Id=" + inwards_Id + ", godown_id=" + godown_id + ", item_name=" + item_name
				+ ", supplier_name=" + supplier_name + ", date_of_supply=" + date_of_supply + ", invoice_no="
				+ invoice_no + ", quantity=" + quantity + ", recieved_by=" + recieved_by + ", reciept_no=" + reciept_no
				+ ", checked_by=" + checked_by + ", item_id=" + item_id + "]";
	}
	
	
	
	
}
