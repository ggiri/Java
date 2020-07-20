package com.acme.domain;

import com.acme.utils.HolidayOrdersNotAllowedException;
import com.acme.utils.MyDate;

/**
 * 
 * @author Giridhar
 *
 */
public class Order {
	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private static Rushable rushable;


	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) throws HolidayOrdersNotAllowedException{
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!");
			throw new HolidayOrdersNotAllowedException(orderDate);
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (orderAmount > 0) {
			this.orderAmount = orderAmount;
		} else {
			System.out.println("Please choose a positive orderamount");
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Good product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity > 0) {
			this.quantity = quantity;
		} else {
			System.out.printf("Please choose a positive quantity '%d'",quantity);
		}
	}

	private int quantity;
	public static double taxRate;

	public enum sizes {
		S, M, L, X
	}

	/**
	 * 
	 */
	static {
		taxRate = 0.05;
	}

	/**
	 * 
	 * @param d   Date
	 * @param amt Amount
	 * @param c   Name of customer
	 * @param p   Product Name
	 * @param q   Quantity
	 */
	public Order(MyDate d, double amt, String c, Product p, int q) {
		try {
			 setOrderDate(d);
		} catch (HolidayOrdersNotAllowedException e){
			System.out.println("The order date for an order cannot be a holiday! Application closing.");
			System.exit(0);
//			Note: Calling System.exit(0) is rarely an appropriate way to handle an exception.
//			Handling an exception usually requires the exception to be logged, informing the user
//			of the issue, and then seeking appropriate action from the user (in this case perhaps
//			picking a new order date).
		}
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}

	

	public String toString() {
		return quantity + " ea. " + product + " for " + customer;
	}

	public static void setTaxRate(double newRate) {
		taxRate = newRate;
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}

	/**
	 * 
	 * will compute tax and return a double value.
	 * 
	 * @return Tax
	 */
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	public char jobSize() {
		if (quantity <= 25) {
			return 'S';
		} else if (quantity <= 75) {
			return 'M';
		} else if (quantity <= 150) {
			return 'L';
		}
		return 'X';
	}

	public double computeTotal() {
		double total = orderAmount;
		switch (jobSize()) {
		case 'M':
			total = total - (orderAmount * 0.01);
			break;
		case 'L':
			total = total - (orderAmount * 0.02);
			break;
		case 'X':
			total = total - (orderAmount * 0.03);
			break;
		}

		if (orderAmount <= 1500) {
			total = total + computeTax();
		}
		return total;
	}

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}
	
	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}
	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if( holiday.equals(proposedDate) ) {
				result = true;
			}
		}
		return result;
	}


}
