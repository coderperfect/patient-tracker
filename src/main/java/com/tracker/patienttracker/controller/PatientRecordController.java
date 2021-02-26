package com.tracker.patienttracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.service.PatientRecordService;

@RestController
@RequestMapping("/patientrecord")
public class PatientRecordController {

	@Autowired
	private PatientRecordService patientRecordService;
	
	@GetMapping("/prescriptions/{patientId}/{doctorId}")
	public ResponseEntity<Set<Prescription>> getPrescriptions(@PathVariable int patientId, @PathVariable int doctorId) {
		Set<Prescription> prescriptions = patientRecordService.prescriptions(patientId, doctorId);
		return ResponseEntity.ok(prescriptions);
	}
	
	@GetMapping("/testreports/{patientId}")
	public ResponseEntity<Set<TestReport>> getTestReports(@PathVariable int patientId, @PathVariable int doctorId) {
		Set<TestReport> testreports = patientRecordService.testReports(patientId, doctorId);
		return ResponseEntity.ok(testreports);
	}
	
	@GetMapping("/treatments/{patientId}/{doctorId}")
	public ResponseEntity<Set<Treatment>> getTreatments(@PathVariable int patientId, @PathVariable int doctorId) {
		Set<Treatment> treatments = patientRecordService.treatments(patientId, doctorId);
		return ResponseEntity.ok(treatments);
	}
}
