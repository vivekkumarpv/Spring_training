package com.ust.foodapp.exceptionhandling;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException(String message) {
		super(message);
	}
}
