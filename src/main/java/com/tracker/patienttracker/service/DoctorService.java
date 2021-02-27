package com.tracker.patienttracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.exception.DoctorNotFoundException;
import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	public Doctor getDoctor(int doctorId) {
		Optional<Doctor> optional = doctorRepository.findById(doctorId);
		 if(!optional.isPresent()) {
				throw new DoctorNotFoundException();
			}
		 Doctor doctor = optional.get();
		 return doctor;
	}
}
