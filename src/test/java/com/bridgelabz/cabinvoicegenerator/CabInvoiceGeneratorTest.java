package com.bridgelabz.cabinvoicegenerator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class CabInvoiceGeneratorTest 
{
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
}
