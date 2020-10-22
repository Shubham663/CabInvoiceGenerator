package com.bridgelabz.cabinvoicegenerator;

public class Invoice {
	private int noOFRides;
	private double totalFare;
	private double avgFarePerRide;
	
	

	/**
	 * @return the noOFRides
	 */
	public int getNoOFRides() {
		return noOFRides;
	}

	/**
	 * @return the totalFare
	 */
	public double getTotalFare() {
		return totalFare;
	}

	/**
	 * @return the avgFarePerRide
	 */
	public double getAvgFarePerRide() {
		return avgFarePerRide;
	}

	/**
	 * @param noOFRides the no of rides for which aggregate is to be calculated
	 * @param totalFare the total fare for all the rides
	 * @param avgFarePerRide the average fare for the rides.
	 */
	public Invoice(int noOFRides, double totalFare, double avgFarePerRide) {
		this.noOFRides = noOFRides;
		this.totalFare = totalFare;
		this.avgFarePerRide = avgFarePerRide;
	}
	
	@Override
	public boolean equals(Object o) {
		Invoice invoice = (Invoice)o;
		if(noOFRides != invoice.getNoOFRides())
			return false;
		if(totalFare != invoice.getTotalFare())
			return false;
		if(avgFarePerRide != invoice.getAvgFarePerRide())
			return false;
		return true;
	}
}
