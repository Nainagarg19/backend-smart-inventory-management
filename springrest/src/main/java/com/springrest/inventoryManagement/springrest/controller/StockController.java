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
import com.springrest.inventoryManagement.springrest.entities.Stock;
import com.springrest.inventoryManagement.springrest.service.StockService;

@RestController
@RequestMapping("/api/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
	public List<Stock> getAllStock() {
		return stockService.getAllStocks();
	}
	
	@GetMapping("/{item_id}")
	public ResponseEntity<Stock> getStockById(@PathVariable int item_id) {
		Optional<Stock> optionalStock = stockService.getStockById(item_id);
		if (optionalStock.isPresent()) {
			return new ResponseEntity<>(optionalStock.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public void addStock(@RequestBody Stock stock) {
		stockService.addStock(stock);
	}
	
	@PutMapping("/{item_id}")
	public void updateStock(@PathVariable int item_id, @RequestBody Stock stock) {
		stockService.updateStock(item_id, stock);
	}
	
	@DeleteMapping("/{item_id}")
	public void deleteStock(@PathVariable int item_id) {
		stockService.deleteStock(item_id);
	}
}
