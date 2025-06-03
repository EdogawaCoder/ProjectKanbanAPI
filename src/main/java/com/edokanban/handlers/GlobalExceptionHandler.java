package com.edokanban.handlers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.UnexpectedTypeException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>>
	handleValidationException(
	MethodArgumentNotValidException exception,
	WebRequest request
	) {
	var erros = exception.getBindingResult()
	.getFieldErrors()
	.stream()
	.map(error -> "Field: '"
	+ error.getField() + "' : "
	+ error.getDefaultMessage())
	.collect(Collectors.toList());
	var body = new HashMap<String, Object>();
	body.put("status", HttpStatus.BAD_REQUEST.value());
	body.put("errors", erros);
	return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Map<String, String>> handleUnexpectedType(UnexpectedTypeException ex) {
	    Map<String, String> error = new HashMap<>();
	    error.put("error", "Validation error unexpected: " + ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
