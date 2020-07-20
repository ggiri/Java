package com.acme.utils;

public class InvalidDateException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9033922565685051012L;

	public InvalidDateException(MyDate date) {
		super("Invalid date:"+ date);
	}

}
