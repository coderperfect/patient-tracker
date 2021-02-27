package com.tracker.patienttracker.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.repository.TestReportRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestReportService {
	@Autowired
	TestReportRepository testReportRepository;
	
	public List<TestReport> getPendingUpdateTestReports(){
		return testReportRepository.getPendingUpdateTestReports();
	}
	
	public TestReport modifyTestReport(int testReportId, String testResult)
	{
		TestReport testReport=testReportRepository.findById(testReportId).get();
		testReport.setTestResult(testResult);
		return testReportRepository.save(testReport);
	}
}
