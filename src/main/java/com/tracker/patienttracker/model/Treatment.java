package com.tracker.patienttracker.model;

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
@AllArgsConstructor
public class Treatment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int treatmentId;
	private String treatmentDescription;
	private double treatmentCost;
	private String dietExcerciseDescription;
}
