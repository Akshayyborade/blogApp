package com.BlogApplication.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.BlogApplication.payload.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String massage= ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(massage,false);
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
		
		
	}

}
