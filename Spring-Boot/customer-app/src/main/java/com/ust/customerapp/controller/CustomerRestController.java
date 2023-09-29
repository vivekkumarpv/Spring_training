package com.ust.customerapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ust.customerapp.model.Customer;
import com.ust.customerapp.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerService service;
	
	@ResponseStatus(code=HttpStatus.CREATED)
	@PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer customer) {
		return service.updateCustomer(customer);
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("{id}")
	public Customer getCustomer(@PathVariable int id) {
		return service.getCustomer(id);
	}
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping
	public List<Customer> getAllCustomers(){
		return service.getAllCustomers();
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void deleteCustomerById(@PathVariable int id) {
		service.deleteCustomer(id);
	}
	
	@GetMapping("/name/{name}")
	@ResponseStatus(code=HttpStatus.OK)
	public Customer getCustomerByName(@PathVariable String name) {
		return service.getCustomerByName(name);
		
	}
	
	
	
}
