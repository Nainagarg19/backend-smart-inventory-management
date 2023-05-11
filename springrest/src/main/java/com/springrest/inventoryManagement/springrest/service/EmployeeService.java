package com.springrest.inventoryManagement.springrest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	public Employee login(String userName, String password) throws UsernameNotFoundException {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

		Employee optionalEmployee = employeeRepository.findByUserName(userName);
		//return employeeRepository.findByUserNameAndPassword(userName, password);

		if(optionalEmployee != null) {
			if(bcrypt.matches(password, optionalEmployee.getPassword())) {
				return optionalEmployee;
			}
			
		}
		throw new UsernameNotFoundException("User not found");
		//return optionalEmployee;
		
	}
	
	
	public String addEmployee(Employee employee) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPwd = bcrypt.encode(employee.getPassword());
		employee.setPassword(encryptedPwd);

		Employee optionalEmployee = employeeRepository.findByUserName(employee.getUserName());

		if(optionalEmployee == null) {
			Employee empObj = employeeRepository.save(employee);
			return "\""+empObj.getUserName()+"\" added to the DB";
		}
		else {
			return "username \""+employee.getUserName()+"\" already exists in the DB..\nPick a different one.";
		}
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
