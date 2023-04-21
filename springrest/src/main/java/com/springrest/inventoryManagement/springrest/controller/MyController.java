package com.springrest.inventoryManagement.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.repository.EmployeeRepository;


@RestController

public class MyController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	List<Employee> employees = new ArrayList<>();

	
	@GetMapping(path="/employees")
	public List<Employee> getEmployees() {
		//return employees;
		return employeeRepository.findAll();
	}
	@PostMapping(path="/employees")
	public void addEmployee(@RequestBody Employee e) {
		//employees.add(e);
		employeeRepository.save(e);
	}
	@DeleteMapping(path="/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		System.out.println("Id:"+id);
		employeeRepository.deleteById(id);

	}
	@PatchMapping(path="/employees")
	public void updateEmployeeSalary(@RequestBody Employee employee) {
		Optional<Employee> employeeFound=employeeRepository.findById(employee.getEmployeeId());
		if(employeeFound.isPresent()) {
			Employee e = employeeFound.get();
			e.setEmployeeEmail(employee.getEmployeeEmail());
			e.setEmployeeGoDownId(employee.getEmployeeGoDownId());
			
			e.setEmployeePassword(employee.getEmployeePassword());
			e.setEmployeePhoneNo(employee.getEmployeePhoneNo());
			e.setEmployeeUserName(employee.getEmployeeUserName());
			
			employeeRepository.save(e);
		}
	
	}	
}