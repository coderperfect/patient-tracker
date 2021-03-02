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
		Optional<User> result=userRepository.findByUserIdAndRoleAndPassword(userId, role, password);
		if(result.isPresent()) {
			User user=result.get();
			System.out.println(user);
				if(user.getApproved()==1)
					return "Login Successful";
				else if(user.getApproved()==0)
					return "Please Wait for the Admin Approval";
				else
					return "Your Registration was rejected by Admin";
		}			
		else return "null";
	}
}
