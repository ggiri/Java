package com.acme.utils;

public class MyDate {
	public int day;
	public int month;
	public int year;
	
	{
		day = 1;
		month = 1;
		year = 2000;
	}
	
	public MyDate() {}
	
	public MyDate(int d, int m, int y) {
		setDate(m,d,y);
	}
	
	public String toString() {
		return month+"/"+day+"/"+year;
	}
	
	public void setDate(int m, int d, int y) {
		day=d;
		month=m;
		year=y;
	}
	
}
