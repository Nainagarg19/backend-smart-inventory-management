package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.entities.Stock;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.repository.TransactionRepository;


@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private StockService stockService;
	@Autowired
	private GodownService godownService;
	
	
	public List<Transactions> getAllTransactions() {
		return transactionRepository.findAll();
	}
	
	public Optional<Transactions> getTransactionById(int transactionId) {
		return transactionRepository.findById(transactionId);
	}
	
	/*
	 * public void addTransactions(Transactions transactions) {
	 * transactionRepository.save(transactions); }
	 */

	public Transactions saveTransaction(Transactions transaction) {
		int itemType = transaction.getItemType();
		String itemName = transaction.getItemName();
		String godownName = transaction.getGodownName();
		int quantity = transaction.getQuantity();
		
		// Use the StockService to find the Stock object for the itemName
		Stock stock = stockService.findByItemName(itemName);
		Godowns godowns = godownService.findByGodownName(godownName);
		
		if (stock == null || godowns==null) {
			// If there is no existing stock for the item, create a new stock record
			stock = new Stock();
			stock.setItemName(itemName);
			stock.setQuantity(quantity);
			
			godowns = new Godowns();
			godowns.setGodownName(godownName);
			godowns.setQuantity(quantity);
			godowns.setCapacity(100);
		} else {
			// If there is an existing stock record for the item, update the quantity based on the transaction type
			if (itemType == 1) {
					stock.setQuantity(stock.getQuantity() + quantity);
					godowns.setQuantity(godowns.getQuantity() + quantity);
					godowns.setCapacity(godowns.getCapacity() - quantity);
			} else if (itemType == 2) {
				stock.setQuantity(stock.getQuantity() - quantity);
				godowns.setQuantity(godowns.getQuantity() - quantity);
				godowns.setCapacity(godowns.getCapacity() + quantity);
			} else if (itemType == 3) {
				stock.setQuantity(stock.getQuantity() + quantity);
				godowns.setQuantity(godowns.getQuantity() + quantity);
				godowns.setCapacity(godowns.getCapacity() - quantity);
				}
			}
		// Save the updated or new Stock object using the StockService
		stockService.saveStock(stock);
		godownService.saveGodown(godowns);
		
		// Save the Transaction object using the TransactionRepository
		return transactionRepository.save(transaction);
		
	}
	
	public void updateTransactions(int transactionId, Transactions transactions) {
		Optional<Transactions> optionalTransaction = transactionRepository.findById(transactionId);
		if (optionalTransaction.isPresent()) {
			transactions.setTransactionId(transactionId);
			transactionRepository.save(transactions);
		}
	}
	
	public void deleteTransactions(int transactionId) {
		transactionRepository.deleteById(transactionId);
	}
	
	public List<Transactions> getTransactionsByItemType(int itemType) {
        return transactionRepository.findByItemType(itemType);
    }
	
	public List<Transactions> searchTransactions(int key,String keyword){
		return transactionRepository.findByItemTypeAndItemNameContainingIgnoreCase(key,keyword);
		
	}
	
}
