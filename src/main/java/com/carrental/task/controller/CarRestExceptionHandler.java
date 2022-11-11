package com.carrental.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CarRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(CarNotFoundException exc){
		CarErrorResponse errorResponse = new CarErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(), 
											System.currentTimeMillis());
	
		return new ResponseEntity<CarErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CarErrorResponse> handleException(Exception exc){
		CarErrorResponse errorResponse = new CarErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(), 
											System.currentTimeMillis());
	
		return new ResponseEntity<CarErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
