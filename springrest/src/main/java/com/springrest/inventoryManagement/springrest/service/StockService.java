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
	
	public Optional<Stock> getStockById(int item_id) {
		return stockRepository.findById(item_id);
	}
	
	public void addStock(Stock stock) {
		stockRepository.save(stock);
	}
	
	public void updateStock(int item_id, Stock stock) {
		Optional<Stock> optionalStock = stockRepository.findById(item_id);
		if (optionalStock.isPresent()) {
			stock.setItem_id(item_id);
			stockRepository.save(stock);
		}
	}
	
	public void deleteStock(int item_id) {
		stockRepository.deleteById(item_id);
	}
}
