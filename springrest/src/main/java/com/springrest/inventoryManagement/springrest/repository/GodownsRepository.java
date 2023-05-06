package com.springrest.inventoryManagement.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.inventoryManagement.springrest.entities.Godowns;

public interface GodownsRepository extends JpaRepository<Godowns, Integer > {

	List<Godowns> findByGodownNameContainingIgnoreCase(String godownName);
}
