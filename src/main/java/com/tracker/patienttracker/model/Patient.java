package com.tracker.patienttracker.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 */
@Entity
@Data
@NoArgsConstructor
public class Patient extends User{

	int patientId;
	String bloodGroup;
}
