package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.services.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return this.employeeService.getEmployees();
	}
}
