package com.springrest.inventoryManagement.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.springrest.inventoryManagement.springrest.entities.Employee;
import com.springrest.inventoryManagement.springrest.service.EmployeeService;


@RestController
@RequestMapping(value="/api/employees")
@CrossOrigin
public class MyController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }
    
    @GetMapping(path="")
	public List<Employee> getAllEmployees() {
		//return employees;
		
		return employeeService.findAll();
	}

    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
        if (employeeService.getEmployeeById(employeeId) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            employee.setEmployeeId(employeeId);
            employeeService.updateEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            employeeService.deleteEmployee(employeeId);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
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