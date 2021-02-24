package com.tracker.patienttracker.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inpatientrecord")
public class InPatientRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inPatientRecordId;
	private int patientId;
	private double roomCharges;
	private Date admissionDate;
	private Date dischargeDate;

}
