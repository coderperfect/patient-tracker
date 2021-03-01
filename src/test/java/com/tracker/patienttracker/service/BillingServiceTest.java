package com.tracker.patienttracker.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.repository.BillingRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BillingServiceTest {
	@MockBean
	BillingRepository billingRepository;
	
	@MockBean
	PatientService patientService;
	
	@Test
	@Order(1)
	void testCreateEmptyBillByPatientId() {
		BillingService billingService = new BillingService();
		
		Patient patient = new Patient();
		patient.setPatientId(22);
		
		when(patientService.getPatient(22)).thenReturn(patient);
		
		billingService.setPatientService(patientService);
		
		Billing billing = billingService.createEmptyBillByPatientId(22);
				
		assertNotNull(billing);
		assertEquals(22, billing.getPatient().getPatientId());
	}
	
	@Test
	@Order(2)
	void testSaveBilling() {
		BillingService billingService = new BillingService();
		
		Patient patient = new Patient();
		patient.setPatientId(22);
		
		Billing billing = new Billing();
		
		billing.setPatient(patient);
		
		when(billingRepository.save(billing)).thenReturn(billing);
		
		billingService.setBillingRepository(billingRepository);
		
		Billing billingResult = billingService.saveBilling(billing);
				
		assertNotNull(billingResult);
		assertEquals(22, billing.getPatient().getPatientId());
	}
}
