package com.airline.flights.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.airline.flights.Model.Airline;
import com.airline.flights.repository.AirlineRepo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AirlineServiceImpl implements AirlineService {
	
	@Autowired
	AirlineRepo airlineRepo;

	@Override
	public List<Airline> getAirLine() {

		List<Airline> dataList = new ArrayList<>();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// Specify the path to your JSON file
			File jsonFile = new File("C:\\Airline-App\\airlines.json");

			// Read JSON data into a List of java object
			dataList = objectMapper.readValue(jsonFile, new TypeReference<List<Airline>>(){});

			// Now you can work with the 'dataList' which contains a list of JSON objects.
			for (Airline obj : dataList) {
				airlineRepo.save(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dataList;

	}

	@Override
	public Airline getAirLineByIataCode(String iataCode) {
		Airline fetchedAirline =airlineRepo.getAirlineByIataCode(iataCode);
		return fetchedAirline;
	}

}
