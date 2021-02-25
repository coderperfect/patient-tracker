package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@NotNull(message="Please provide Test Id")
	@Min(value = 1, message = "The value must be positive")
	private int testId;
	@NotNull(message="Please provide Patient Id")
	@Min(value = 1, message = "The value must be positive")
	private int patientId;
	@NotEmpty
	private String testResult;
	@NotNull(message="Please provide Doctor Id")
	@Min(value = 1, message = "The value must be positive")
	private int doctorId;
	//@NotNull(message="Requested Column can not be null")
	private boolean requested;
	//@NotNull(message="Paid Column can not be null")
	private boolean paid;
}
