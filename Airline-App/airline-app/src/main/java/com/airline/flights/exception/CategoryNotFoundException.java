package com.airline.flights.exception;

public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException(String message) {
		super(message);
	}
}
