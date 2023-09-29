package com.ust.customerapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.customerapp.exceptionhandling.CustomerNotFoundException;
import com.ust.customerapp.exceptionhandling.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.repository.CustomerRepo;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo repo ;
	
//	@PostConstruct
//	public void init(){
//		Customer c1 = new Customer(1001, "vivek", "vivek@gmail.com", LocalDate.of(2000,1,29));
//		Customer c2 = new Customer(1002, "anagha", "anagha@gmail.com", LocalDate.of(1997,5,4));
//		Customer c3 = new Customer(1003, "ebin", "ebin@gmail.com", LocalDate.of(2000,10,29));
//		repo.addCustomer(c1);
//		repo.addCustomer(c2);
//		repo.addCustomer(c3);
//	}
	

	public Customer addCustomer(Customer customer) {
		int id=customer.getId();
		if(repo.existsById(id)) {
			throw new DuplicateCustomerException("Customer with id "+id+" already present");
		}
		Customer cus = repo.save(customer);
		return cus;
	}

	
	public Customer getCustomer(int id) {
		Customer cus=repo.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with id "+id+" not found"));
		return cus;
	}

	
	public Customer updateCustomer(Customer customer) {
		int id=customer.getId();
		if(!repo.existsById(id)) {
			throw new CustomerNotFoundException("Customer with id "+id+" not found");
		}
		Customer cus=repo.save(customer);
		return cus;
	}

	
	public void deleteCustomer(int id) {
		if(!repo.existsById(id)) {
			throw new CustomerNotFoundException("Customer with id "+id+" not found");
		}
		repo.deleteById(id);
	}

	
	public List<Customer> getAllCustomers() {
		return repo.findAll();
	}

	public Customer getCustomerByName(String customerName) {
		
		return repo.findByCustomerName(customerName).orElseThrow(()->
		new CustomerNotFoundException("Customer with name "+customerName+" not found"));
	}


	@Override
	public List<Customer> getCustomerByDobRange(LocalDate from, LocalDate to) {
		
		return repo.findByDobRange(from, to);
		
	}


	@Override
	public List<Customer> getCustomerInIdRange(int start, int end) {
		
		return repo.findIdInRange(start, end);
	}

}
