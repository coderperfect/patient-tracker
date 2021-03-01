package com.tracker.patienttracker.controller;

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
}
