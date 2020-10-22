package com.bridgelabz.cabinvoicegenerator;

/**
 * Generates invoice for cab ride
 * @author Shubham
 *
 */
public class InvoiceGenerator {

	public static Double totalFare(double distance, double time) {
		final double fare = 10*distance + time;
		if(fare < 5)
			return 5.0;
		else
			return fare;
	}
	
}
