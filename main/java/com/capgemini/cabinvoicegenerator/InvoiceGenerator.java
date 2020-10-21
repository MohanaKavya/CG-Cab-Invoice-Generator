/**
 * 
 */
package com.capgemini.cabinvoicegenerator;

import java.util.logging.Logger;

import com.capgemini.cabinvoicegenerator.Ride.Rides;

/**
 * @author Mohana Kavya
 *
 */
public class InvoiceGenerator {	
	
		// Constants
		private static final double MINIMUM_COST_PER_KM_NORMAL_RIDE = 10.0;
		private static final int COST_PER_TIME_NORMAL_RIDE = 1;
		private static final double MINIMUM_FARE_NORMAL_RIDE = 5.0;
		private static final double MINIMUM_COST_PER_KM_PREMIUM_RIDE = 15.0;
		private static final int COST_PER_TIME_PREMIUM_RIDE = 2;
		private static final double MINIMUM_FARE_PREMIUM_RIDE = 20.0;
		private RideRepository USER_RIDES;

		public InvoiceGenerator() {
			this.USER_RIDES = null;
		}

		public InvoiceGenerator(int userId, Ride[] rides) {
			USER_RIDES = new RideRepository(userId, rides);
		}
		
		/**
		 * @param distance
		 * @param time
		 * @return fare
		 */
		// Method to Calculate Total Fare
		public double calculateFare(double distance, int time, Rides type) {
			if (type == Rides.NORMAL) {
				double totalFare = distance * MINIMUM_COST_PER_KM_NORMAL_RIDE + time * COST_PER_TIME_NORMAL_RIDE;
				return Math.max(totalFare, MINIMUM_FARE_NORMAL_RIDE);
			}
			else if (type == Rides.PREMIUM) {
				double totalFare = distance * MINIMUM_COST_PER_KM_PREMIUM_RIDE + time * COST_PER_TIME_PREMIUM_RIDE;
				return Math.max(totalFare, MINIMUM_FARE_PREMIUM_RIDE);
			} 
			else
				return 0;
		}		

		/**
		 * @param rides
		 * @return Invoice Summary
		 */
		// Method to Calculate Total Fare for Multiple Rides and Return Invoice Summary
		public InvoiceSummary calculateFare(int userId) {
			Ride[] rides = USER_RIDES.getRides(userId);
			double totalFare = 0.0;
			for (Ride ride : rides) {
				totalFare += this.calculateFare(ride.distance, ride.time, ride.type);
			}
			return new InvoiceSummary(rides.length, totalFare);
		}
		
		public static void main(String[] args) {
		Logger log = Logger.getLogger(InvoiceGenerator.class.getName());
		log.info("Welcome to the Cab Invoice Generator System.");
	}

}

	

