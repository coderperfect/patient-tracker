package com.tracker.patienttracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.service.TestReportService;

@RestController
@RequestMapping("/testreport")
public class TestReportController {
	@Autowired
	TestReportService testReportService;
	
	@GetMapping
	public ResponseEntity<List<TestReport>> getPendingUpdateTestReports() {
		return ResponseEntity.ok(testReportService.getPendingUpdateTestReports());
	}
	
	@PutMapping("/{testResultId}")
	public ResponseEntity<String> updateTestResult(@PathVariable("testResultId") int testResultId, @RequestBody String testResult) {
		System.out.println("Hey");
		TestReport testReport =  testReportService.modifyTestReport(testResultId, testResult);
		
		String responseString = null;
		
		if(testReport.getTestResult().equals(testResult))
			responseString = "Updated";
		else
			responseString = "Failed";
		
		return ResponseEntity.ok(responseString);
	}
	
	
}
