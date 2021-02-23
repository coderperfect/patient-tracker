package com.tracker.patienttracker.model;

import javax.persistence.Entity;
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
	private int treatmentId;
	private String treatmentDescription;
	private Double treatmentCost;
	private String dietExcerciseDescription;
}
