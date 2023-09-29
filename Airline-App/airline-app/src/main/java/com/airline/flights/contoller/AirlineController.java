package com.airline.flights.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flights.Model.Airline;
import com.airline.flights.service.AirlineService;

@RestController
@RequestMapping("/api/airline")
@CrossOrigin(origins = "*")
public class AirlineController {

	@Autowired
	AirlineService airlineService;

	@GetMapping()
	public List<Airline> getAllAirlines() {
		return airlineService.getAirLine();

	}

	@GetMapping("/getbyiata/{iataCode}")
	public Airline fetchAirlineByIataCode(@PathVariable String iataCode) {
		Airline fetchedAirline = airlineService.getAirLineByIataCode(iataCode);
		return fetchedAirline;
	}
}
