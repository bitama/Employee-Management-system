package com.employee.demo.services;

import java.util.List;

import com.employee.demo.models.Employee;

public interface EmployeeService {
	
	List<Employee>getAllEmployees();
	
	
	Employee createEmployee(Employee employee);
	
	
	Employee getEmployeeId(Long id);
	
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeeById(Long id);
	
	


	

}
