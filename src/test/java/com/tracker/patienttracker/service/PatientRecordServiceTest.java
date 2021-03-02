package com.tracker.patienttracker.service;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.AdditionalAnswers;
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

import com.tracker.patienttracker.dto.PatientRecordDTO;
import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.exception.TreatmentNotFoundException;
import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.Medicine;
import com.tracker.patienttracker.model.MedicineQuantity;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.DoctorRepository;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.PatientRepository;
import com.tracker.patienttracker.util.DateUtil;

@ExtendWith(MockitoExtension.class)
public class PatientRecordServiceTest {
	
	@Mock
	private PatientService patientService;
	
	@Mock
	private DoctorService doctorService;
	
	@Mock
	private PatientRecordRepository patientRecordRepository;
	
	@InjectMocks
	private PatientRecordService recordService;
	
	@Mock
	private TreatmentService treatmentService;
	
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
		
		
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setPrescriptions(new HashSet<Prescription>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		
		Set<Prescription> prescriptions = recordService.prescriptions(1,2);
		assertTrue(prescriptions.isEmpty());
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.prescriptions(1,2));
	}
	
	@Test
	public void testgetTreatments() {
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
		
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setTreatments(new HashSet<Treatment>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		
		Set<Treatment> treatments = recordService.treatments(1,2);
		assertTrue(treatments.isEmpty());
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.treatments(1,2));
	}
	
	@Test
	public void updateTreatment() {
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
		PatientRecordDTO dto = new PatientRecordDTO();
		dto.setDoctorId(2);
		dto.setRecordId(1);
		Treatment treatment =  new Treatment();
		treatment.setTreatmentId(57);
		dto.setTreatment(treatment);
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setPatient(patient);
		Set<Treatment> treatments = new HashSet<Treatment>(); 
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		assertThrows(TreatmentNotFoundException.class, ()->recordService.updateTreatment(dto));
		record.setTreatments(treatments);
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		assertThrows(TreatmentNotFoundException.class, ()->recordService.updateTreatment(dto));
		treatments.add(treatment);
		record.setTreatments(treatments);
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		String resp = recordService.updateTreatment(dto);
		assertEquals(resp,"Updated Successfully");
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.updateTreatment(dto));
	}
	
	@Test
	public void addTreatment() {
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
		PatientRecordDTO dto = new PatientRecordDTO();
		dto.setDoctorId(2);
		dto.setRecordId(1);
		dto.setTreatment(new Treatment());
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setPatient(patient);
		record.setTreatments(new HashSet<Treatment>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		when(patientRecordRepository.save(record)).thenReturn(record);
		String resp = recordService.addTreatment(dto);
		assertEquals(resp,"Added Successfully");
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.addTreatment(dto));
	}
	
	@Test
	public void addPrescription() {
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
		PatientRecordDTO dto = new PatientRecordDTO();
		dto.setDoctorId(2);
		dto.setRecordId(1);
		Prescription prescription = new Prescription();
		Set<MedicineQuantity> medicineQuantities = new HashSet<>();
		MedicineQuantity medicineQuantity = new MedicineQuantity();
		Medicine medicine = new Medicine();
		medicine.setMedicineCost(100);
		medicineQuantity.setMedicine(medicine);
		medicineQuantity.setQuantity(10);
		medicineQuantity.setNoOfDays(10);
		medicineQuantities.add(medicineQuantity);
		prescription.setMedicineQuantities(medicineQuantities);
		dto.setPrescription(prescription);
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setPatient(patient);
		record.setPrescriptions(new HashSet<Prescription>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		
		String resp = recordService.addPrescription(dto);
		
		assertEquals(resp,"Added Successfully");
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.addPrescription(dto));
	}
	
	@Test
	public void testgettestreports() {
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
		
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setTestreports(new HashSet<TestReport>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		
		Set<TestReport> reports = recordService.testReports(1,2);
		assertTrue(reports.isEmpty());
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.testReports(1,2));
	}
	
	@Test
	public void addTestReport() {
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
		PatientRecordDTO dto = new PatientRecordDTO();
		dto.setDoctorId(2);
		dto.setRecordId(1);
		dto.setTestReport(new TestReport());
		when(doctorService.getDoctor(2)).thenReturn(doctor);
		PatientRecord record = new PatientRecord();
		record.setPatient(patient);
		record.setTestreports(new HashSet<TestReport>());
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.of(record));
		when(patientRecordRepository.save(record)).thenReturn(record);
		String resp = recordService.addTestReport(dto);
		assertEquals(resp,"Added Successfully");
		
		when(patientRecordRepository.findByrecordIdAndDoctor(1, doctor)).thenReturn(Optional.empty());
		assertThrows(PatientNotFoundException.class, ()->recordService.addTestReport(dto));
	}
	
}
