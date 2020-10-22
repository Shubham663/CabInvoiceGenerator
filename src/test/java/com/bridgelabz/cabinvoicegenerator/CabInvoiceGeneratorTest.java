package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceGeneratorTest 
{
	List<Ride> listOfRides;
	Invoice invoice;
	InvoiceGenerator invoiceGenerator;
	@Before
	public void init() {
		listOfRides = new ArrayList<>();
    	listOfRides.add(new Ride(0.2,2));
    	listOfRides.add(new Ride(1,5));
    	List<Ride> listOfRides2 = new ArrayList<>();
    	listOfRides2.add(new Ride(2,10));
    	listOfRides2.add(new Ride(2, 5));
    	invoice = new Invoice(2, 20, 10);
    	invoiceGenerator = new InvoiceGenerator();
    	invoiceGenerator.getUserRides().put("User001", listOfRides);
    	invoiceGenerator.getUserRides().put("User002", listOfRides2);
    	
	}
	
    /**
     * Tests the whether total fare generation is correct.
     */
    @Test
    public void invoiceGeneratorTest_shouldReturnTotalFare(){
        assertEquals(new Double(15.0), InvoiceGenerator.totalFare(1,5));
    }
    /**
     * Tests whether total fare returned is minimal
     */
    @Test
    public void invoiceGeneratorTest_shouldReturnMinimalFare(){
        assertEquals(new Double(5.0), InvoiceGenerator.totalFare(0.2,2));
    }
    
    /**
     * Tests for aggregate of fares for rides.
     */
    @Test
    public void invoiceForMultipleRidesTest_shouldReturnAggregateFare(){
        assertEquals(new Double(20.0), InvoiceGenerator.aggragateFare(listOfRides));
    }
    
    /**
     * Tests for invoice of multiple rides.
     */
    @Test
    public void invoiceForMultipleRidesTest_shouldReturnInvoiceObject(){
        assertTrue(invoice.equals(InvoiceGenerator.getInvoice(listOfRides)));
    }
    
    /**
     * Tests for invoice of multiple rides, for a particular userID
     */
    @Test
    public void invoiceForUserIDTest_shouldReturnInvoiceObject(){
        assertTrue(invoice.equals(InvoiceGenerator.getInvoice("User001")));
    }
}
