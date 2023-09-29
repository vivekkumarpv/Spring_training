package com.ust.customerapp.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ust.customerapp.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
	public Optional<Customer> findByCustomerName(String customerName);
	
	// JPQL
	@Query("from Customer where dob between :from and :to")
	public List<Customer> findByDobRange(LocalDate from,LocalDate to);
	
	//Native SQL
	@Query(value="select * from customer where id between :start and :end" ,nativeQuery = true)
	public List<Customer> findIdInRange(int start,int end);
}
