package com.tracker.patienttracker.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patientrecord")
public class PatientRecord {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int recordId;
	
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	@OneToMany(cascade = CascadeType.ALL)	
	private Set<Treatment> treatments;
	
	@OneToMany(targetEntity = TestReport.class, cascade = CascadeType.ALL)
	private Set<TestReport> testreports;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "patientId")
	private Patient patient;
	
	@NotNull
	@OneToMany(targetEntity = Prescription.class, cascade = CascadeType.ALL)
	private Set<Prescription> prescriptions;
	
	@PastOrPresent
	@NotNull
	private Date date;
}


