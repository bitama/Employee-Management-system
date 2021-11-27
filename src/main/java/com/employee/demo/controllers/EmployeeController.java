package com.employee.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.demo.models.Employee;
import com.employee.demo.services.EmployeeService;

@Controller
public class EmployeeController {
@Autowired 
private EmployeeService employeeServ;


public EmployeeController(EmployeeService employeeServ) {
	super();
	this.employeeServ = employeeServ;
}

@GetMapping("/employee")	
public String getAllEmployee(Model model) {
 model.addAttribute("listEmployees",employeeServ.getAllEmployees());
 return "employee";
}

@GetMapping("/employee/create")
public String makeEmployeeForm(Model model) {
	Employee employee = new Employee();
	model.addAttribute("employee",employee);
	return "createEmployee";
	
}
@PostMapping("/employee/new")
public String makeEmployee(@ModelAttribute("empolyee") Employee employee) {
	employeeServ.createEmployee(employee);
	return "redirect:/employee";
}

@GetMapping("/employee/update/{id}")
public String getEmployee(@PathVariable Long id,Model model) {
	model.addAttribute("employee",employeeServ.getEmployeeId(id));
	return "update";
}

@PostMapping("/employee/new/{id}")
public  String updateEmployee(@PathVariable Long id,@ModelAttribute("employee") Employee employee,Model model ) {
	Employee newEmployee = employeeServ.getEmployeeId(id);
	newEmployee.setId(id);
	newEmployee.setFirstName(employee.getFirstName());
	newEmployee.setLastName(employee.getLastName());
	newEmployee.setEmail(employee.getEmail());
	employeeServ.updateEmployee(newEmployee);
    return "redirect:/employee";
	
}


@GetMapping("/employee/delete/{id}")
public String removeEmployee(@PathVariable  Long id) {
	employeeServ.deleteEmployeeById(id);
	return "redirect:/employee";
}


	

}
