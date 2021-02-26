package com.tracker.patienttracker.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.PatientRepository;

@Service
public class PatientRecordService {

	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	public Set<Prescription> prescriptions(int patientId) {
		
		Patient patient = patientRepository.findById(patientId).get();
		//getpatientRecord
		Optional<PatientRecord> optional = patientRecordRepository.findByPatient(patient);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getPrescriptions();
	}
}
