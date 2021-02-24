package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
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
	private int prescriptionId;
	@NotNull(message = "Medicine Id is required")
	private int medicineId;
	@NotNull(message = "Quantity is required")
	private int quantity;
	@NotNull(message = "Prescription Cost is required")
	@Digits(integer = 32, fraction = 2, message = "Please Enter a valid cost")
	private double prescriptionCost;
	@NotNull(message = "Paid is required")
	private boolean paid;
	@NotNull(message = "Billed is required")
	private boolean billed;
	
	
	@Override
	public String toString() {
		return "Prescription(prescriptionId=" + prescriptionId + ", medicineId=" + medicineId + ", quantity="
				+ quantity + ", prescriptionCost=" + String.format("%.2f", prescriptionCost) + ", paid=" + paid + ", billed=" + billed + ")";
	}
}
