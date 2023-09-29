package com.ticketpedia.usermanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketpedia.usermanagement.exception.AccountNotFoundException;
import com.ticketpedia.usermanagement.exception.CustomerAlreadyExistException;
import com.ticketpedia.usermanagement.exception.CustomerNotFoundException;
import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.model.User;
import com.ticketpedia.usermanagement.repository.CustomerRepository;
import com.ticketpedia.usermanagement.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public User CustomerSignUp(User user) {
		User userPresent = userRepository.findById(user.getUserId()).get();
		if (userPresent.getEmail().equals(user.getEmail())) {
			throw new CustomerAlreadyExistException("Customer with email " + user.getEmail() + " already exixts");

		} else {

			User newUser = userRepository.save(user);
			return newUser;
		}

	}

	@Override
	public User updateCustomerCredentials(User user) {
		Optional<User> optUser = userRepository.findById(user.getUserId());
		if (optUser.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		User updUser = userRepository.save(optUser.get());

		return updUser;
	}

	@Override
	public Customer createCustomerProfile(Customer customer) {
		boolean existingUser = userRepository.existsById(customer.getUserId());
		if (!existingUser) {
			throw new AccountNotFoundException("Account not found");
		}
		Customer customerProfile = customerRepository.save(customer);
		return customerProfile;
	}

	@Override
	public Customer updateCustomerProfile(Customer customer) {
		Optional<Customer> existingCustomer = customerRepository.findById(customer.getUserId());
		if (existingCustomer.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found");
		}
		Customer updatedCustomer = customerRepository.save(customer);

		return updatedCustomer;
	}

}
