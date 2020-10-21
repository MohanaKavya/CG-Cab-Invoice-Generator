/**
 * 
 */
package com.capgemini.cabinvoicegenerator;

import java.util.logging.Logger;

/**
 * @author Mohana Kavya
 *
 */
public class InvoiceGenerator {	
		// Constants
		private static final double MINIMUM_COST_PER_KM = 10.0;
		private static final int COST_PER_TIME = 1;
		private static final double MINIMUM_FARE = 5.0;
		
		/**
		 * @param distance
		 * @param time
		 * @return fare
		 */
		// Method to Calculate Total Fare
		public double calculateFare(double distance, int time) {
			double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
			return Math.max(totalFare, MINIMUM_FARE);
		}		
		
		public static void main(String[] args) {
		Logger log = Logger.getLogger(InvoiceGenerator.class.getName());
		log.info("Welcome to the Cab Invoice Generator System.");
	}

	
}
