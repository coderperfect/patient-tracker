package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author: Burre Chandu (883619)
 */

@Entity
@Data
@NoArgsConstructor
public class Doctor{
	@Id
	@NotNull(message = "Doctor Id is required")
	private int doctorId;
	@NotNull(message = "Qualification is required")
	private String qualification;
	@NotNull(message = "Specialisation is required")
	private String specialization;
	@NotNull(message = "Consultation Fee is required")
	@Digits(integer = 32, fraction = 2, message = "Please Enter a valid fee")
	private double consultationFee;
	@NotNull(message = "User Id is required")
	private int userId;
}
