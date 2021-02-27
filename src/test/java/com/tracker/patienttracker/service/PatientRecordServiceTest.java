package com.tracker.patienttracker.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.DoctorRepository;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.PatientRepository;
import com.tracker.patienttracker.util.DateUtil;

@ExtendWith(MockitoExtension.class)
public class PatientRecordServiceTest {
	
	
	@Mock
	private PatientRepository patientRepository;
	
	@Mock
	private PatientService patientService;
	
	@Mock
	private DoctorService doctorService;
	
	@Mock
	private DoctorRepository doctorRepository;

	@Mock
	private PatientRecordRepository patientRecordRepository;
	
	@InjectMocks
	private PatientRecordService recordService;
	
	@Test
	public void testgetPrescriptions() {
		User user = new User();
		user.setUserId(2);
		
		User user1 = new User();
		user1.setUserId(1);
		
		Patient patient = new Patient();
		patient.setBloodGroup("O+ve");
		patient.setPatientId(1);
		patient.setUser(user1);
		
		Doctor doctor = new Doctor();
		doctor.setDoctorId(2);
		doctor.setUser(user);
		
		when(patientRepository.findById(1)).thenReturn(Optional.of(patient));
		Patient mockPatient = patientService.getPatient(1);
		
		when(doctorRepository.findById(2)).thenReturn(Optional.of(doctor));
		Doctor mockDoctor = doctorService.getDoctor(2);
				
		when(patientRecordRepository.findByPatientAndDoctor(mockPatient, mockDoctor)).thenReturn(Optional.of(new PatientRecord()));
		Set<Prescription> prescriptions = recordService.prescriptions(1,2);
		assertNull(prescriptions);
		
	}
	
	
}
