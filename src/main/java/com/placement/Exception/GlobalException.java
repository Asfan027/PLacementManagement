package com.placement.exception;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalException extends RuntimeException {
	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ApiResponse> ResourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse();
		return new ResponseEntity<ApiResponse>(response, HttpStatus.BAD_REQUEST);

	}

//	@ExceptionHandler(DataIntegrityViolationException.class)
//	public ResponseEntity<Set<String>> DataIntegrityViolationException(DataIntegrityViolationException dt)
//	{
//		Set<String> set = new HashSet<String>();
//		dt.get
//		
//	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Set<String>> constraintViolationException(ConstraintViolationException cv)

	{
		Set<String> set = new HashSet<String>();
		cv.getConstraintViolations().forEach(constraint -> {
			String message = constraint.getMessage();
			set.add(message);
		});
		return new ResponseEntity<Set<String>>(set, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<ApiResponse> DataIntegrityViolationException(HttpServletRequest req, DataIntegrityViolationException e) {
//        //return exceptionInfoHandler.getApiResponseResponseEntity(req, e, HttpStatus.CONFLICT);
//        return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
//    }
}
