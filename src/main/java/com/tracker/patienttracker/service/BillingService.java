package com.tracker.patienttracker.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Consultation;
import com.tracker.patienttracker.model.InPatientRecord;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.User;
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
	UserService userService;
	
	@Autowired
	TestReportService testReportService;
	
	public Billing createEmptyBillByPatientId(int patientId) {
		Billing billing = new Billing();
		
		Patient patient = patientService.getPatient(patientId);
		
		billing.setPatient(patient);
		
		return billing;
	}
	
	public Billing saveBilling(Billing billing) {
		Patient patient = patientService.getPatient(22);
		billing.setPatient(patient);
		billing.setTimestamp(LocalDateTime.now());
		billing.setDueDate(LocalDateTime.now());
		User user = userService.getUserByUserId(100);
		billing.setUser(user);
		
		return billingRepository.save(billing);
	}
	
	public List<Prescription> getAllPrescriptionsForPatientForBilling(int patientId) throws Exception {
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
