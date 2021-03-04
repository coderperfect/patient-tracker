package com.tracker.patienttracker.service;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Test;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.TestRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)

public class TestServiceTest {

	@MockBean
	TestRepository testRepository;
	@MockBean
	PatientRecordRepository  patientRecordRepository ;
	@MockBean
	TestService testService;
	
	@org.junit.jupiter.api.Test
	void testGetTestDetails()
	{
		Test test=new Test();
		test.setTestId(1);
		testRepository.save(test);
		Test test2 =testService.getTestDetails(1);
		assertEquals(test,test2);
	}
	
}
