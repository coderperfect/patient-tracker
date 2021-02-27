package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.service.PatientRecordService;
import com.tracker.patienttracker.service.TestReportService;

@WebMvcTest
class TestReportControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	TestReportService testReportService;
	
	@MockBean
	PatientRecordService patientRecordService;
	
	@Test
	@WithMockUser()
	void testGetPendingUpdateTestReports() throws Exception {
		when(testReportService.getPendingUpdateTestReports()).thenReturn(new ArrayList<TestReport>());
		
		ResultActions actions = mockMvc.perform(get("/testreport"));
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$[0]").doesNotExist());
	}
	
	@Test
	@WithMockUser()
	void testUpdateTestResult() throws Exception {
		TestReport testReportGenerated = new TestReport();
		testReportGenerated.setTestResultId(21);
		testReportGenerated.setTestResult("Sugar level normal");
		
		when(testReportService.modifyTestReport(21, "Sugar level normal")).thenReturn(testReportGenerated);
		
		ResultActions actions = mockMvc.perform(put("/testreport/21")
				.content("Sugar level normal")
				.contentType(MediaType.APPLICATION_JSON)
			     .accept(MediaType.APPLICATION_JSON));
		actions.andExpect(status().isOk());
		
		actions.andExpect(jsonPath("$").value("Updated"));
	}
}
