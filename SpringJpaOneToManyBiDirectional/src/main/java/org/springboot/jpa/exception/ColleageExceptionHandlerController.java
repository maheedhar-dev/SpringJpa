package org.springboot.jpa.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ColleageExceptionHandlerController {
	
	@ExceptionHandler(ColleageDataException.class)
	public ResponseEntity<ErrorCode> ColleageExceptionHandler(Exception ex,HttpServletRequest request){
		 ErrorCode errorCode = new ErrorCode(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURL().toString());
		return new ResponseEntity<ErrorCode>(errorCode,HttpStatus.OK);
	}
	
}
