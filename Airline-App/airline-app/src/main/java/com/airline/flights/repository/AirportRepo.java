package com.airline.flights.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airline.flights.Model.Airport;

public interface AirportRepo extends JpaRepository<Airport, Integer> {

	@Query(value = "from Airport where iataCode=:iataCode")
	public Airport getAirportByIataCode(String iataCode);

	@Query(value = "from Airport where city like :starting% or state like :starting% or iataCode like :starting% ")
	public List<Airport> getAirportSuggestions(String starting);

}
