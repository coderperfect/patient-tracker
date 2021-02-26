package com.tracker.patienttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.dto.RegistrationData;
import com.tracker.patienttracker.service.RegistrationService;

@RestController
@CrossOrigin
//@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registration")
	public String registration(@RequestBody RegistrationData registrationData) {
		if(registrationData.getRole().equals("Doctor")) {
			//Check Validations here
		}
		return registrationService.registration(registrationData);
	}
}
