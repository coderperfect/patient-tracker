package com.tracker.patienttracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String contactNo;
	private String password;
	private String address;
	private String role;
	
}
