package com.tracker.patienttracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.tracker.patienttracker.validator.ValidPassword;

import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotEmpty(message = "The firstname cannot be empty")
	@NotBlank(message = "The firstname cannot be blank or whitespace")
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String firstName;
	
	@NotEmpty(message = "The lastname cannot be empty")
	@NotBlank(message = "The lastname cannot be blank or whitespace")
	@Pattern(regexp = "^[\\p{L} .'-]+$")
	private String lastName;
	
	@NotEmpty(message = "Gender cannot be empty")
	@NotBlank(message = "Gender cannot be blank or whitespace")
	@Pattern(regexp = "^(male|female|other)$")
	private String gender;
	
	@NotNull(message = "The date of birth cannot be null")
	@PastOrPresent(message = "The date of birth is invalid")
	private Date dateOfBirth;
	
	@Size(min=10,max=10)
	@NotEmpty(message = "Contact no cannot be empty")
	@NotBlank(message = "Contact no cannot be blank or whitespace")
	@Pattern(regexp="^[1-9][0-9]{9}$")
	private String contactNo;
	
	@ValidPassword(message="Invalid password")
	@NotEmpty(message = "Password no cannot be empty")
	@Length(min=6, message="Password should be atleast six characters")
	private String password;
	
	@NotEmpty(message = "Address cannot be empty")
	@NotBlank(message = "Address cannot be blank or whitespace")
	private String address;
	
	@Pattern(regexp="^ROLE_(PATIENT|DOCTOR|ADMIN|CLERK)$", message="invalid role ")
	@NotEmpty(message = "role cannot be empty")
	@NotBlank(message = "role cannot be blank or whitespace")
	private String role;
	
	
	private int approved;
}

