package com.GestionePrenotazioni.Exceptionheader;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

public class MyEceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(EntityExistsException.class)
		public ResponseEntity<String> manageEntityExistException(EntityExistsException e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> manageEntityExistException(EntityNotFoundException e){
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.FOUND);
	}
	
}
