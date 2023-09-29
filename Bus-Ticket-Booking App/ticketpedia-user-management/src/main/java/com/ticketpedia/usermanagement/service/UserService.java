package com.ticketpedia.usermanagement.service;

import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.model.User;

public interface UserService {

	public User CustomerSignUp(User user);

	public User updateCustomerCredentials(User user);

	public Customer createCustomerProfile(Customer customer);

	public Customer updateCustomerProfile(Customer customer);

}
