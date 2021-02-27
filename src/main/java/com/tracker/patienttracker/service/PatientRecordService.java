package com.tracker.patienttracker.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.model.Doctor;
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
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Transactional
	public Set<Prescription> prescriptions(int patientId) {
		
		Patient patient = patientService.getPatient(patientId);
		//getpatientRecord
		Optional<PatientRecord> optional = patientRecordRepository.findByPatient(patient);
		if(optional.isEmpty()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getPrescriptions();
	}
	
	@Transactional
	public Set<Patient> getAllPatientsForDoctor(int doctorId){
		Set<Integer> patientids =  patientRecordRepository.findPatientByDoctor(doctorId);
		Set<Patient> patients = new HashSet<Patient>();
		for(Integer i : patientids) {
			patients.add(patientService.getPatient(i));
		}
		return patients;
	}
	
	@Transactional
	public PatientRecord getPatientRecordForPatientId(int patientId) {
		Patient patient = patientService.getPatient(patientId);
		Optional<PatientRecord> optionalPatientRecord = patientRecordRepository.findByPatient(patient);
		if(optionalPatientRecord.isEmpty()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord = optionalPatientRecord.get();
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
