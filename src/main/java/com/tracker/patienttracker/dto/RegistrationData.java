package com.tracker.patienttracker.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationData{
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String contactNo;
	private String password;
	private String address;
	private String role;
	
	private String qualification;
	private String specialization;
	private double consultationFee;
	private String bloodGroup;	

}
