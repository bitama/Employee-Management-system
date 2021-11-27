package com.employee.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.demo.models.Employee;
import com.employee.demo.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	
	private EmployeeRepository employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}


	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
    @Override
	public Employee createEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}


	@Override
	public Employee getEmployeeId(Long id) {
		return employeeRepo.findById(id).get();
	
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

    @Override 
    public void deleteEmployeeById(Long id) {
    	employeeRepo.deleteById(id);
    }
		



	
	


	

}
