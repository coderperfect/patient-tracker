package com.tracker.patienttracker.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.PatientRecordRepository;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.TreatmentRepository;

@Service
public class TreatmentService {
	@Autowired
	TreatmentRepository treatmentRepository;
  
  @Autowired
	private PatientRecordService patientRecordService;
	
	@Transactional
	public void updateTreatments(Set<Treatment> treatments) {
		List<Treatment> updatedTreatments = treatmentRepository.saveAll(treatments);
	}

	public Treatment getTreatmentDetails( int treatmentId)
	{   
		return treatmentRepository.findById(treatmentId).get();
	}
	
  @Autowired
	PatientRecordRepository  patientRecordRepository ;  //To add method in patientRecordService and use it here instead of repo directly
  
	public Set<Treatment> getTreatmentHistory(int patientId) //can be used as diet list also
	{
		return patientRecordRepository.findById(patientId).get().getTreatments();
	}
	
	public String getDietDetails(int treatmentId)
	{
		return treatmentRepository.getDietDetails(treatmentId);
	}

	public void saveTreatment(Treatment treatment) {
	
		treatmentRepository.save(treatment);
		
	}
}
