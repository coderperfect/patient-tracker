package com.tracker.patienttracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.Test;
import com.tracker.patienttracker.service.TestService;

@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {

	@Autowired
	TestService testService;
	
	@GetMapping("/details/{patientId}")
	public Set<Test> getTestList(@PathVariable int patientId)
	{
		return testService.getTestList(patientId);
	}
}
