package com.tracker.patienttracker.model;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Repository
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicine {
	private int medicineId;
	private String medicineName;
	private double medicineCost;
	
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ String.format("%.2f",medicineCost) + "]";
	}
}