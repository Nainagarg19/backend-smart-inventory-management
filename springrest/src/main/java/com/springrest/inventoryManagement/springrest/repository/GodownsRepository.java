package com.springrest.inventoryManagement.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.springrest.inventoryManagement.springrest.entities.Godowns;

public interface GodownsRepository extends JpaRepository<Godowns, Integer > {


}
