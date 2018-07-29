package com.gigo.car;

public class Car {
	String color;
	String type;
	
	Car(String color, String type){
		this.color =color;
		this.type = type;
	}
	void start() {
		System.out.println("Get Started");
	}
	
	void printDescription() {
		System.out.println("This is a "+this.color+" "+this.type);
	}
}
