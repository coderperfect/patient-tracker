package com.tracker.patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRepository;
	
	public Patient getPatientDetails(int patientId)
	{
		return patientRepository.findById(patientId).get();
	}
}
