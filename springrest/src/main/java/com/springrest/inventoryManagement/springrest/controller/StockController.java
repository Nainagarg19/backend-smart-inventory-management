package com.springrest.inventoryManagement.springrest.controller;


import java.util.List;
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

    @GetMapping("/{item_id}")
    public ResponseEntity<Stock> getGodownsById(@PathVariable int item_id) {
    	Stock stock = stockService.getStockById(item_id);
        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
    }
    
    @GetMapping(path="")
	public List<Stock> getAllGodowns() {
		//return employees;
		
		return stockService.findAll();
	}

    @PostMapping("")
    public ResponseEntity<Stock> addGodowns(@RequestBody Stock stock) {
    	stockService.addStock(stock);
        return new ResponseEntity<>(stock, HttpStatus.CREATED);
    }

    @PutMapping("/{item_id}")
    public ResponseEntity<Stock> updateGodowns(@PathVariable int item_id, @RequestBody Stock stock) {
        if (stockService.getStockById(item_id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	stock.setItem_id(item_id);
        	stockService.updateStock(stock);
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{item_id}")
    public ResponseEntity<Stock> deleteStock(@PathVariable int item_id) {
    	Stock stock = stockService.getStockById(item_id);
        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
        	stockService.deleteStock(item_id);
            return new ResponseEntity<>(stock, HttpStatus.OK);
        }
    }
}
