package com.airline.flights.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.flights.Model.Airport;
import com.airline.flights.repository.AirportRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepo airportRepo;

	@Override
	public List<Airport> getAllAirports() {
		List<Airport> dataList = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Specify the path to your JSON file
			File jsonFile = new File("C:\\Airline-App\\airports.json");

			// Read JSON data into a List of MyJsonObject
			dataList = objectMapper.readValue(jsonFile, new TypeReference<List<Airport>>() {
			});

			// Now you can work with the 'dataList' which contains a list of JSON objects.
			for (Airport obj : dataList) {
				airportRepo.save(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

	}

	@Override
	public Airport getAirportByIataCode(String iataCode) {
		Airport fetchedAirport= airportRepo.getAirportByIataCode(iataCode);
		return fetchedAirport;
	}

	@Override
	public List<Airport> getAirportSuggestions(String starting) {
		List<Airport> airportSuggestionList=airportRepo.getAirportSuggestions(starting);
		return airportSuggestionList;
	}

	

}
