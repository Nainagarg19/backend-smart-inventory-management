package com.springrest.inventoryManagement.springrest.entities;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Return {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int returnId;
	private String item_name;
	private String capacity;
	private String manager;
	private Date date_of_del;
	private boolean date_of_return;
	private int quantity;
	private int invoice_no;
	private String return_by;
	private int reciept_no;
	private int bill_value;
	private Date return_date;
	private String checked_by;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Godowns godowns;

	public Return(int returnId, String item_name, String capacity, String manager, Date date_of_del,
			boolean date_of_return, int quantity, int invoice_no, String return_by, int reciept_no, int bill_value,
			Date return_date, String checked_by, Godowns godowns) {
		super();
		this.returnId = returnId;
		this.item_name = item_name;
		this.capacity = capacity;
		this.manager = manager;
		this.date_of_del = date_of_del;
		this.date_of_return = date_of_return;
		this.quantity = quantity;
		this.invoice_no = invoice_no;
		this.return_by = return_by;
		this.reciept_no = reciept_no;
		this.bill_value = bill_value;
		this.return_date = return_date;
		this.checked_by = checked_by;
		this.godowns = godowns;
	}

	public Return() {
		super();
	}

	public int getReturnId() {
		return returnId;
	}

	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getDate_of_del() {
		return date_of_del;
	}

	public void setDate_of_del(Date date_of_del) {
		this.date_of_del = date_of_del;
	}

	public boolean isDate_of_return() {
		return date_of_return;
	}

	public void setDate_of_return(boolean date_of_return) {
		this.date_of_return = date_of_return;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getReturn_by() {
		return return_by;
	}

	public void setReturn_by(String return_by) {
		this.return_by = return_by;
	}

	public int getReciept_no() {
		return reciept_no;
	}

	public void setReciept_no(int reciept_no) {
		this.reciept_no = reciept_no;
	}

	public int getBill_value() {
		return bill_value;
	}

	public void setBill_value(int bill_value) {
		this.bill_value = bill_value;
	}

	public Date getReturn_date() {
		return return_date;
	}

	public void setReturn_date(Date return_date) {
		this.return_date = return_date;
	}

	public String getChecked_by() {
		return checked_by;
	}

	public void setChecked_by(String checked_by) {
		this.checked_by = checked_by;
	}

	public Godowns getGodowns() {
		return godowns;
	}

	public void setGodowns(Godowns godowns) {
		this.godowns = godowns;
	}

	@Override
	public String toString() {
		return "Return [returnId=" + returnId + ", item_name=" + item_name + ", capacity=" + capacity + ", manager="
				+ manager + ", date_of_del=" + date_of_del + ", date_of_return=" + date_of_return + ", quantity="
				+ quantity + ", invoice_no=" + invoice_no + ", return_by=" + return_by + ", reciept_no=" + reciept_no
				+ ", bill_value=" + bill_value + ", return_date=" + return_date + ", checked_by=" + checked_by
				+ ", godowns=" + godowns + "]";
	}
	
	
	
}
