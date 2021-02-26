package com.tracker.patienttracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "clerk")
public class Clerk {
	@Id
	int clerkId;

	@OneToOne
	@JoinColumn(name="userId")
	private User user;
}
