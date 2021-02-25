package com.tracker.patienttracker.service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.PatientRecord;
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
	
	public Set<Treatment> getTreatmentHistory(int patientId)
	{
		return patientRecordRepository.findById(patientId).get().getTreatments();
	}
}
