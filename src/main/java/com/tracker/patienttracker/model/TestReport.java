package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="test_report")
public class TestReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testResultId;
	
	@OneToOne
	@NotNull
	private Test test;
	
	@NotNull(message="Please provide Patient Id")
	@Min(value = 1, message = "The value must be positive")
	@OneToOne
	private Patient patient;
	
	private String testResult;
	
	@NotNull
	@OneToOne
	private Doctor doctor ;
	
	private boolean requested;

	private boolean paid;
	
	@ManyToOne
	@JoinColumn(name = "recordId")
	private PatientRecord patientRecord;
}
