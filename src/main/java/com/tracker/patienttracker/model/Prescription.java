package com.tracker.patienttracker.model;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Prescription {
	private int prescriptionId;
	private int medicineId;
	private int quantity;
	private double prescriptionCost;
	private boolean paid;
	private boolean billed;
}
