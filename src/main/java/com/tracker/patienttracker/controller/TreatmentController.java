package com.tracker.patienttracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.service.TreatmentService;
@CrossOrigin
@RestController
@RequestMapping("/treatment")
public class TreatmentController {
	@Autowired
	TreatmentService treatmentService;
	
	@GetMapping("/details/{treatmentId}")
	public Treatment getTreatmentDetails(@PathVariable int treatmentId)
	{
		return treatmentService.getTreatmentDetails(treatmentId);
	}
	@GetMapping("/history/{patientId}")
	public  Set<Treatment> getTreatmentHistory(@PathVariable int patientId)
	{
		return treatmentService.getTreatmentHistory(patientId);
	}
	@GetMapping("/diet/{treatmentId}")
	public String getDietDetails(@PathVariable int treatmentId)
	{
		return treatmentService.getDietDetails(treatmentId);
	}
}
