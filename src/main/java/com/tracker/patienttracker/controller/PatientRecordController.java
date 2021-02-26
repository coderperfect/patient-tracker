package com.tracker.patienttracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.service.PatientRecordService;

@RestController
@RequestMapping("/patientrecord")
public class PatientRecordController {

	@Autowired
	private PatientRecordService patientRecordService;
	
	@GetMapping("/prescriptions/{patientId}")
	public ResponseEntity<Set<Prescription>> getPrescriptions(@PathVariable int patientId) {
		Set<Prescription> prescriptions = patientRecordService.prescriptions(patientId);
		return ResponseEntity.ok(prescriptions);
	}
}
