package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.service.TreatmentService;

@WebMvcTest
public class TreatmentControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	TreatmentService treatmentService;
	
	@Test
	public void getTreatmentDetailsTest() throws Exception {
		Treatment treatment = new Treatment(1,"Description",12.50,"DietDescription",new PatientRecord());
		when(treatmentService.getTreatmentDetails(1)).thenReturn(treatment);
		
		mockMvc.perform(
				MockMvcRequestBuilders
				.get("/details/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
