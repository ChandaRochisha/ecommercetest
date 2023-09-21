package com.dnb.ecommerce.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dnb.ecommerce.exceptions.IdNotFoundException;

@ControllerAdvice
public class AppAdvice {//displays exception messages in short.
	@ResponseStatus(value=HttpStatus.NOT_FOUND ,reason="invalid id provided")
	@ExceptionHandler(IdNotFoundException.class)
	
	
	public void invalidProductIdExceptionHandler(IdNotFoundException e) {
		Map<String, String> map = new HashMap<>();

		map.put("message", "id not found");

		map.put("Httpstatus", HttpStatus.NOT_FOUND + "");

	}
	
}
