package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transactions> getAllTransactions() {
		return transactionRepository.findAll();
	}
	
	public Optional<Transactions> getTransactionById(int transaction_Id) {
		return transactionRepository.findById(transaction_Id);
	}
	
	public void addTransactions(Transactions transactions) {
		transactionRepository.save(transactions);
	}
	
	public void updateTransactions(int transaction_Id, Transactions transactions) {
		Optional<Transactions> optionalTransaction = transactionRepository.findById(transaction_Id);
		if (optionalTransaction.isPresent()) {
			transactions.setTransaction_Id(transaction_Id);
			transactionRepository.save(transactions);
		}
	}
	
	public void deleteTransactions(int transaction_Id) {
		transactionRepository.deleteById(transaction_Id);
	}
}
