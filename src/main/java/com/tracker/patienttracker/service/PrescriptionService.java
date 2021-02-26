package com.tracker.patienttracker.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.PrescriptionRepository;
import com.tracker.patienttracker.repository.TreatmentRepository;

@Service
public class PrescriptionService {

	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Transactional
	public void updatePrescriptions(Set<Prescription> prescriptions) {
		
		List<Prescription> updatedPrescriptions = prescriptionRepository.saveAll(prescriptions);
		
	}
}
