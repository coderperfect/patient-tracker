package com.tracker.patienttracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {

	Optional<PatientRecord> findByPatient(Patient patient);

}
