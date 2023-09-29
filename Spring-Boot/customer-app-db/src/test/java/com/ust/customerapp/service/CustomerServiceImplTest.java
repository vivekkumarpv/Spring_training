package com.ust.customerapp.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.customerapp.exceptionhandling.CustomerNotFoundException;
import com.ust.customerapp.exceptionhandling.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;

@SpringBootTest
class CustomerServiceImplTest {
	
	@Autowired
	private CustomerService service;
	
	@Test
	void testAddCustomer() {
		//given
		Customer c4 = new Customer(1005, "amal", "amal@gmail.com", LocalDate.of(2000,02,24));
		
		//when
		Customer savedCustomer=service.addCustomer(c4);
		
		//then
		assertThrows(DuplicateCustomerException.class,()->service.addCustomer(c4));
	}

	@Test
	void testGetCustomer() {
		//given 
		int id=1001;
		
		//when
		Customer c1=service.getCustomer(id);
		
		//then
		assertNotNull(c1);
	}

	@Test
	void testUpdateCustomer() {
		Customer c1 = new Customer(1001, "Vivek Kumar", "vivek@yahoo.com", LocalDate.of(2000,1,29));
		Customer updatedCustomer=service.updateCustomer(c1);
		assertEquals(c1,updatedCustomer );
	}

	@Test
	void testDeleteCustomer() {
		int id=1002;
//		service.deleteCustomer(id);
		assertDoesNotThrow(()->service.deleteCustomer(id));
		
	}
//
//	@Test
//	void testGetAllCustomers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerByName() {
//		
//	}
//
//	@Test
//	void testGetCustomerByDobRange() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerInIdRange() {
//		fail("Not yet implemented");
//	}

}
