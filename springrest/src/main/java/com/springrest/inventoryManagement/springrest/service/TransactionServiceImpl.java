package com.springrest.inventoryManagement.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transactions getTransactionsById(int transaction_Id) {
        return transactionRepository.findById(transaction_Id).orElse(null);
    }

    

    @Override
    public void addTransactions(Transactions transactions) {
    	transactionRepository.save(transactions);
    }

    @Override
    public void updateTransactions(Transactions transactions) {
    	transactionRepository.save(transactions);
    }

    @Override
    public void deleteTransactions(int transaction_Id) {
    	transactionRepository.deleteById(transaction_Id);
    }

	@Override
	public List<Transactions> findAll() {
		// TODO Auto-generated method stub
		return transactionRepository.findAll();
	}
}