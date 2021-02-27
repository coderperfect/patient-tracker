package com.tracker.patienttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.dto.IdPasswordRole;
import com.tracker.patienttracker.dto.RegistrationData;
import com.tracker.patienttracker.exception.RegistrationFailedException;
import com.tracker.patienttracker.exception.UserNotFoundException;
import com.tracker.patienttracker.service.LoginService;
import com.tracker.patienttracker.service.RegistrationService;

@RestController
@CrossOrigin
//@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	LoginService loginService;

	@PostMapping("/registration")
	public String registration(@RequestBody RegistrationData registrationData) {
		String temp=registrationService.registration(registrationData);
		System.out.println(temp);
		if(!temp.contains("Thanks For Registiring"))
			throw new RegistrationFailedException();
		return temp;
	}
	
	@PostMapping("/login")
	public String loginCheck(@RequestBody IdPasswordRole obj) {
		int userId=obj.getUserId();
		String password=obj.getPassword();
		String role=obj.getRole();		
		String messg=loginService.loginCheck(userId, password,role);
		if(!messg.equals("null")) 
			return "You have Logged In Successfully";
		else throw new UserNotFoundException();		
	}
}
