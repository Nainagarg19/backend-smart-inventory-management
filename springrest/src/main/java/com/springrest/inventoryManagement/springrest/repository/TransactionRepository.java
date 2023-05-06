package com.springrest.inventoryManagement.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springrest.inventoryManagement.springrest.entities.Transactions;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer > {

	@Query("SELECT t FROM Transactions t WHERE t.itemType = :itemType")
    List<Transactions> findByItemType(@Param("itemType") int itemType);

	List<Transactions> findByItemTypeAndItemNameContainingIgnoreCase(int itemType,String Name);
}
