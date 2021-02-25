package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 */
@Entity
@Data
@NoArgsConstructor
public class Clerk {
	@Id
	int clerkId;
	int userId;
}
