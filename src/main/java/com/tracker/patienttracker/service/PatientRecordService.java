package com.tracker.patienttracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.repository.PatientRecordRepository;

@Service
public class PatientRecordService {
	
	@Autowired
	PatientRecordRepository patientRecordRepository;
	
//	@Autowired
//	UserService userService;
	
	@Transactional
	public PatientRecord getPatientRecordByPatientId(int patientId, String token) throws Exception {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		PatientRecord patientRecord = patientRecordRepository.findByPatientId(patientId);
		if(patientRecord == null)
			throw new Exception("Patient not found");
		return patientRecord;
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
