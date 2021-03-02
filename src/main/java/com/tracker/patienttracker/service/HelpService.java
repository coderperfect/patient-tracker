package com.tracker.patienttracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.dto.HelpDTO;
import com.tracker.patienttracker.model.Help;
import com.tracker.patienttracker.repository.HelpRepository;
import com.tracker.patienttracker.validator.ConstraintValidation;

@Service
public class HelpService {
	
	@Autowired
	HelpRepository helpRepository; 
	@Autowired
	ConstraintValidation constraintValidation;
	
	@Transactional
	public String saveIssues(HelpDTO help) {
		String issue=help.getIssue();
		String description=help.getDescription();
		Help obj=new Help();
		obj.setIssue(issue);
		obj.setDescription(description);
		String errors=constraintValidation.validationCheck(obj);
		if(!errors.equals(""))
			return errors; 
		helpRepository.save(obj);
		return "Issues have been saved successfully";
		
	}
}
