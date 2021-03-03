package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracker.patienttracker.model.InPatientRecord;
import com.tracker.patienttracker.service.InPatientRecordService;

@WebMvcTest(InPatientRecordController.class)
class InPatientRecordControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	InPatientRecordService inPatientRecordService;
	
	@Test
	@Order(1)
	void testGetAllInPatientRecords() throws Exception {
		when(inPatientRecordService.getAllInPatientRecords()).thenReturn(new ArrayList<InPatientRecord>());
		
		ResultActions actions = mockMvc.perform(get("/inpatientrecord"));
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$[0]").doesNotExist());
	}
	
	@Test
	@Order(2)
	void testGetInPatientRecordByInPatientRecordId() throws Exception {
		InPatientRecord inPatientRecord = new InPatientRecord();
		inPatientRecord.setInPatientRecordId(21);
		
		when(inPatientRecordService.getInPatientRecordByInPatientRecordId(21)).thenReturn(inPatientRecord);
		
		ResultActions actions = mockMvc.perform(get("/inpatientrecord/21"));
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$.inPatientRecordId").value(inPatientRecord.getInPatientRecordId()));
	}
	
	@Test
	@Order(3)
	void testAddInPatientRecord() throws Exception {
		InPatientRecord inPatientRecord = new InPatientRecord();
		inPatientRecord.setInPatientRecordId(21);
		
		when(inPatientRecordService.updateInPatientRecord(inPatientRecord)).thenReturn(inPatientRecord);
		
		ResultActions actions = mockMvc.perform(put("/inpatientrecord")
				.content(asJsonString(inPatientRecord))
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON));
		
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$.inPatientRecordId").value(inPatientRecord.getInPatientRecordId()));
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
