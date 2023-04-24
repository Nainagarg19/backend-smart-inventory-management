package com.springrest.inventoryManagement.springrest.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transactions {
	@Id
	private int transaction_Id;
	private int godown_id;
	private String item_name;
	private String supplier_name;
	private Date date_of_supply;
	private int invoice_no;
	private int quantity;
	private int recieved_by;
	private String checked_by;
	private int item_type;
	private Date date_of_return;
	private Date date_of_del;
	private String return_by;
	private int bill_value;
	private String delivered_to;
	private String purpose;
	private int item_id;
	public Transactions(int transaction_Id, int godown_id, String item_name, String supplier_name, Date date_of_supply,
			int invoice_no, int quantity, int recieved_by, String checked_by, int item_type, Date date_of_return,
			Date date_of_del, String return_by, int bill_value, String delivered_to, String purpose, int item_id) {
		super();
		this.transaction_Id = transaction_Id;
		this.godown_id = godown_id;
		this.item_name = item_name;
		this.supplier_name = supplier_name;
		this.date_of_supply = date_of_supply;
		this.invoice_no = invoice_no;
		this.quantity = quantity;
		this.recieved_by = recieved_by;
		this.checked_by = checked_by;
		this.item_type = item_type;
		this.date_of_return = date_of_return;
		this.date_of_del = date_of_del;
		this.return_by = return_by;
		this.bill_value = bill_value;
		this.delivered_to = delivered_to;
		this.purpose = purpose;
		this.item_id = item_id;
	}
	public Transactions() {
		super();
	}
	public int getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
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
	public int getRecieved_by() {
		return recieved_by;
	}
	public void setRecieved_by(int recieved_by) {
		this.recieved_by = recieved_by;
	}
	public String getChecked_by() {
		return checked_by;
	}
	public void setChecked_by(String checked_by) {
		this.checked_by = checked_by;
	}
	public int getItem_type() {
		return item_type;
	}
	public void setItem_type(int item_type) {
		this.item_type = item_type;
	}
	public Date getDate_of_return() {
		return date_of_return;
	}
	public void setDate_of_return(Date date_of_return) {
		this.date_of_return = date_of_return;
	}
	public Date getDate_of_del() {
		return date_of_del;
	}
	public void setDate_of_del(Date date_of_del) {
		this.date_of_del = date_of_del;
	}
	public String getReturn_by() {
		return return_by;
	}
	public void setReturn_by(String return_by) {
		this.return_by = return_by;
	}
	public int getBill_value() {
		return bill_value;
	}
	public void setBill_value(int bill_value) {
		this.bill_value = bill_value;
	}
	public String getDelivered_to() {
		return delivered_to;
	}
	public void setDelivered_to(String delivered_to) {
		this.delivered_to = delivered_to;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	@Override
	public String toString() {
		return "Transactions [transaction_Id=" + transaction_Id + ", godown_id=" + godown_id + ", item_name="
				+ item_name + ", supplier_name=" + supplier_name + ", date_of_supply=" + date_of_supply
				+ ", invoice_no=" + invoice_no + ", quantity=" + quantity + ", recieved_by=" + recieved_by
				+ ", checked_by=" + checked_by + ", item_type=" + item_type + ", date_of_return=" + date_of_return
				+ ", date_of_del=" + date_of_del + ", return_by=" + return_by + ", bill_value=" + bill_value
				+ ", delivered_to=" + delivered_to + ", purpose=" + purpose + ", item_id=" + item_id + "]";
	}
	
	
	
}
