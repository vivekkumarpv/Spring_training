package com.airline.flights.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airline.flights.Model.Airport;
import com.airline.flights.service.AirportService;

@RestController
@RequestMapping("/api/airport")
@CrossOrigin(origins = "*")
public class AirportController {

	@Autowired
	AirportService airportService;

	@GetMapping()
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();

	}

	@GetMapping("/getbyiata/{iataCode}")
	public Airport fetchAirportByIataCode(@PathVariable String iataCode) {
		Airport fetchedAirport = airportService.getAirportByIataCode(iataCode);
		return fetchedAirport;
	}

	@PostMapping("/suggest")
	public List<Airport> getAirportSuggestions(@RequestParam String starting) {
		List<Airport> airportSuggestionList = airportService.getAirportSuggestions(starting);
		return airportSuggestionList;
	}
}
