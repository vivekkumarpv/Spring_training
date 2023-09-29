package com.ticketpedia.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.model.User;
import com.ticketpedia.usermanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/newcustomer")
	public User addNewCustomer(@RequestBody User customer) {
		User newCustomer = userService.CustomerSignUp(customer);
		return newCustomer;

	}

	@PutMapping("/updatecustomer")
	public User updateCustomer(@RequestBody User customer) {
		User updatedCustomer = userService.updateCustomerCredentials(customer);
		return updatedCustomer;

	}

}
