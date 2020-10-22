package com.bridgelabz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates invoice for cab ride
 * 
 * @author Shubham
 *
 */
public class InvoiceGenerator {

	private static Map<String, List<Ride>> userRides;

	/**
	 * 
	 */
	public InvoiceGenerator() {
		userRides = new HashMap<>();
	}

	/**
	 * @return the fare for a single ride
	 */
	public static Double totalFare(double distance, double time,int rideType) {
		double fare;
		if(rideType == 0) {
			 fare = 10*distance + time;
			if(fare < 5)
				return 5.0;
		}
		else {
			fare = 15*distance + 2*time;
			if(fare < 20)
				return 20.0;
		}
		return fare;
	}

	/**
	 * @return the userRides
	 */
	public static Map<String, List<Ride>> getUserRides() {
		return userRides;
	}

	/**
	 * @param userRides the userRides to set
	 */
	public static void setUserRides(Map<String, List<Ride>> userRides) {
		userRides = userRides;
	}

	/**
	 * @param listOfRides the rides for which aggregate is to be calculated @return,
	 *                    returns the aggregate of fares
	 */
	public static Double aggragateFare(List<Ride> listOfRides,int rideType) {
		double aggragateFare = 0;
		for (Ride ride : listOfRides) {
			double fare = totalFare(ride.getDistance(), ride.getTime(),rideType);
			ride.setFare(fare);
			aggragateFare += fare;
		}
		return aggragateFare;
	}

	/**
	 * @param listOfRides the rides for which aggregate is to be calculated
	 * @return returns the invoice object which has aggregate fare, average fare and
	 *         total no of rides.
	 */
	public static Invoice getInvoice(List<Ride> listOfRides, int rideType) {
		double aggragate = aggragateFare(listOfRides,rideType);
		double avg = aggragate / listOfRides.size();
		Invoice invoice = new Invoice(listOfRides.size(), aggragate, avg);
		return invoice;
	}

	/**
	 * @param key the UserID
	 * @return returns the invoice of rides for the UserID
	 */
	public static Invoice getInvoice(String key,int rideType) {
		List<Ride> listOfRides = userRides.get(key);
		return getInvoice(listOfRides,rideType);
	}
}
