package com.tracker.patienttracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.tracker.patienttracker.dto.IdPasswordRole;
import com.tracker.patienttracker.dto.RegistrationData;
import com.tracker.patienttracker.exception.UserNotFoundException;
import com.tracker.patienttracker.service.AdminService;
import com.tracker.patienttracker.service.RegistrationService;

@RestController
@CrossOrigin
//@RequestMapping("/users")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	@Autowired
	AdminService adminService;

	@PostMapping("/registration")
	public String registration(@RequestBody RegistrationData registrationData) {		
		return registrationService.registration(registrationData);
	}
	
	@PostMapping("/login")
	public String loginCheck(@RequestBody IdPasswordRole obj) {
		int userId=obj.getUserId();
		String password=obj.getPassword();
		String role=obj.getRole();
		if(role.equals("ROLE_ADMIN")) {
			String messg=adminService.loginCheckAdmin(userId, password);
			if(!messg.equals("null")) {
				return "Valid Credintials";
			}		
		else throw new UserNotFoundException();
		}
		else return "Check other roles";
	}
}
