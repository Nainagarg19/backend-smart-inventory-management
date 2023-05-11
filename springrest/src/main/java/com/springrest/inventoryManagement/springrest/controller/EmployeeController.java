package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.service.EmployeeService;



@RestController
@RequestMapping(value="/api/employees")
@CrossOrigin
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

	
	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		Optional<Employee> optionalEmployee = employeeService.getEmployeeById(id);
		if (optionalEmployee.isPresent()) {
			return new ResponseEntity<>(optionalEmployee.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/login")
	public Employee login(@RequestParam String userName, @RequestParam String password) {
		return employeeService.login(userName, password);
//		if (employee != null) {
//			return ResponseEntity.ok(employee.getType());
//		} else {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(3);
//		}
	}
	
	@PostMapping
	public String addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PatchMapping("/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "Successfull";
	}
	
	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
		return "Successfull";
	}
	
	//search
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployeeByName(@RequestParam String name){
		List<Employee> result= employeeService.searchEmployees(name);
		
		return new ResponseEntity<List<Employee>>(result, HttpStatus.OK);
	}
	
	
	
}

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springrest.inventoryManagement.springrest.entities.Employee;
//import com.springrest.inventoryManagement.springrest.repository.EmployeeRepository;
//
//
//@RestController
//
//public class MyController {
//	@Autowired
//	EmployeeRepository employeeRepository;
//	
//	List<Employee> employees = new ArrayList<>();
//
//	
//	
//	@GetMapping(path="/employees")
//	public List<Employee> getEmployees() {
//		//return employees;
//		
//		return employeeRepository.findAll();
//	}
//	
//	@GetMapping(path="/employees/{id}/login")
//	public ResponseEntity<String> employeeLogin(@PathVariable int id, @RequestParam String password) {
//	    Optional<Employee> employeeFound = employeeRepository.findById(id);
//	    if (employeeFound.isPresent()) {
//	        Employee employee = employeeFound.get();
//	        if (employee.getEmployeePassword().equals(password)) {
//	            return new ResponseEntity<String>("1", HttpStatus.OK);
//	        }
//	    }
//	    return new ResponseEntity<String>("0", HttpStatus.UNAUTHORIZED);
//	}
//	
//	
//	@PostMapping(path="/employees")
//	public void addEmployee(@RequestBody Employee e) {
//		//employees.add(e);
//		employeeRepository.save(e);
//	}
//	@DeleteMapping(path="/employees/{id}")
//	public void deleteEmployee(@PathVariable int id) {
//		System.out.println("Id:"+id);
//		employeeRepository.deleteById(id);
//
//	}
//	@PatchMapping(path="/employees")
//	public void updateEmployee(@RequestBody Employee employee) {
//		Optional<Employee> employeeFound=employeeRepository.findById(employee.getEmployeeId());
//		if(employeeFound.isPresent()) {
//			Employee e = employeeFound.get();
//			e.setEmployeeEmail(employee.getEmployeeEmail());
//			e.setEmployeeGoDownId(employee.getEmployeeGoDownId());
//			
//			e.setEmployeePassword(employee.getEmployeePassword());
//			e.setEmployeePhoneNo(employee.getEmployeePhoneNo());
//			e.setEmployeeUserName(employee.getEmployeeUserName());
//			
//			employeeRepository.save(e);
//		}
//	
//	}	
//}