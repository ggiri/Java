package com.acme.testing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Order;
import com.acme.domain.Service;
import com.acme.domain.Solid;
import com.acme.utils.MyDate;

public class TestOrders {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyDate date1 = new MyDate(20, 01, 2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate(10, 4, 2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();
		Order.setTaxRate(0.06);
		System.out.println("The tax Rate is currently: " + Order.taxRate);
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		MyDate date3 = new MyDate(1, 1, 2016);

		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		balloons.setQuantity(-200);

//		System.out.println("The volume of the anvil is: " + anvil.getProduct().volume());
		if(anvil.getProduct() instanceof Solid) {
			System.out.println("The length of the anvil is: " + ((Solid)anvil.getProduct()).getLength());
		}
		
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3, 20000, "Daffy Duck",
		s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is "
		+ birdEradication.computeTotal());
		
		Order.setRushable((orderDate, orderAmount) -> orderAmount > 1500);
		System.out.println("Anvil isPriorityOrder: " +
		anvil.isPriorityOrder()); // true
		System.out.println("Balloons isPriorityOrder: " +
		balloons.isPriorityOrder()); // false
		
		LocalDate ld = LocalDate.of(2017, Month.JANUARY, 03);
		p(ld);
		LocalDate now = LocalDate.now();
		p(now);
		LocalTime time = LocalTime.now();
		p(time);
		LocalDateTime ldt = LocalDateTime.now();
		p(ldt);
		Period pd = Period.between(now, ld);
		p(pd);
		
		
		MyDate hammerDate = new MyDate( 20, 06, 2020 );
		Solid hammerType = new Solid( "Acme Hammer", 281, 0.3,
		 UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3 );
		Order hammer = new Order( hammerDate, 10.00, "Wile E Coyote",
		 hammerType, 10 );

		 Order.setRushable( (orderDate, orderAmount) -> {
		 // Create a LocalDate object for now.
		 // Create a LocalDate object for the order date.
		 LocalDate orderDatePlus30 =
		LocalDate.of(orderDate.getYear(),
		 orderDate.getMonth(), orderDate.getDay());
		 // Add one month to the order date.
		 orderDatePlus30 = orderDatePlus30.plusMonths(1);
		 System.out.println("Hammer date:"+orderDatePlus30);
		 // If the current date is after the order date + one month,
		 // it's rushable.
		 return now.isAfter(orderDatePlus30);
		 } );
		 
		 System.out.println("Anvil isPriorityOrder: " +
		 anvil.isPriorityOrder()); // True
		 System.out.println("Hammer isPriorityOrder: " +
		 hammer.isPriorityOrder()); // False
		 
		 Map<String, MyDate> map = new HashMap<String, MyDate>();
		 MyDate birthday = new MyDate(27,8, 1988);
		 MyDate anniv = new MyDate(3,1,2017);
		 map.put("birthday", birthday);
		 map.put("anniversary", anniv);
		 MyDate bd = (MyDate)map.get("birthday");
		 System.out.println("Birthday:"+bd);
	}
	
	public static void p(Object o) {
		System.out.println(o);
	}

}
