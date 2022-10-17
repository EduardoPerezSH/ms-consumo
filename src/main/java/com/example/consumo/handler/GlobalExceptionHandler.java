package com.example.consumo.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value =  MethodArgumentNotValidException.class)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?>  getSerException(MethodArgumentNotValidException ex){

		logger.error(ex);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = BadRequest.class)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<?>  handlerBadRequest(BadRequest ex) {

		logger.error(ex);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", ex.getMessage().toString());
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); 
	}
	@ExceptionHandler(value = Forbidden.class)	
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>>  handlerException(Forbidden ex) {

		logger.error(ex);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", ex.getMessage().toString());
		return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(value = Exception.class)	
	//@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Map<String, Object>>  handlerException(Exception ex) {

		logger.error(ex);

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("mensaje", ex.getMessage().toString());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
