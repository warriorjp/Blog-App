package com.springboot.blog.springbootblogapp.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springboot.blog.springbootblogapp.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerResourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), 
				webRequest.getDescription(false));
		
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handlerGlobalException(Exception exception,
			WebRequest webRequest){
		ErrorDetails errorDetails=new ErrorDetails(new Date(), exception.getMessage(), 
				webRequest.getDescription(false));
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}

}
