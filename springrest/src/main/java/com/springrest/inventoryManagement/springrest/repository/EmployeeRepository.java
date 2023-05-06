package com.springrest.inventoryManagement.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.inventoryManagement.springrest.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer > {

	Employee findByUserNameAndPassword(String userName, String password);
	
	List<Employee> findByNameContainingIgnoreCase(String Name);
	
}
