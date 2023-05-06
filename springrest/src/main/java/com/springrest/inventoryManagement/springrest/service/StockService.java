package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Stock;
import com.springrest.inventoryManagement.springrest.repository.StockRepository;


@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> getAllStocks() {
		return stockRepository.findAll();
	}
	
	public Optional<Stock> getStockById(int itemId) {
		return stockRepository.findById(itemId);
	}
	
	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}
	
	public void updateStock(int itemId, Stock stock) {
		Optional<Stock> optionalStock = stockRepository.findById(itemId);
		if (optionalStock.isPresent()) {
			stock.setItemId(itemId);
			stockRepository.save(stock);
		}
	}
	
	public void deleteStock(int item_id) {
		stockRepository.deleteById(item_id);
	}
	
	public Stock findByItemName(String itemName) {
		return stockRepository.findByItemName(itemName);
	}

	public Stock saveStock(Stock stock) {
		return stockRepository.save(stock);
	}
}
