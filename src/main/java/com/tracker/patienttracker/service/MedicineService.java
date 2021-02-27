package com.tracker.patienttracker.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.error.InvalidTokenException;
import com.tracker.patienttracker.model.Medicine;
import com.tracker.patienttracker.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	private MedicineRepository medicineRepository;
	
//	@Autowired
//	private UserService userService;
	
	@Transactional
	public Medicine getMedicineFromMedicineName(String medicineName) throws Exception {
//		AuthResponse response = userService.getValidity(token);
//		if(!response.isValid)
//			throw new InvalidTokenException("Token is not valid");
		
		Medicine medicine = medicineRepository.findByMedicineName(medicineName);
		if(medicine == null)
			throw new Exception("Medicine not found");
		return medicine;
	}

}
