package com.ticketpedia.ticketbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticketpedia.ticketbooking.dto.Bus;
import com.ticketpedia.ticketbooking.model.Rating;
import com.ticketpedia.ticketbooking.model.Ticket;
import com.ticketpedia.ticketbooking.service.TicketBookingService;

@RestController
@RequestMapping("/customer")
public class TicketBookingController {

	@Autowired
	TicketBookingService ticketBookingService;

	@GetMapping("/search/{date}/{origin}/{destination}")
	public List<Bus> searchBus(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable String origin, @PathVariable String destination) {

		return ticketBookingService.searchBus(date, origin, destination);
	}

	@GetMapping("/search/{date}/{origin}/{destination}/{category}")
	public List<Bus> searchBusByCategory(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			@PathVariable String origin, @PathVariable String destination, @PathVariable String category) {

		return ticketBookingService.getBusByCategory(date, origin, destination, category);
	}

	@PostMapping("/bookticket/{busNumber}/{numOfSeats}/{dateOfJourney}/{customerName}")
	public Ticket bookBusTicket(@PathVariable long busNumber, @PathVariable int numOfSeats,
			@PathVariable("dateOfJourney") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfJourney,
			@PathVariable String customerName) {
		return ticketBookingService.bookBusTicket(busNumber, numOfSeats, dateOfJourney, customerName);
	}
	
	@GetMapping("/viewtickets")
	public List<Ticket> viewBookedBusTickets(){
		return ticketBookingService.viewBookedBusTicket();
	}
	
	@DeleteMapping("/cancel/{ticketId}")
	public Ticket cancelBusTicket(@PathVariable int ticketId) {
		ticketBookingService.cancelBusTicket(ticketId);
		return ticketBookingService.getTicketById(ticketId);
	}
	
	@PostMapping("/addrating/{busId}/{customerId}/{rating}/{remarks}")
	public Rating addRating(@PathVariable int busId, @PathVariable int customerId,@PathVariable int rating, @PathVariable String remarks) { 
		return ticketBookingService.addRating(busId, customerId, rating, remarks);
	}
	
	@GetMapping("/viewrating")
	public List<Rating> viewRating(){
		return ticketBookingService.getAllRating();
	}
	
	@GetMapping("/viewrating/{customerId}")
	public List<Rating> viewRatingGivenByACustomer(@PathVariable int customerId){
		return ticketBookingService.getRatingsGivenByACustomer(customerId);
	}
}
