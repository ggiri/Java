package com.gigo.car;

public class Car {
	String color;
	String type;
	int serialNumber;
	static int carCount;
	{
		this.color ="red";
		this.type = "celica";
	}
	Car(){
		carCount++;
		serialNumber = carCount;
	}
	
	Car(String color, String type){
		this();
		this.color =color;
		this.type = type;
	}
	
	String getDescription() {
		String desc = "This is a "+this.color+" "+this.type;
		return desc;
	}
	
	void customize(String color, String type) {
		this.color = color;
		this.type = type + " " + this.type;
		System.out.println(getDescription());
	}
	void start() {
		System.out.println("Get Started");
	}
	
	void printDescription() {
		System.out.println("This is a "+this.color+" "+this.type);
	}
	static void resetCarCount() {
		carCount = 0;
	}
}
