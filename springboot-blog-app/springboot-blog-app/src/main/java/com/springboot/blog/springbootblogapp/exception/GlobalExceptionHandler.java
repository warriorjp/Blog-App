package com.springboot.blog.springbootblogapp.exception;


import java.net.http.HttpHeaders;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.blog.springbootblogapp.model.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	


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
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request){
		
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName =((FieldError)error).getField();
			String message=error.getDefaultMessage();
			errors.put(fieldName, message);
		});
		
		return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
	}
}
