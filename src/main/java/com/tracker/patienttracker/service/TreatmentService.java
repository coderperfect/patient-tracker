package com.tracker.patienttracker.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.TreatmentRepository;

@Service
public class TreatmentService {

	@Autowired
	private TreatmentRepository treatmentRepository;
	
	@Autowired
	private PatientRecordService patientRecordService;
	
	@Transactional
	public void updateTreatments(Set<Treatment> treatments) {
		
		
		List<Treatment> updatedTreatments = treatmentRepository.saveAll(treatments);
		
	}

	public void saveTreatment(Treatment treatment) {
	
		treatmentRepository.save(treatment);
		
	}
}
