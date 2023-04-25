package com.springrest.inventoryManagement.springrest.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.entities.Stock;
import com.springrest.inventoryManagement.springrest.repository.GodownsRepository;
import com.springrest.inventoryManagement.springrest.repository.StockRepository;




@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock getStockById(int item_id) {
        return stockRepository.findById(item_id).orElse(null);
    }

    @Override
	public List<Stock> findAll() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

    @Override
    public void addStock(Stock stock) {
    	stockRepository.save(stock);
    }

    @Override
    public void updateStock(Stock stock) {
    	stockRepository.save(stock);
    }

    @Override
    public void deleteStock(int item_id) {
    	stockRepository.deleteById(item_id);
    }
}