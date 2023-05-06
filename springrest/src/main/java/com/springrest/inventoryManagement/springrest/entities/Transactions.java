package com.springrest.inventoryManagement.springrest.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private String itemName;
	private String supplierName;
	private Date dateOfSupply;
	private int invoiceNo;
	private int quantity;
	private int recievedBy;
	private String checkedBy;
	private int itemType;
	private Date dateOfReturn;
	private Date dateOfDel;
	private String returnBy;
	private int billValue;
	private String deliveredTo;
	private String purpose;
	
	public Transactions(int transactionId, String itemName, String supplierName, Date dateOfSupply, int invoiceNo,
			int quantity, int recievedBy, String checkedBy, int itemType, Date dateOfReturn, Date dateOfDel,
			String returnBy, int billValue, String deliveredTo, String purpose) {
		super();
		this.transactionId = transactionId;
		this.itemName = itemName;
		this.supplierName = supplierName;
		this.dateOfSupply = dateOfSupply;
		this.invoiceNo = invoiceNo;
		this.quantity = quantity;
		this.recievedBy = recievedBy;
		this.checkedBy = checkedBy;
		this.itemType = itemType;
		this.dateOfReturn = dateOfReturn;
		this.dateOfDel = dateOfDel;
		this.returnBy = returnBy;
		this.billValue = billValue;
		this.deliveredTo = deliveredTo;
		this.purpose = purpose;
	}
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public Date getDateOfSupply() {
		return dateOfSupply;
	}
	public void setDateOfSupply(Date dateOfSupply) {
		this.dateOfSupply = dateOfSupply;
	}
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getRecievedBy() {
		return recievedBy;
	}
	public void setRecievedBy(int recievedBy) {
		this.recievedBy = recievedBy;
	}
	public String getCheckedBy() {
		return checkedBy;
	}
	public void setCheckedBy(String checkedBy) {
		this.checkedBy = checkedBy;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}
	public Date getDateOfReturn() {
		return dateOfReturn;
	}
	public void setDateOfReturn(Date dateOfReturn) {
		this.dateOfReturn = dateOfReturn;
	}
	public Date getDateOfDel() {
		return dateOfDel;
	}
	public void setDateOfDel(Date dateOfDel) {
		this.dateOfDel = dateOfDel;
	}
	public String getReturnBy() {
		return returnBy;
	}
	public void setReturnBy(String returnBy) {
		this.returnBy = returnBy;
	}
	public int getBillValue() {
		return billValue;
	}
	public void setBillValue(int billValue) {
		this.billValue = billValue;
	}
	public String getDeliveredTo() {
		return deliveredTo;
	}
	public void setDeliveredTo(String deliveredTo) {
		this.deliveredTo = deliveredTo;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", itemName=" + itemName + ", supplierName="
				+ supplierName + ", dateOfSupply=" + dateOfSupply + ", invoiceNo=" + invoiceNo + ", quantity="
				+ quantity + ", recievedBy=" + recievedBy + ", checkedBy=" + checkedBy + ", itemType=" + itemType
				+ ", dateOfReturn=" + dateOfReturn + ", dateOfDel=" + dateOfDel + ", returnBy=" + returnBy
				+ ", billValue=" + billValue + ", deliveredTo=" + deliveredTo + ", purpose=" + purpose + "]";
	}
	
	
}
