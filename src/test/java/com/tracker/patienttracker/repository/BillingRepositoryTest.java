package com.tracker.patienttracker.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.model.Patient;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
class BillingRepositoryTest {
	@Autowired
	BillingRepository billingRepository;
	
	@Test
	@Order(1)
	void testSaveBilling() {
		Patient patient = new Patient();
		
		Billing billing = new Billing();
		billing.setPatient(patient);
		
		assertNotNull(billingRepository.save(billing));
	}
}
