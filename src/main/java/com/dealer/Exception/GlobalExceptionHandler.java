package com.dealer.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = NameNotFound.class)
	public ResponseEntity<Object> noname(NameNotFound m) {
		return new ResponseEntity<>(m.getMessage(), HttpStatus.NOT_FOUND);
	}

}
