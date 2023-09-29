package com.ticketpedia.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticketpedia.ticketbooking.model.Ticket;

@Repository
public interface TicketBookingRepository extends JpaRepository<Ticket,Integer> {

}
