package com.tracker.patienttracker.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.repository.PrescriptionRepository;

@Service
public class PrescriptionService {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private PatientRecordService patientRecordService;
	
//	@Autowired
//	private UserService userService;
	
	@Transactional
	public Set<Prescription> getAllPrescriptionsForPatientForBilling(int patientId, String token) throws Exception{
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		 
		Set<Prescription> prescriptions = patientRecordService.prescriptions(patientId);
		return prescriptions;
	}
	
	@Transactional
	public Prescription addPrescription(Prescription prescription, String token) {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		return prescriptionRepository.save(prescription);
	}
	
	@Transactional
	public Prescription updatePrescription(Prescription prescription, String token) {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		return prescriptionRepository.save(prescription);
	}

}
