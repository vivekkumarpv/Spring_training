package com.airline.routes.dto;

import com.airline.flights.Model.Airline;
import com.airline.flights.Model.Airport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDetailedItineraryResponse {
	public int id;
	public Airport flyingFrom;
	public Airport flyingTo;
	public Airline airline;
	
}
