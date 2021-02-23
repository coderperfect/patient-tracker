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
public class PatientRecord {
	
	@Id
	private int recordId;
	private int doctorId;
	private int treatmentId;
	private int testId;
	private int patientId;
	private int prescriptionId;
}
