package com.gigo.car;

import java.awt.Point;

public class Jaguar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car("Black", "JAGUAR XF");
		car.printDescription();
		Point point = new Point(3,4);
		System.out.println(point);
		int x=0, y=0;
		x= x++;
		y++;
		System.out.println("x : y"+ x+y);
		System.out.println("x : y"+ x+ y);
		int i =0;
		while(true) {
			System.out.println(i++);
		}

	}

}
