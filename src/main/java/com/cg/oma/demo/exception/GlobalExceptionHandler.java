package com.cg.oma.demo.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.oma.demo.response.Response;




	@RestControllerAdvice
	public class GlobalExceptionHandler {
		
		 @ExceptionHandler(MethodArgumentNotValidException.class)
		 ResponseEntity<Response> exceptionForValidation(MethodArgumentNotValidException msg, HttpServletRequest requests){
			 Map<String,String > m = new LinkedHashMap<>();
			 List<ObjectError> list= msg.getBindingResult().getAllErrors();
			 list.forEach(obj->{
				 FieldError fe= (FieldError) obj;
				 String fieldname= fe.getField();
				 String errormsg= fe.getDefaultMessage();
				 m.put(fieldname, errormsg);
			 });
			 Response Info=new Response(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), m.toString(), requests.getRequestURI());
				ResponseEntity<Response> rentity=new ResponseEntity<>(Info,HttpStatus.NOT_FOUND);
			 return rentity;
		 }
		 
		 
		@ExceptionHandler(Exception.class)
	  ResponseEntity<Response> globalException(Exception e , HttpServletRequest request) {
			Response Info=new Response(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), e.getMessage(), request.getRequestURI());
			ResponseEntity<Response> rentity=new ResponseEntity<>(Info,HttpStatus.NOT_FOUND);
		 return rentity;
		}
		 
		
}
