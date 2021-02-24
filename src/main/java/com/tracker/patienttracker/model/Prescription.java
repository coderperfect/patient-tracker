package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
