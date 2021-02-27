package com.tracker.patienttracker.error;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tracker.patienttracker.model.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<?> handleUnauthorizedException(UnauthorizedException ex){
		return ResponseEntity.badRequest().body(new ErrorResponse("Unauthorized", LocalDateTime.now(), ex.getMessage()));
	}
	
	@ExceptionHandler(MissingRequestHeaderException.class)
	public ResponseEntity<?> handleMissingRequestHeaderException(MissingRequestHeaderException ex) {
		return ResponseEntity.badRequest().body(new ErrorResponse("Bad Request", LocalDateTime.now(), ex.getMessage()));
	}
	
	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<?> handleInvalidTokenException(InvalidTokenException ex){
		return ResponseEntity.badRequest().body(new ErrorResponse("Bad Request", LocalDateTime.now(), ex.getMessage()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest request){
		return ResponseEntity.badRequest().body(new ErrorResponse("Bad Request", LocalDateTime.now(), ex.getMessage()));
	}

}
