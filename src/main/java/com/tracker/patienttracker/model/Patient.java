package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient{
	@Id
	int patientId;
	
	@Pattern(regexp="^(O|A|B|AB)(\\+ve|-ve)$")
	String bloodGroup;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
}