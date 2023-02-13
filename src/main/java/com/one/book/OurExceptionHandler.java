package com.one.book;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
//public class OurExceptionHandler {
//
//	@ExceptionHandler(Exception.class)
//	ResponseEntity<String> handleException(Exception e){
//		ResponseEntity<String> re = new ResponseEntity<String>("Got Exception",HttpStatus.INTERNAL_SERVER_ERROR);
//		return re;
//	}
//	
//	@ExceptionHandler(IOException.class)
//	ResponseEntity<String> handleIOException(IOException e){
//		ResponseEntity<String> re = new ResponseEntity<String>("Got IO Exception",HttpStatus.INTERNAL_SERVER_ERROR);
//		return re;
//	}
//}
