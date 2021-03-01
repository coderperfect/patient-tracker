package com.tracker.patienttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.repository.BillingRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingService {
	@Autowired
	BillingRepository billingRepository;
	
	@Autowired
	PatientService patientService;
	
	public Billing createEmptyBillByPatientId(int patientId) {
		Billing billing = new Billing();
		
		Patient patient = patientService.getPatient(patientId);
		
		billing.setPatient(patient);
		
		return billing;
	}
	
	public Billing saveBilling(Billing billing) {
		return billingRepository.save(billing);
	}
}
