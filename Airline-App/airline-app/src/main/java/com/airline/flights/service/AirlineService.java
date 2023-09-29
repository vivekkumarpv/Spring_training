package com.airline.flights.service;

import java.util.List;

import com.airline.flights.Model.Airline;

public interface AirlineService {
	public List<Airline> getAirLine();

	public Airline getAirLineByIataCode(String iataCode);

}
