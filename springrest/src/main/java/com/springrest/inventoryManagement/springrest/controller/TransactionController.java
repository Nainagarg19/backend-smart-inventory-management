package com.springrest.inventoryManagement.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.repository.EmployeeRepository;
import com.springrest.inventoryManagement.springrest.repository.TransactionRepository;


@RestController

public class TransactionController {
	@Autowired
	TransactionRepository transactionRepository;
	
	List<Transactions> transactions = new ArrayList<>();

	
	
	@GetMapping(path="/transactions")
	public List<Transactions> getTransactions() {
		//return employees;
		
		return transactionRepository.findAll();
	}
	
	
	
	@PostMapping(path="/transactions")
	public void Transaction(@RequestBody Transactions t) {
		//employees.add(e);
		transactionRepository.save(t);
	}
	@DeleteMapping(path="/transactions/{id}")
	public void deleteTransaction(@PathVariable int id) {
		System.out.println("Id:"+id);
		transactionRepository.deleteById(id);

	}
	@PatchMapping(path="/transactions")
	public void updateTransaction(@RequestBody Transactions transactions) {
		Optional<Transactions> transactionFound=transactionRepository.findById(transactions.getTransaction_Id());
		if(transactionFound.isPresent()) {
			Transactions t = transactionFound.get();
			t.setBill_value(transactions.getBill_value());
			t.setChecked_by(transactions.getChecked_by());
			t.setDate_of_del(transactions.getDate_of_del());
			t.setDate_of_return(transactions.getDate_of_return());
			t.setDate_of_supply(transactions.getDate_of_supply());
			t.setDelivered_to(transactions.getDelivered_to());
			t.setGodown_id(transactions.getGodown_id());
			t.setInvoice_no(transactions.getInvoice_no());
			t.setItem_id(transactions.getItem_id());
			t.setItem_name(transactions.getItem_name());
			t.setItem_type(transactions.getItem_type());
			t.setPurpose(transactions.getPurpose());
			t.setQuantity(transactions.getQuantity());
			t.setRecieved_by(transactions.getRecieved_by());
			t.setReturn_by(transactions.getReturn_by());
			t.setSupplier_name(transactions.getSupplier_name());
			transactionRepository.save(t);
		}
	
	}	
}