package com.airline.flights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airline.flights.Model.Airline;

public interface AirlineRepo extends JpaRepository<Airline, Integer> {

	@Query(value=" from Airline where code =:iataCode")
	public Airline getAirlineByIataCode(String iataCode);
}
