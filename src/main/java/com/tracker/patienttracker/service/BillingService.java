package com.tracker.patienttracker.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Consultation;
import com.tracker.patienttracker.model.InPatientRecord;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
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
	
	@Autowired
	PrescriptionService prescriptionService;
	
	@Autowired
	ConsultationService consultationService;
	
	@Autowired
	InPatientRecordService inPatientRecordService;
	
	@Autowired
	TestReportService testReportService;
	
	public Billing createEmptyBillByPatientId(int patientId) {
		Billing billing = new Billing();
		
		Patient patient = patientService.getPatient(patientId);
		
		billing.setPatient(patient);
		
		return billing;
	}
	
	public Billing saveBilling(Billing billing) {
		return billingRepository.save(billing);
	}
	
	public Set<Prescription> getAllPrescriptionsForPatientForBilling(int patientId) throws Exception {
		return prescriptionService.getAllPrescriptionsForPatientForBilling(patientId);
	}
	
	public List<Consultation> getConsultationsPendingBillingByPatientId(int patientId) {
		return consultationService.getConsultationsPendingBillingByPatientId(patientId);
	}
	
	public List<InPatientRecord> getInPatientRecordByPatientId(int patientId) {
		return inPatientRecordService.getInPatientRecordByPatientId(patientId);
	}
	
	public List<TestReport> getPendingBillingTestReportsByPatientId(int patientId) {
		return testReportService.getPendingBillingTestReportsByPatientId(patientId);
	}
}
