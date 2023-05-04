package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;
import java.util.Optional;

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
import com.springrest.inventoryManagement.springrest.repository.TransactionRepository;
import com.springrest.inventoryManagement.springrest.service.TransactionService;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
	private TransactionRepository transactionRepository;
    @GetMapping
	public List<Transactions> getAllTransactions() {
		return transactionService.getAllTransactions();
	}
	
	@GetMapping("/{transaction_Id}")
	public ResponseEntity<Transactions> getTransactionsById(@PathVariable int transaction_Id) {
		Optional<Transactions> optionalTransactions = transactionService.getTransactionById(transaction_Id);
		if (optionalTransactions.isPresent()) {
			return new ResponseEntity<>(optionalTransactions.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public String addTransactions(@RequestBody Transactions transactions) {
		transactionService.addTransactions(transactions);
		return "Successfull";
	}
	
	@PutMapping("/{transaction_Id}")
	public String updateTransactions(@PathVariable int transaction_Id, @RequestBody Transactions transactions) {
		transactionService.updateTransactions(transaction_Id, transactions);
		return "Successfull";
	}
	
	@DeleteMapping("/{transaction_Id}")
	public String deleteTransactions(@PathVariable int transaction_Id) {
		transactionService.deleteTransactions(transaction_Id);
		return "Successfull";
	}
	@GetMapping("/item-type/{itemType}")
	public ResponseEntity<List<Transactions>> getTransactionsByItemType(@PathVariable int itemType) {
	    List<Transactions> transactions = transactionRepository.findByItemType(itemType);
	    return ResponseEntity.ok().body(transactions);
	}

}