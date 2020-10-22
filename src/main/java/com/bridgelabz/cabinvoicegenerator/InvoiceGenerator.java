package com.bridgelabz.cabinvoicegenerator;

import java.util.List;

/**
 * Generates invoice for cab ride
 * @author Shubham
 *
 */
public class InvoiceGenerator {

	/**
	 * @return the fare for a single ride
	 */
	public static Double totalFare(double distance, double time) {
		final double fare = 10*distance + time;
		if(fare < 5)
			return 5.0;
		else
			return fare;
	}

	/**
	 * @param listOfRides the rides for which aggregate is to be calculated
	 * @return, returns the aggregate of fares
	 */
	public static Double aggragateFare(List<Ride> listOfRides) {
		double aggragateFare = 0;
		for(Ride ride: listOfRides) {
			double fare = totalFare(ride.getDistance(), ride.getTime());
			ride.setFare(fare);
			aggragateFare += fare;
		}
		return aggragateFare;
	}

	/**
	 * @param listOfRides the rides for which aggregate is to be calculated
	 * @return returns the invoice object which has aggregate fare, average fare and total no of rides.
	 */
	public static Invoice getInvoice(List<Ride> listOfRides) {
		double aggragate = aggragateFare(listOfRides);
		double avg = aggragate/listOfRides.size();
		Invoice invoice = new Invoice(listOfRides.size(),aggragate,avg);
		return invoice;
	}
	
}
