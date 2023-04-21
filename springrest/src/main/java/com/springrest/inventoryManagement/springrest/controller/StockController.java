package com.springrest.inventoryManagement.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.inventoryManagement.springrest.entities.Stock;
import com.springrest.inventoryManagement.springrest.repository.StockRepository;

@RestController

public class StockController {
	@Autowired
	StockRepository stockRepository;
	
	List<Stock> stocks = new ArrayList<>();

	
	
	@GetMapping(path="/stocks")
	public List<Stock> getStocks() {
		//return stocks;
		
		return stockRepository.findAll();
	}
	
	@PostMapping(path="/stocks")
	public void addStock(@RequestBody Stock s) {
		//stocks.add(e);
		stockRepository.save(s);
	}
	@DeleteMapping(path="/stocks/{id}")
	public void deleteStock(@PathVariable int id) {
		System.out.println("Id:"+id);
		stockRepository.deleteById(id);

	}
	@PatchMapping(path="/stocks")
	public void updateStock(@RequestBody Stock stock) {
		Optional<Stock> stockFound=stockRepository.findById(stock.getItem_id());
		if(stockFound.isPresent()) {
			Stock s = stockFound.get();
			s.setQuantity(stock.getQuantity());
			stockRepository.save(s);
		}
	
	}	
}