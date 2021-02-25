package com.tracker.patienttracker.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prescription {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "Prescription Id is required")
	@Min(value = 1, message = "Prescription Id has to be greater than or equal to 1")
	private int prescriptionId;
	@NotNull(message = "Medicine Id is required")
	@ManyToMany
	@JoinTable(name = "prescription_medicine", joinColumns = @JoinColumn(name = "medicineId"), inverseJoinColumns = @JoinColumn(name = "prescriptionId"))
	private Set<Medicine> medicines;
	@NotNull(message = "Quantity is required")
	private int quantity;
	@NotNull(message = "Prescription Cost is required")
	@Digits(integer = 32, fraction = 2, message = "Please Enter a valid cost")
	private double prescriptionCost;
	@NotNull(message = "Paid is required")
	private boolean paid;
	@NotNull(message = "Billed is required")
	private boolean billed;
	
	@ManyToOne
	@JoinColumn(name = "recordId")
	private PatientRecord patientRecord;
	
}
