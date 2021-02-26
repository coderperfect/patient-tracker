package com.tracker.patienttracker.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.dto.RegistrationData;
import com.tracker.patienttracker.model.Clerk;
import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.ClerkRepository;
import com.tracker.patienttracker.repository.DoctorRepository;
import com.tracker.patienttracker.repository.PatientRepository;
import com.tracker.patienttracker.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationData registrationData; 
	@Autowired
	UserRepository userRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	ClerkRepository clerkRepository;
	
	@Transactional
	public String registration(RegistrationData registrationData) {
		User obj= new User();
		String firstName=registrationData.getFirstName();
		String lastName=registrationData.getLastName();
		String gender=registrationData.getGender();
		Date dateOfBirth=registrationData.getDateOfBirth();
		String contactNo=registrationData.getContactNo();
		String password=registrationData.getPassword();
		String address=registrationData.getAddress();
		String role=registrationData.getRole();
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setGender(gender);
		obj.setDateOfBirth(dateOfBirth);
		obj.setContactNo(contactNo);
		obj.setPassword(password);
		obj.setAddress(address);
		obj.setRole(role);
		User userObj=userRepository.save(obj);
		if(role.equals("Doctor")) {
			Doctor obj1=new Doctor(userObj.getUserId(),registrationData.getQualification(),
				registrationData.getSpecialization(),registrationData.getConsultationFee(),userObj);
			doctorRepository.save(obj1);
			}
		else if(role.equals("Patient")) {
			Patient obj1=new Patient(userObj.getUserId(),registrationData.getBloodGroup(),userObj);
			patientRepository.save(obj1);
		}
		else {
			Clerk obj1=new Clerk(userObj.getUserId(),userObj);
			clerkRepository.save(obj1);			
		}
		return "Thanks For Registring Please wait for the Approval";
	}
	
	
	
	
}

