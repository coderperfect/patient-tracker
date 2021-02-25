package com.tracker.patienttracker.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsultationTest {

	private Consultation obj=new  Consultation();
	
	@Test
	public void testSetconsultationId(){
		obj.setConsultationId(1);
		assertEquals(obj.getConsultationId(),1);
	}
	@Test
	public void testGetconsultationId(){
		obj.setConsultationId(1);
		assertEquals(obj.getConsultationId(),1);
	}
}
