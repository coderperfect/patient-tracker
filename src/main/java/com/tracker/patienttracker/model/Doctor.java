package com.tracker.patienttracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	private int doctorId;
	private String qualification;
	private String specialization;
	private double consultationFee;
}
