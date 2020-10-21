/**
 * 
 */
package com.capgemini.cabinvoicegenerator;

import org.junit.Before;
import org.junit.Test;
import com.capgemini.cabinvoicegenerator.Ride.Rides;

import junit.framework.Assert;

/**
 * @author Mohana Kavya
 *
 */
public class InvoiceGeneratorTest {
	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}
	//uc1
	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.5;
		int time = 10;
		double fare = invoiceGenerator.calculateFare(distance, time, Rides.NORMAL);
		Assert.assertEquals(35, fare, 0.0);
	}

	// uc1
	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time, Rides.NORMAL);
		Assert.assertEquals(5, fare, 0.0);
	}
	// uc2
	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		int userId = 123;
		Ride[] rides = { new Ride(2.0, 5, Rides.NORMAL), new Ride(0.1, 1, Rides.PREMIUM) };
		InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator(userId, rides);
		InvoiceSummary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(userId);
		InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary.toString(), actualInvoiceSummary.toString());
	}
}

