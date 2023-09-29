package com.ust.customerapp.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ust.customerapp.exceptionhandling.CustomerNotFoundException;
import com.ust.customerapp.exceptionhandling.DuplicateCustomerException;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.repository.CustomerRepo;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplUnitTest {

	@Mock
	private CustomerRepo repo; // which class/object we are mocking

	@InjectMocks
	private CustomerServiceImpl service;

	@Test
	void testAddCustomer() {
		// given
		Customer c4 = new Customer(1005, "amal", "amal@gmail.com", LocalDate.of(2000, 02, 24));
		Customer c5 = new Customer(1006, "vivek", "vivek@gmail.com", LocalDate.of(2000, 01, 29));

		// when
		when(repo.save(c4)).thenReturn(c4);
		when(repo.save(c5)).thenThrow(DuplicateCustomerException.class);
		Customer savedCustomer = service.addCustomer(c4);

		// then
		assertEquals(c4, savedCustomer);
		assertThrows(DuplicateCustomerException.class, () -> service.addCustomer(c5));
		// verify whether repo.save() is called 1 time
		verify(repo, times(1)).save(c4);
		verify(repo, times(1)).save(c5);
	}

	@Test
	void testGetCustomer() {
		// given
		int id1 = 1001;
		int id2 = 1009;
		Customer c1 = new Customer(1001, "amal", "amal@gmail.com", LocalDate.of(2000, 02, 24));

		// when
		when(repo.findById(id1)).thenReturn(Optional.of(c1));
		when(repo.findById(id2)).thenThrow(CustomerNotFoundException.class);

		// then
		assertEquals(c1, service.getCustomer(id1));
		assertThrows(CustomerNotFoundException.class, () -> service.getCustomer(id2));

		// Verify whether repo.save() method is called 1 time
		verify(repo, times(1)).findById(id1);
		verify(repo, times(1)).findById(id2);

	}

	@Test
	void testUpdateCustomer() {
		Customer c4 = new Customer(1005, "amal", "amal@gmail.com", LocalDate.of(2000, 02, 24));
		Customer c2 = new Customer(1002, "Shyma", "shyma@gmail.com", LocalDate.of(1998,2,24));
		
		when(repo.existsById(1005)).thenReturn(true);
		when(repo.existsById(1002)).thenReturn(false);
		when(repo.save(c4)).thenReturn(c4);
		lenient().when(repo.save(c2)).thenThrow(CustomerNotFoundException.class);
		
		Customer updatedCustomer=service.updateCustomer(c4);
		
		assertEquals(c4,updatedCustomer);
		assertThrows(CustomerNotFoundException.class,()->service.updateCustomer(c2));
		
		verify(repo, times(1)).save(c4);
		verify(repo, times(1)).existsById(1005);
		verify(repo, times(1)).existsById(1002);
		
	}

	@Test
	void testDeleteCustomer() {
		int id1=1001;
		int id2=1002;
				
		when(repo.existsById(id1)).thenReturn(true);
		when(repo.existsById(id2)).thenReturn(false);
		
		assertDoesNotThrow(()->service.deleteCustomer(id1));
		assertThrows(CustomerNotFoundException.class,()->service.deleteCustomer(id2));
		
		verify(repo,times(1)).deleteById(id1);
		verify(repo,times(1)).existsById(id2);
		
	}

	@Test
	void testGetAllCustomers() {
		Customer c1 = new Customer(1001, "Vivek", "vivek@gmail.com", LocalDate.of(2000,1,29));
		Customer c2 = new Customer(1003, "Shyma", "shyma@gmail.com", LocalDate.of(1998,2,24));
		
		List<Customer> customerList = new ArrayList<>(List.of(c1,c2));
		
		when(repo.findAll()).thenReturn(customerList);
		
		assertEquals(customerList, service.getAllCustomers());
		
		verify(repo,times(1)).findAll();
		
	}
//
	@Test
	void testGetCustomerByName() {
		Customer c1 = new Customer(1001, "Vivek", "vivek@gmail.com", LocalDate.of(2000,1,29));
		String customerName=c1.getCustomerName();
		when(repo.findByCustomerName(customerName)).thenReturn(Optional.of(c1));
		assertEquals(c1, service.getCustomerByName(customerName));
		verify(repo, times(1)).findByCustomerName(customerName);
	}
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
