/**
 * 
 */
package com.capgemini.cabinvoicegenerator;

/**
 * @author Mohana Kavya
 *
 */
public class Ride {
	enum Rides {
		PREMIUM, NORMAL
	}
	public double distance;
	public int time;
	public Rides type;

	public Ride(double distance, int time, Rides type) {
		this.distance = distance;
		this.time = time;
		this.type = type;
	}
}
