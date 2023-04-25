package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import com.springrest.inventoryManagement.springrest.entities.Transactions;

public interface TransactionService {
    public Transactions getTransactionsById(int transaction_Id);


    public void addTransactions(Transactions transactions);

    public void updateTransactions(Transactions transactions);

    public void deleteTransactions(int transaction_Id);

	public List<Transactions> findAll();
}