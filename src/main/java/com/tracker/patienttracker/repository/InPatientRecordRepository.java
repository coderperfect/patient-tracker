package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.InPatientRecord;

@Repository
public interface InPatientRecordRepository extends JpaRepository<InPatientRecord, Integer>{
 
}
