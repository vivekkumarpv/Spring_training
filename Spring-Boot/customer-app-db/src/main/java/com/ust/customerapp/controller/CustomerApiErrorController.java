package com.ust.customerapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.customerapp.dto.ErrorResponse;
import com.ust.customerapp.exceptionhandling.CustomerNotFoundException;
import com.ust.customerapp.exceptionhandling.DuplicateCustomerException;

@RestControllerAdvice
public class CustomerApiErrorController {
	
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> hanldeCustomerNotFoundException(CustomerNotFoundException e, HttpServletRequest request) {
		HttpStatus status=HttpStatus.NOT_FOUND;
		ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
		
	}
	
	@ResponseStatus(code=HttpStatus.CONFLICT)
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<ErrorResponse> hanldeDuplicateCustomerException(DuplicateCustomerException e, HttpServletRequest request) {
		HttpStatus status=HttpStatus.CONFLICT;
		ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
		
	}
	
	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> hanldeOtherException(Exception e, HttpServletRequest request) {
		HttpStatus status=HttpStatus.INTERNAL_SERVER_ERROR;
		ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
		
	}


	
	
//	@ResponseStatus(code=HttpStatus.CONFLICT)
//	@ExceptionHandler(DuplicateCustomerException.class)
//	public String hanldeDuplicateCustomerFoundException(DuplicateCustomerException e) {
//		return e.getMessage();
//	}

}
