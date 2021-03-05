package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.security.JwtUtil;
import com.tracker.patienttracker.service.CustomUserDetailsService;
import com.tracker.patienttracker.service.PatientService;

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

	@InjectMocks
	PatientController patientController;
	@MockBean
	PatientService patientService;
	@Autowired
	MockMvc mockMvc;
	@MockBean
	CustomUserDetailsService customUserDetailsService;
	
	@MockBean
	JwtUtil jwtUtil;
	
	 @Test
	 @WithMockUser(authorities = {"ROLE_ADMIN"})
	 void testGetAllPatientList() throws Exception {
		List<Patient> list=new ArrayList<Patient>();
		
		User u=new User(1, "jon", "Smith", "male",new SimpleDateFormat("dd/mm/yyyy").parse( "12/12/2012"), "1111111111", "pass@123","New Street Mumbai","ROLE_PATIENT",0);
		Patient p=new Patient(1, "O+ve", u);
		list.add(p);
		Mockito.when(patientService.getPatientList()).thenReturn((List<Patient>) list);
		mockMvc.perform(MockMvcRequestBuilders.get("/patient/getallpatients")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	 
	 @Test
	 @WithMockUser(authorities = {"ROLE_ADMIN"})
	 void testGetPatientDetails() throws Exception {
		
		
		User u=new User(1, "jon", "Smith", "male",new SimpleDateFormat("dd/mm/yyyy").parse( "12/12/2012"), "1111111111", "pass@123","New Street Mumbai","ROLE_PATIENT",0);
		Patient p=new Patient(1, "O+ve", u);
	
		Mockito.when(patientService.getPatientDetails(1)).thenReturn(p);
		mockMvc.perform(MockMvcRequestBuilders.get("/patient/details/{patientId}",1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
