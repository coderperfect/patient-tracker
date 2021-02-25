package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.TestReport;

@Repository
public interface TestReportRepository extends JpaRepository<TestReport, Integer> {

}
