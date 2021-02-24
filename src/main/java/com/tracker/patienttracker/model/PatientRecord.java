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
public class PatientRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int recordId;
	private int doctorId;
	private int treatmentId;
	private int testId;
	private int patientId;
	private int prescriptionId;
}
