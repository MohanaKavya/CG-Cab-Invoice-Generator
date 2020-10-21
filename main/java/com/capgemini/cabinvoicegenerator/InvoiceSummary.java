/**
 * 
 */
package com.capgemini.cabinvoicegenerator;

/**
 * @author Mohana Kavya
 *
 */
public class InvoiceSummary {
	public int noOfRides;
	public double totalFare;
	public double averageFare;

	
	/**
	 * @param length
	 * @param totalFare
	 */
	public InvoiceSummary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = (this.totalFare) / (this.noOfRides);
	}
	@Override
	public String toString() {
		return "Total Number of Rides : "+noOfRides+", Total Fare : "+totalFare+", Average Fare per Ride : "+averageFare;
	}

}
