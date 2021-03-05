package com.tracker.patienttracker.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@PatchMapping("/approval/{userId}")
	public ResponseEntity<?> userApproval(@PathVariable("userId") int userId)
	{	System.out.println("In the user App");
		//userService.userApproval(userId);
		return new ResponseEntity<>(userService.userApproval(userId),HttpStatus.OK);
	}
	@PatchMapping("/denial/{userId}")
	public ResponseEntity<?> userDenial(@PathVariable("userId") int userId)
	{
		//userService.userDenial(userId);
		return new ResponseEntity<>(userService.userDenial(userId),HttpStatus.OK);
	}
	@GetMapping()
	public Set<User> userApprovalPendingList()
	{
		return userService.userApprovalPendingList();
	}
}
