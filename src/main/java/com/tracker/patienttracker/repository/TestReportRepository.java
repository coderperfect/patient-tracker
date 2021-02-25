package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.TestReport;

@Repository
public interface TestReportRepository extends JpaRepository<TestReport, Integer> {
	// Update Test Results Home Page
	//Select * From test_report where testResult = null;
	@Query(value = "Select t From TestReport t where t.testResult = null")
	public TestReport getPendingUpdateTestReports(); // Test pending
	
	// List of In Patients
	//Select 
}
