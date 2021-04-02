package com.ecommerce.order.exceptions;

public class HTTP400Exception extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3718616277843675168L;

	public HTTP400Exception() {
		super();
	}
	
	public HTTP400Exception(String message, Throwable cause) {
		super(message,cause);
	}
	
	public HTTP400Exception(String message) {
		super(message);
	}
	
	public HTTP400Exception(Throwable cause) {
		super(cause);
	}
}
