package com.zenvia.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends Exception{
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e) {
		return new ResponseEntity("BAD_REQUEST", HttpStatus.BAD_REQUEST);
	}
}
