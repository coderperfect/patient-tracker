package com.tracker.patienttracker.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * @author: Burre Chandu (883619)
 */
@Entity
@Data
@NoArgsConstructor
public class Patient{
	@Id
	int patientId;
	
	@NotEmpty(message = "The blood group cannot be empty")
	@NotBlank(message = "The blood group  cannot be blank or whitespace")
	@Pattern(regexp="^(O|A|B|AB)(\\+ve|-ve)$")
	String bloodGroup;
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
}