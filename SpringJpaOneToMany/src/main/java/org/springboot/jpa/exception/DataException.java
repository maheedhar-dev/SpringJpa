package org.springboot.jpa.exception;

public class DataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4360434328975116345L;

	public DataException() {
	}
	
	public DataException(String message){
		super(message);
	}
	
}
