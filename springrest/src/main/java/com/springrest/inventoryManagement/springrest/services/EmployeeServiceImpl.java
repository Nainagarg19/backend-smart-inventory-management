package com.springrest.inventoryManagement.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.inventoryManagement.springrest.entities.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> list;

	public EmployeeServiceImpl() {
		list= new ArrayList<>();
		list.add(new Employee(1234, "Akash", "akash123", "akash123@gmail.com", "Akash123", "9883838339", 8333));
		list.add(new Employee(1222, "Ankit", "ankit123", "ankit123@gmail.com", "Ankit123", "9434334333", 8334));
	}

	@Override
	public List<Employee> getEmployees() {
		return list;
	}

}
