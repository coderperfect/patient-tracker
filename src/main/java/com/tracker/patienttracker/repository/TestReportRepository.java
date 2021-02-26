package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Test;
import com.tracker.patienttracker.model.TestReport;

@Repository
public interface TestReportRepository extends JpaRepository<TestReport, Integer> {

	
	@Modifying
	@Query(value="update TestReport m set m.doctor=:doctor,m.patient=:patient,m.patientRecord=:patientRecord,m.test=:test,m.testResult=:testResult where m.testReportId=:testReportId")
	public TestReport modifyTestReport(@Param(value = "doctor") Doctor doctor,@Param(value = "patient") Patient patient,@Param(value = "patientRecord") PatientRecord patientRecord,@Param(value = "test") Test test,
			@Param(value = "testResult") String testResult,@Param(value = "testReportId")	int testReportId);

}
