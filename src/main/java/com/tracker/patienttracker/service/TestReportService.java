package com.tracker.patienttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.repository.TestReportRepository;

public class TestReportService {
	@Autowired
	TestReportRepository testReportRepository;
	
	public List<TestReport> getPendingUpdateTestReports(int patientId){
		return testReportRepository.getPendingUpdateTestReports();
	}
	
	public TestReport modifyTestReport(int testReportId, String testResult)
	{
		TestReport testReport=testReportRepository.findById(testReportId).get();
		testReport.setTestResult(testResult);
		return testReportRepository.save(testReport);
	}
}
