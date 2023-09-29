package com.ust.bookapp.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ust.bookapp.dto.ErrorResponse;
import com.ust.bookapp.exceptionhandling.BookNotFoundException;

@RestControllerAdvice
public class BookErrorController {
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e, HttpServletRequest request){
		HttpStatus status=HttpStatus.NOT_FOUND;
		ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}
	
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorResponse> handleValidationException(ValidationException e, HttpServletRequest request){
		HttpStatus status=HttpStatus.BAD_REQUEST;
		ErrorResponse body =new ErrorResponse(LocalDateTime.now(), status.value(), status.getReasonPhrase(), e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(body);
	}
}
