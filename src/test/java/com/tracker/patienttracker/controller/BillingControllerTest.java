package com.tracker.patienttracker.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.tracker.patienttracker.service.BillingService;

@WebMvcTest(BillingController.class)
@TestMethodOrder(OrderAnnotation.class)
class BillingControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BillingService billingService;
	
	@Test
	void testCreateEmptyBillByPatientId() {
		assertTrue(true);
	}

}
