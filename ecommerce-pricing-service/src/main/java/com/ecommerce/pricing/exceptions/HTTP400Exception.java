package com.ecommerce.pricing.exceptions;

public class HTTP400Exception extends RuntimeException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5821405213568135838L;

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
