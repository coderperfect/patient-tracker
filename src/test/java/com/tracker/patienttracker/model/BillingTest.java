package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.jupiter.api.Test;

import com.tracker.patienttracker.model.Billing;

public class BillingTest {

	@Test
	void getBillingIdTest()
	{
		Billing billing=new Billing();
		billing.setBillingId(1);
		assertEquals(billing.getBillingId(),1);
	}
	@Test
	void getPatientIdTest()
	{
		Billing billing=new Billing();
		billing.setPatientId(1);
		assertEquals(billing.getPatientId(),1);
	}
	@Test
	void getTestResultTest()
	{
		Billing billing=new Billing();
		billing.setTestResult("Pass");
		assertEquals(billing.getTestResult(),"Pass");
	}
	@Test
	void getDoctorIdTest()
	{
		Billing billing=new Billing();
		billing.setDoctorId(1);
		assertEquals(billing.getDoctorId(),1);
	}
	@Test
	void getRequestedTest()
	{
		Billing billing=new Billing();
		billing.setRequested(false);
		assertEquals(billing.isRequested(),false);
	}
	@Test
	void getPaidTest()
	{
		Billing billing=new Billing();
		billing.setPaid(true);
		assertEquals(billing.isPaid(),true);
	}
	@Test
	void constructorTest()
	{
		Billing billing1=new Billing(1, 0, "Done", 0, true, false);
		Billing billing2=new Billing(1, 0, "Done", 0, true, false);
		assertEquals(billing1.toString(),billing2.toString());
		
		
	}
}
