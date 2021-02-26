package com.tracker.patienttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "admin")
public class Admin {
	@Id
	int adminId;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
}
