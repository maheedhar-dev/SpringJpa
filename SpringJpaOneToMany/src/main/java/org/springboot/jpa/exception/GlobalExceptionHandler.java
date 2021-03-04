package org.springboot.jpa.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springboot.jpa.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = DataException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(Exception ex,HttpServletRequest request,HttpServletResponse response){
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), Integer.valueOf( HttpStatus.INTERNAL_SERVER_ERROR.value()),request.getRequestURL().toString());
		return new ResponseEntity<ErrorMessage>(errorMessage,HttpStatus.OK);
	}
}
