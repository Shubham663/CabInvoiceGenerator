package com.bridgelabz.cabinvoicegenerator;

public class Ride {
	private double distance;
	private double time;
	private double fare;
	/**
	 * @param distance, the distance travelled in km's
	 * @param time, the time taken in min's
	 */
	public Ride(double distance, double time) {
		this.distance = distance;
		this.time = time;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(double fare) {
		this.fare = fare;
	}
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
}
