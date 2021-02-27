package com.tracker.patienttracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import org.springframework.stereotype.Service;

import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.repository.PatientRepository;

@Service
@Configurable(preConstruction = true, autowire = Autowire.BY_NAME)  
public class PatientService {

	@Autowired
	private PatientRepository patientRepository;
	
	public Patient getPatient(int patientId) {
		 Optional<Patient> optional = patientRepository.findById(patientId);
		 if(!optional.isPresent()) {
				throw new PatientNotFoundException();
			}
		 Patient patient = optional.get();
		 return patient;
	}
}
