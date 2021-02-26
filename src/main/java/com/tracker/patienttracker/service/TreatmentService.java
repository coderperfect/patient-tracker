package com.tracker.patienttracker.service;


import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.TreatmentRepository;

@Service
public class TreatmentService {
	@Autowired
	TreatmentRepository treatmentRepository;
	@Autowired
	PatientRecordRepository  patientRecordRepository ;

	public Treatment getTreatmentDetails( int treatmentId)
	{   
		return treatmentRepository.findById(treatmentId).get();
	}
	
	public Set<Treatment> getTreatmentHistory(int patientId) //can be used as diet list also
	{
		return patientRecordRepository.findById(patientId).get().getTreatments();
	}
	
	public String getDietDetails(int treatmentId)
	{
		return treatmentRepository.getDietDetails(treatmentId);
	}
	
}
