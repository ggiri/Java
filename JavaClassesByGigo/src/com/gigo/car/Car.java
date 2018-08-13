package com.gigo.car;

public class Car {
	String color;
	String type;
	int serialNumber;
	static int carCount;
	{
		color ="red";
		type = "celica";
	}
	Car(){
		carCount++;
		serialNumber = carCount;
	}
	
	Car(String color, String type){
		this.color =color;
		this.type = type;
	}
	
	String getDescription() {
		String desc = "This is a "+color+" "+type;
		return desc;
	}
	
	void customize(String newColor, String newType) {
		color = newColor;
		type = newType + " " + type;
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
