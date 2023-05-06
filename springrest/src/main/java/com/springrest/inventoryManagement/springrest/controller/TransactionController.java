package com.springrest.inventoryManagement.springrest.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{transactionId}")
	public ResponseEntity<Transactions> getTransactionsById(@PathVariable int transactionId) {
		Optional<Transactions> optionalTransactions = transactionService.getTransactionById(transactionId);
		if (optionalTransactions.isPresent()) {
			return new ResponseEntity<>(optionalTransactions.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Transactions> createTransaction(@RequestBody Transactions transaction) {
		Transactions savedTransaction = transactionService.saveTransaction(transaction);
		return ResponseEntity.ok(savedTransaction);
	}
	
	@PatchMapping("/{transactionId}")
	public String updateTransactions(@PathVariable int transactionId, @RequestBody Transactions transactions) {
		transactionService.updateTransactions(transactionId, transactions);
		return "Successfull";
	}
	
	@DeleteMapping("/{transactionId}")
	public String deleteTransactions(@PathVariable int transactionId) {
		transactionService.deleteTransactions(transactionId);
		return "Successfull";
	}
	@GetMapping("/item-type/{itemType}")
	public ResponseEntity<List<Transactions>> getTransactionsByItemType(@PathVariable int itemType) {
	    List<Transactions> transactions = transactionRepository.findByItemType(itemType);
	    return ResponseEntity.ok().body(transactions);
	}
	
	//search
	@GetMapping("/search")
	public ResponseEntity<List<Transactions>> searchEmployeeByName(@RequestParam int itemType, @RequestParam String itemName){
		List<Transactions> result= transactionService.searchTransactions(itemType,itemName);
		return new ResponseEntity<List<Transactions>>(result, HttpStatus.OK);
	}

}