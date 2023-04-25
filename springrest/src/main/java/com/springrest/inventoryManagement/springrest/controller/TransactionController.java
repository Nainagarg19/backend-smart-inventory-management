package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.service.TransactionService;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/{transaction_Id}")
    public ResponseEntity<Transactions> getTransactionsById(@PathVariable int transaction_Id) {
    	Transactions transactions = transactionService.getTransactionsById(transaction_Id);
        if (transactions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
    }
    
    @GetMapping(path="")
	public List<Transactions> getAllTransactions() {
		//return employees;
		
		return transactionService.findAll();
	}

    @PostMapping("")
    public ResponseEntity<Transactions> addTransactions(@RequestBody Transactions transactions) {
    	transactionService.addTransactions(transactions);
        return new ResponseEntity<>(transactions, HttpStatus.CREATED);
    }

    @PutMapping("/{transaction_Id}")
    public ResponseEntity<Transactions> updateTransactions(@PathVariable int transaction_Id, @RequestBody Transactions transactions) {
        if (transactionService.getTransactionsById(transaction_Id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	transactions.setTransaction_Id(transaction_Id);
        	transactionService.updateTransactions(transactions);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{transaction_Id}")
    public ResponseEntity<Transactions> deleteTransactions(@PathVariable int transaction_Id) {
    	Transactions transactions = transactionService.getTransactionsById(transaction_Id);
        if (transactions == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	transactionService.deleteTransactions(transaction_Id);
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
    }
}