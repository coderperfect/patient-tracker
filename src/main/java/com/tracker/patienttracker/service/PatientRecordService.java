package com.tracker.patienttracker.service;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

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
		if(optional.isEmpty()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getPrescriptions();
	}
	
	@Transactional
	public PatientRecord addPatientRecord(PatientRecord patientRecord, String token) {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		return patientRecordRepository.save(patientRecord);
	}
	
	@Transactional
	public PatientRecord updatePatientRecord(PatientRecord patientRecord, String token) {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		return patientRecordRepository.save(patientRecord);
	}
}
