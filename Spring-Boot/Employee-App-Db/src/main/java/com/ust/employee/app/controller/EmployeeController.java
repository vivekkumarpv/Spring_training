package com.ust.employee.app.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.employee.app.model.Employee;
import com.ust.employee.app.repository.EmployeeRepo;
class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeRepo repo;
	
	@PostMapping
	//@ResponseStatus(code=HttpStatus.ACCEPTED)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		Employee savedEmp=repo.save(emp);
		return ResponseEntity.accepted().body(savedEmp);
	}
	
	@GetMapping("/{id}")
	//@ResponseStatus(code=HttpStatus.OK)
	public ResponseEntity<Employee> getEmployeeById( @PathVariable int id) {
		Optional<Employee> optEmp=repo.findById(id);
		//Employee emp=null;
		//HttpStatus status=HttpStatus.OK;
		if(optEmp.isPresent()) {
			Employee emp=optEmp.get();
			return ResponseEntity.ok().body(emp);
		}
//		ResponseEntity.status(status).body(emp);  same as what is returned above
//		ResponseEntity.ok(emp);                   same as what is returned above
		else {
			//throw new EmployeeNotFoundException("Employee with id "+id+" not found");
			return ResponseEntity.noContent().build();
		}
		
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id ,@RequestBody Employee emp) {
		Optional<Employee> updEmp=repo.findById(id);
		if(updEmp.isPresent()) {
			Employee updatedEmp=repo.save(emp);
			return ResponseEntity.accepted().body(updatedEmp);
		}
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping()
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> empList=repo.findAll();
		return ResponseEntity.ok().body(empList);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable int id) {
		Optional<Employee> optEmp=repo.findById(id);
		if(optEmp.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
