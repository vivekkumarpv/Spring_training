package com.ust.foodapp.exceptionhandling;

public class InvalidCategoryException extends RuntimeException{
	public InvalidCategoryException(String message) {
		super(message);
	}
}
