package com.tracker.patienttracker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
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
	
	@NotNull(message="Please provide Test Id")
	@OneToOne
	@JoinColumn(name="testId")
	private Test test;
	
	@NotNull(message="Please provide Patient Id")
	@OneToOne
	@JoinColumn(name="patientId")
	private Patient patient;
	
	@NotEmpty
	private String testResult;
	
	@NotNull(message="Please provide Doctor Id")
	@ManyToOne
	@JoinColumn(name = "doctorId")
	private Doctor doctor;
	
	private boolean requested;
	
	private boolean paid;
}
