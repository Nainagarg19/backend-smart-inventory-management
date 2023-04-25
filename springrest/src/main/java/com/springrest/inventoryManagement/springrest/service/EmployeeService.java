package com.springrest.inventoryManagement.springrest.service;

import java.util.List;

import com.springrest.inventoryManagement.springrest.entities.Employee;




public interface EmployeeService {
    public Employee getEmployeeById(int employeeId);


    public void addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int employeeId);

	public List<Employee> findAll();
}