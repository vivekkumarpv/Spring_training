package com.simpleapp.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simpleapp.employee.model.Employee;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
public class EmployeeController {
	List<Employee> employeeList = new ArrayList<>();

	@GetMapping("/getall")
	public List<Employee> getAllEmployee() {
		return employeeList;
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		employeeList.add(emp);
		return emp;
	}

}
