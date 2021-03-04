package org.springboot.jpa.model;

public class ErrorMessage {
	
	private String message;
	private Integer errorCode;
	private String requestedUri;
	
	 

	public ErrorMessage(String message, Integer errorCode, String requestedUri) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.requestedUri = requestedUri;
	}

	 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getRequestedUri() {
		return requestedUri;
	}

	public void setRequestedUri(String requestedUri) {
		this.requestedUri = requestedUri;
	}
	
	
	
	
}
