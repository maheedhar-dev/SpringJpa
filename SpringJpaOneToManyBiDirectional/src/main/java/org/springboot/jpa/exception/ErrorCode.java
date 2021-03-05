package org.springboot.jpa.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorCode {

	String errorMessage;
	Integer errorCode;
	String path;
	
}
