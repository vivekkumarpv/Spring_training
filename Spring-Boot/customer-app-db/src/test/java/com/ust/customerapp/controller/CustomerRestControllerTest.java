package com.ust.customerapp.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.ust.customerapp.model.Customer;
import com.ust.customerapp.service.CustomerService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = CustomerRestController.class)
class CustomerRestControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	CustomerService service;

	@Test
	void testAddCustomer() throws Exception {

		// Given
		Customer c1 = new Customer(105, "Steve", "steve@yahoo.com", LocalDate.of(2000, 10, 10));
		// When
		when(service.addCustomer(c1)).thenReturn(c1);

		// Then
		mockMvc.perform(post("/api/customers").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(c1)))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", Matchers.is(105)))
				.andExpect(jsonPath("$.customerName", Matchers.is("Steve")))
				.andExpect(jsonPath("$.email", Matchers.is("steve@yahoo.com")))
				.andExpect(jsonPath("$.dob", Matchers.is("2000-10-10")));

	}
//
//	@Test
//	void testUpdateCustomer() {
//		fail("Not yet implemented");
//	}

	@Test
	void testGetCustomer() throws Exception {
		Customer c1 = new Customer(1001, "amal", "amal@gmail.com", LocalDate.of(2000, 02, 24));
		int id = c1.getId();
		when(service.getCustomer(id)).thenReturn(c1);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/customers/" + id))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.is(1001)))
				.andExpect(jsonPath("$.customerName", Matchers.is("amal")))
				.andExpect(jsonPath("$.email", Matchers.is("amal@gmail.com")))
				.andExpect(jsonPath("$.dob", Matchers.is("2000-02-24")));

	}

//	@Test
//	void testGetAllCustomers() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteCustomerById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetCustomerByName() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearchCustomerByDobRange() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testSearcgCustomerByIdInRange() {
//		fail("Not yet implemented");
//	}
	public String asJsonString(Customer c) throws Exception {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(c);
		return json;
	}

}
