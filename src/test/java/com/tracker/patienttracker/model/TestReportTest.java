package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import com.tracker.patienttracker.model.TestReport;

public class TestReportTest {
	
	@Test
	void getTestResultIdTest()
	{
		TestReport testReport=new TestReport();
		testReport.setTestResultId(1);
		assertEquals(testReport.getTestResultId(),1);
	}
	@Test
	void getTestIdTest()
	{
		TestReport testReport=new TestReport();
		testReport.setTestId(1);
		assertEquals(testReport.getTestId(),1);
	}
	@Test
	void getPatientIdTest()
	{
		TestReport testReport=new TestReport();
		testReport.setPatientId(1);
		assertEquals(testReport.getPatientId(),1);
	}
	
	@Test
	void getTestResultTest()
	{
		TestReport testReport=new TestReport();
		testReport.setTestResult("Done");
		assertEquals(testReport.getTestResult(),"Done");
	}

	@Test
	void getDoctorIdTest()
	{
		TestReport testReport=new TestReport();
		testReport.setDoctorId(1);
		assertEquals(testReport.getDoctorId(),1);
	}
	@Test
	void getRequestedTest()
	{
		TestReport testReport=new TestReport();
		testReport.setRequested(false);
		assertEquals(testReport.isRequested(),false);
	}
	@Test
	void getPaidTest()
	{
		TestReport testReport=new TestReport();
		testReport.setPaid(true);
		assertEquals(testReport.isPaid(),true);
	}
	@Test
	void constructorTest()
	{
		TestReport testReport1=new TestReport(1, 0, 0, "Done", 0, true, false);
		TestReport testReport2=new TestReport(1, 0, 0, "Done", 0, true, false);
		assertEquals(testReport1.toString(),testReport2.toString());
	}
}
