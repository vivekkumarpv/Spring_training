package com.ust.customerapp.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.customerapp.model.Customer;
import com.ust.customerapp.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo repo ;
	
	@PostConstruct
	public void init(){
		Customer c1 = new Customer(1001, "vivek", "vivek@gmail.com", LocalDate.of(2000,1,29));
		Customer c2 = new Customer(1002, "anagha", "anagha@gmail.com", LocalDate.of(1997,5,4));
		Customer c3 = new Customer(1003, "ebin", "ebin@gmail.com", LocalDate.of(2000,10,29));
		repo.addCustomer(c1);
		repo.addCustomer(c2);
		repo.addCustomer(c3);
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cus = repo.addCustomer(customer);
		return cus;
	}

	@Override
	public Customer getCustomer(int id) {
		Customer cus=repo.getCustomer(id);
		return cus;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cus=repo.updateCustomer(customer);
		return cus;
	}

	@Override
	public void deleteCustomer(int id) {
		repo.deleteCustomer(id);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return repo.getAllCustomers();
	}

	@Override
	public Customer getCustomerByName(String name) {
		Customer cus=repo.getCustomerByName(name);
		return cus;
	}

}
