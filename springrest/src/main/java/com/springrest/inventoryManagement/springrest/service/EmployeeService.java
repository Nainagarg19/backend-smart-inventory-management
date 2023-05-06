package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.entities.Transactions;
import com.springrest.inventoryManagement.springrest.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	public Employee login(String userName, String password) {
		return employeeRepository.findByUserNameAndPassword(userName, password);
		}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(int id, Employee employee) {
		Optional<Employee> optionalEmployee = employeeRepository.findById(id);
		if (optionalEmployee.isPresent()) {
			employee.setId(id);
			employeeRepository.save(employee);
		}
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
	
	public List<Employee> searchEmployees(String keyword){
		return employeeRepository.findByNameContainingIgnoreCase(keyword);
		
	}
}
