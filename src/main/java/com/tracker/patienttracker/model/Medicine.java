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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int medicineId;
	private String medicineName;
	private double medicineCost;
	
	@Override
	public String toString() {
		return "Medicine(medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ String.format("%.2f",medicineCost) + ")";
	}
}