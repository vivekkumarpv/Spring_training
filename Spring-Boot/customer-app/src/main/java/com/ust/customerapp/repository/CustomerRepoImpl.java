package com.ust.customerapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ust.customerapp.exceptionhandling.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;

@Repository
public class CustomerRepoImpl implements CustomerRepo {
	List<Customer> customerList = new ArrayList<>();

	@Override
	public Customer addCustomer(Customer customer){
		Customer existingCustomer=getCustomer(customer.getId());
		if(existingCustomer!=null) {
			throw new DuplicateCustomerException("Customer Already Exists");
		}else {
			customerList.add(customer);
		}
		
		return customer;
	}

	@Override
	public Customer getCustomer(int id) {
		for (Customer customer : customerList) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		int id = customer.getId();
		Customer cus = getCustomer(id);
		customerList.remove(cus);
		cus.setCustomerName(customer.getCustomerName());
		cus.setEmail(customer.getEmail());
		cus.setDob(customer.getDob());
		customerList.add(cus);
		return cus;
	}

	@Override
	public void deleteCustomer(int id) {
		Customer cus = getCustomer(id);
		customerList.remove(cus);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerList;
	}

	@Override
	public Customer getCustomerByName(String name) {
		for(Customer cus:customerList) {
			if(cus.getCustomerName().equalsIgnoreCase(name)) {
				return cus;
			}
		}
		return null;
	}

}
