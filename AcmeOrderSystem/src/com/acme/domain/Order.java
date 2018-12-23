package com.acme.domain;
import com.acme.utils.MyDate;
/**
 * 
 * @author Giridhar
 *
 */
public class Order {
	MyDate orderDate;
	double orderAmount = 0.00;
	String customer;
	String product;
	int quantity;
	public static double taxRate;
	
	public enum sizes{
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
	 * @param d Date
	 * @param amt Amount
	 * @param c Name of customer
	 * @param p Product Name
	 * @param q Quantity
	 */
	public Order(MyDate d, double amt, String c, String p, int q) {
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}
	
	public Order(MyDate d, double amt, String c){
		 this(d,amt,c,"Anvil",1);
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
	 * @return Tax
	 */
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}
	
	public char jobSize() {
		if(quantity <=25) {
			return 'S';
		} else if(quantity <= 75) {
			return 'M';
		} else if(quantity <= 150) {
			return 'L';
		} 
		return 'X';
	}
	
	public double computeTotal() {
		double total = orderAmount;
		switch(jobSize()) {
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
		
		if( orderAmount <= 1500) {
			total = total + computeTax();
		}
		return total;
	}

}