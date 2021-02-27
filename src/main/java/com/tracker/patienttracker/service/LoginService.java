package com.tracker.patienttracker.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public String loginCheck(int userId,String password, String role) {		
		Optional<User> result=userRepository.findById(userId);
		if(result.isPresent()&& result.get().getRole().equals(role) 
				&&result.get().getApproved()==1 &&result.get().getPassword().equals(password))
			return "Login Successfull";
		else return "null";
	}
}
