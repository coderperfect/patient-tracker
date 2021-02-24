package com.tracker.patienttracker.model;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prescription {
	private int prescriptionId;
	private int medicineId;
	private int quantity;
	private double prescriptionCost;
	private boolean paid;
	private boolean billed;
	
	@Override
	public String toString() {
		return "Prescription(prescriptionId=" + prescriptionId + ", medicineId=" + medicineId + ", quantity="
				+ quantity + ", prescriptionCost=" + String.format("%.2f", prescriptionCost) + ", paid=" + paid + ", billed=" + billed + ")";
	}
}
