package com.ust.customerapp.exceptionhandling;

public class DuplicateCustomerException extends RuntimeException {
	public DuplicateCustomerException(String message) {
		super(message);
	}
}
