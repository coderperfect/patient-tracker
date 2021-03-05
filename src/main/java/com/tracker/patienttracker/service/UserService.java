package com.tracker.patienttracker.service;

import java.util.Date;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public User getUserByContactAndDateOfBirth(String contactNo,Date dob) {
		
		return userRepository.findByContactNoAndDateOfBirth(contactNo, dob);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	@Transactional
	public String userApproval(int userId)
	{
		User u=userRepository.findById(userId).get();
		u.setApproved(1);
		userRepository.save(u);
		return("Sucessfully Approved");
	}
	@Transactional
	public String userDenial(int userId)
	{
		User u=userRepository.findById(userId).get();
		u.setApproved(-1);
		userRepository.save(u);
		return("Sucessfully Denied");
	}
	public Set<User> userApprovalPendingList()
	{
		return userRepository.userApprovalPendingList();
	}
	
	public User getUserByUserId(int userId) {
		return userRepository.findById(userId).get();
	}
}
