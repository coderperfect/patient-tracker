package com.tracker.patienttracker.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Consultation;
import com.tracker.patienttracker.model.InPatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.service.BillingService;

@RestController
@RequestMapping("/billing")
@CrossOrigin
public class BillingController {
	@Autowired
	BillingService billingService;
	
	@GetMapping("/{patientId}")
	public ResponseEntity<Billing> createEmptyBillByPatientId(@PathVariable("patientId") int patientId) {
		return ResponseEntity.ok(billingService.createEmptyBillByPatientId(patientId));
	}
	
	@PostMapping
	public ResponseEntity<Billing> saveBilling(@RequestBody Billing billing) {
		return ResponseEntity.ok(billingService.saveBilling(billing));
	}
	
	@GetMapping("/prescription/{patientId}")
	public ResponseEntity<Set<Prescription>> getAllPrescriptionsForPatientForBilling(int patientId) throws Exception {
		return ResponseEntity.ok(billingService.getAllPrescriptionsForPatientForBilling(patientId));
	}
	
	@GetMapping("/consultation/{patientId}")
	public ResponseEntity<List<Consultation>> getConsultationsPendingBillingByPatientId(int patientId) {
		return ResponseEntity.ok(billingService.getConsultationsPendingBillingByPatientId(patientId));
	}
	
	@GetMapping("/inpatientrecord/{patientId}")
	public ResponseEntity<List<InPatientRecord>> getInPatientRecordByPatientId(int patientId) {
		return ResponseEntity.ok(billingService.getInPatientRecordByPatientId(patientId));
	}
	
	@GetMapping("/testreport/{patientId}")
	public ResponseEntity<List<TestReport>> getPendingBillingTestReportsByPatientId(int patientId) {
		return ResponseEntity.ok(billingService.getPendingBillingTestReportsByPatientId(patientId));
	}
}