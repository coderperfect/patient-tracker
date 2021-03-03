package com.tracker.patienttracker.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date dateOfBirth;
	private String contactNo;
	private String password;
	private String address;
	private String role;
	
	private String qualification;
	private String specialization;
	private double consultationFee;
	private String bloodGroup;	
	private int doctorId;

}