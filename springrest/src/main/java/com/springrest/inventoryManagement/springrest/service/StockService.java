package com.springrest.inventoryManagement.springrest.service;

import java.util.List;

import com.springrest.inventoryManagement.springrest.entities.Godowns;
import com.springrest.inventoryManagement.springrest.entities.Stock;




public interface StockService {
    public Stock getStockById(int item_id);

	public List<Stock> findAll();

    public void addStock(Stock stock);

    public void updateStock(Stock stock);

    public void deleteStock(int item_id);
}