package com.airline.flights.exception;

public class AirportNotFoundException extends RuntimeException {
	public AirportNotFoundException(String message) {
		super(message);
	}
}
