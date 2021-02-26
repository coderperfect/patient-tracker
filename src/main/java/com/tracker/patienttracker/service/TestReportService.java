package com.tracker.patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Test;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.repository.TestReportRepository;
import com.tracker.patienttracker.repository.TestRepository;

@Service
public class TestReportService {
	@Autowired
	TestReportRepository testReportRepository;
	
	public TestReport modifyTestReport(int testReportId, String testResult)
	{
		TestReport t=testReportRepository.findById(testReportId).get();
		t.setTestResult(testResult);
		return testReportRepository.save(t);
	}
	
}
