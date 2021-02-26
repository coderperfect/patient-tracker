package com.tracker.patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.repository.TestReportRepository;

@Service
public class TestReportService {
	@Autowired
	TestReportRepository testReportRepository;
	public TestReport modifyTestReport(TestReport testReport,int testReportId)
	{
		return testReportRepository.modifyTestReport(testReport.getDoctor(),testReport.getPatient(),testReport.getPatientRecord(),testReport.getTest(),testReport.getTestResult(),testReportId
				);
	}
}
