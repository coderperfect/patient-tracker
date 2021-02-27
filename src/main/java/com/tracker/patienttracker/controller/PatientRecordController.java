package com.tracker.patienttracker.controller;

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

import com.tracker.patienttracker.dto.PatientRecordDTO;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.service.PatientRecordService;

@RestController
@CrossOrigin
@RequestMapping("/patientrecord")
public class PatientRecordController {

	@Autowired
	private PatientRecordService patientRecordService;
	
	@GetMapping("/prescriptions/{recordId}/{doctorId}")
	public ResponseEntity<Set<Prescription>> getPrescriptions(@PathVariable int recordId, @PathVariable int doctorId) {
		Set<Prescription> prescriptions = patientRecordService.prescriptions(recordId, doctorId);
		return ResponseEntity.ok(prescriptions);
	}
	
	@GetMapping("/testreports/{recordId}/{doctorId}")
	public ResponseEntity<Set<TestReport>> getTestReports(@PathVariable int recordId, @PathVariable int doctorId) {
		Set<TestReport> testreports = patientRecordService.testReports(recordId, doctorId);
		return ResponseEntity.ok(testreports);
	}
	
	@GetMapping("/treatments/{patientId}/{doctorId}")
	public ResponseEntity<Set<Treatment>> getTreatments(@PathVariable int patientId, @PathVariable int doctorId) {
		Set<Treatment> treatments = patientRecordService.treatments(patientId, doctorId);
		return ResponseEntity.ok(treatments);
	}
	
	@PostMapping("/addprescription")
	public ResponseEntity<String> addPrescription(@RequestBody PatientRecordDTO dto) {
		
		String response= patientRecordService.addPrescription(dto);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/addtreatment")
	public ResponseEntity<String> addTreatment(@RequestBody PatientRecordDTO dto) {
		
		String response= patientRecordService.addTreatment(dto);
		return ResponseEntity.ok(response);
	}
}
