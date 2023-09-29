package com.ticketpedia.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticketpedia.usermanagement.model.Customer;
import com.ticketpedia.usermanagement.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
