package com.tracker.patienttracker.repository;

import java.util.Optional;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;

@Repository
public interface PatientRecordRepository extends JpaRepository<PatientRecord, Integer> {

	Optional<PatientRecord> findByPatient(Patient patient);
	
	@Query(value = "select patientId from patientrecord where doctorId = ?1", nativeQuery = true)
	Set<Integer> findPatientByDoctor(int doctorId);

}
