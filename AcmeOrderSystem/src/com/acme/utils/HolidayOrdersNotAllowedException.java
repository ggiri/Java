package com.acme.utils;

public class HolidayOrdersNotAllowedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HolidayOrdersNotAllowedException(MyDate date){
		super("Orders are not allowed to be created on: " + date);
	}

}
