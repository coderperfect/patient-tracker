package com.tracker.patienttracker.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.Admin;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.AdminRepository;
import com.tracker.patienttracker.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public String loginCheckAdmin(int userId,String password) {
		Optional<Admin> result=adminRepository.findById(userId);
		Optional<User> result1=userRepository.findById(userId);
		if(result.isEmpty()|| result1.isEmpty()|| !(result1.get().getPassword().equals(password)))
			return "null";
		else return "Login Successfull";
	}
	
	
	
	
}
