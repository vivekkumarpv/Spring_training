package com.airline.flights.exception;

public class AirlineNotFoundException extends RuntimeException {
	public AirlineNotFoundException(String message) {
		super(message);
	}
}
