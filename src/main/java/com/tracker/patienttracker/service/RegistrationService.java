package com.tracker.patienttracker.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.dto.RegistrationData;
import com.tracker.patienttracker.model.Admin;
import com.tracker.patienttracker.model.Clerk;
import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.AdminRepository;
import com.tracker.patienttracker.repository.ClerkRepository;
import com.tracker.patienttracker.repository.DoctorRepository;
import com.tracker.patienttracker.repository.PatientRepository;
import com.tracker.patienttracker.repository.UserRepository;
import com.tracker.patienttracker.util.DateUtil;
import com.tracker.patienttracker.validator.ConstraintValidation;

@Service
public class RegistrationService {

	@Autowired
	RegistrationData registrationData; 
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	DoctorRepository doctorRepository;
	@Autowired
	PatientRepository patientRepository;
	@Autowired
	ClerkRepository clerkRepository;
	@Autowired
	ConstraintValidation constraintValidation;
	@Autowired
	PatientRecordService prService;
	
	@Autowired
	DoctorService docService;
	
	@Transactional
	public String registration(RegistrationData registrationData) {		
		String firstName=registrationData.getFirstName();
		String lastName=registrationData.getLastName();
		String gender=registrationData.getGender();
		String dob=registrationData.getDateOfBirth();
		Date dateOfBirth=new DateUtil().convertToDate1(dob);
		//Date dateOfBirth=registrationData.getDateOfBirth();
		String contactNo=registrationData.getContactNo();
		String password=registrationData.getPassword();
		String address=registrationData.getAddress();
		String role=registrationData.getRole();
		int doctorId = registrationData.getDoctorId();
		User obj= new User();
		obj.setFirstName(firstName);
		obj.setLastName(lastName);
		obj.setGender(gender);
		obj.setDateOfBirth(dateOfBirth);
		obj.setContactNo(contactNo);
		obj.setPassword(password);
		obj.setAddress(address);
		obj.setRole(role);	
		
		String errors=constraintValidation.validationCheck(obj);
		if(!errors.equals(""))
			return errors; 
		
		if(role.equals("ROLE_ADMIN"))
			obj.setApproved(1);
		
		int userId=0;
		User userObj=userRepository.save(obj);
		if(role.equals("ROLE_DOCTOR")) {		
			userId=userObj.getUserId();
			Doctor obj1=new Doctor(userId,registrationData.getQualification(),
				registrationData.getSpecialization(),registrationData.getConsultationFee(),userObj);
			errors=constraintValidation.validationCheck(obj1);
			if(!errors.equals(""))
				return errors; 
			doctorRepository.save(obj1);
			}
		else if(role.equals("ROLE_PATIENT")) {
			userId=userObj.getUserId();
			Patient obj1=new Patient(userId, registrationData.getBloodGroup(),userObj);
			errors=constraintValidation.validationCheck(obj1);
			if(!errors.equals(""))
				return errors; 
			patientRepository.save(obj1);
			PatientRecord patientRecord = new PatientRecord();
			patientRecord.setPatient(obj1);
			patientRecord.setRecordId(obj1.getPatientId());
			patientRecord.setDate(new Date());
			Doctor doctor = docService.getDoctor(doctorId);
			patientRecord.setDoctor(doctor);
			prService.addPatientRecord(patientRecord);
		}
		else if(role.equals("ROLE_CLERK")){
			userId=userObj.getUserId();
			Clerk obj1=new Clerk(userId,userObj);
			clerkRepository.save(obj1);			
		}
		else if(role.equals("ROLE_ADMIN")){
			userId=userObj.getUserId();
			Admin obj1=new Admin(userId,userObj);
			adminRepository.save(obj1);
			return "Thanks For Registiring Your UserID is "+userId;
		}
		return "Thanks For Registiring Please wait for the Approval Your UserId is "+userId;
	}
	
}

