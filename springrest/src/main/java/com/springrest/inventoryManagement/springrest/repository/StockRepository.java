package com.springrest.inventoryManagement.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.inventoryManagement.springrest.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer > {

	Stock findByItemName(String itemName);
}
