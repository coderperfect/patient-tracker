package com.tracker.patienttracker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.patienttracker.model.Medicine;
import com.tracker.patienttracker.model.MedicineQuantity;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.Treatment;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace =Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PatientRepositoryTest {
	
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private TreatmentRepository treatmentRepository;
	
	@Test
	@Order(1)
    @Rollback(false)
	public void testaddPrescriptionToPatientRecord() {
		//get patient
		Optional<PatientRecord> optional2 = patientRecordRepository.findById(1);
		PatientRecord patientRecord=optional2.get();
		
		Set<MedicineQuantity> medicineQuantities = new HashSet<>();
		//first medicine
		MedicineQuantity medicineQuantity = new MedicineQuantity();
		Optional<Medicine> optional = medicineRepository.findById(1);
		Medicine medicine = optional.get();
		medicineQuantity.setMedicine(medicine);
		medicineQuantity.setQuantity(10);
		medicineQuantity.setNoOfDays(10);
		medicineQuantities.add(medicineQuantity);
		//second medicine
		MedicineQuantity medicineQuantity2 = new MedicineQuantity();
		optional = medicineRepository.findById(2);
		medicine = optional.get();
		medicineQuantity2.setMedicine(medicine);
		medicineQuantity2.setQuantity(20);
		medicineQuantity2.setNoOfDays(40);
		medicineQuantities.add(medicineQuantity2);
		//set of prescriptions
		Set<Prescription> prescriptions = new HashSet<>();
		
		//add prescription 1
		Prescription prescription = new Prescription();
		prescription.setMedicineQuantities(medicineQuantities);
		prescription.setPrescriptionCost(1000);
		prescription.setPaid(false);
		prescription.setBilled(false);
		prescription.setPatientRecord(patientRecord);
		prescriptions.add(prescription);
		//add prescription 2
		prescription = new Prescription();
		medicineQuantity2.setQuantity(14);
		medicineQuantities.add(medicineQuantity2);
		prescription.setMedicineQuantities(medicineQuantities);
		prescription.setPrescriptionCost(1000);
		prescription.setPaid(false);
		prescription.setBilled(false);
		prescription.setPatientRecord(patientRecord);
		prescriptions.add(prescription);
		//update the patient record
		patientRecord.setPrescriptions(prescriptions);
		
		PatientRecord saved = patientRecordRepository.save(patientRecord);
		
		assertEquals(patientRecord, saved);
	}
	
	@Test
	@Order(2)
    @Rollback(false)
	public void testaddTestToPatientRecord() {
		
		//get patient
		Optional<PatientRecord> optional2 = patientRecordRepository.findById(1);
		PatientRecord patientRecord=optional2.get();
		
		//getTest
		Optional<com.tracker.patienttracker.model.Test> opTest = testRepository.findById(1);
		com.tracker.patienttracker.model.Test test = opTest.get();
		
		//create testreport
		TestReport report = new TestReport();
		report.setBilled(false);
		report.setDoctor(patientRecord.getDoctor());
		report.setPaid(false);
		report.setPatient(patientRecord.getPatient());
		report.setPatientRecord(patientRecord);
		report.setRequested(false);
		report.setTest(test);
		report.setTestResult("pending");
		
		//set of test reports
		Set<TestReport> reports = new HashSet<>();
		reports.add(report);
		
		//add test to record
		patientRecord.setTestreports(reports);
		
		PatientRecord saved = patientRecordRepository.save(patientRecord);
		
		assertEquals(patientRecord, saved);
		
	}
	
	@Test
	@Order(3)
    @Rollback(false)
	public void testaddTreatmentToPatientRecord() {
		
		//get patient
		Optional<PatientRecord> optional2 = patientRecordRepository.findById(1);
		PatientRecord patientRecord=optional2.get();
		
		//create treatment
		Treatment treatment1 = new Treatment();
		Treatment treatment2 = new Treatment();
		
		treatment1.setTreatmentDescription("Apply HPSCO Ointment twice a day \n Use moisturiser after bath");
		treatment2.setTreatmentDescription("Dialysis 2 times a week");
		treatment2.setDietExcerciseDescription("Avoid junk food \n Eat more fruits");
		treatment2.setTreatmentCost(100000);
		treatment1.setTreatmentCost(500);
		
		// set of treatments
		Set<Treatment> treatments = new HashSet<>();
		treatments.add(treatment1);
		treatments.add(treatment2);
		//add test to record
		patientRecord.setTreatments(treatments);
		
		PatientRecord saved = patientRecordRepository.save(patientRecord);
		
		assertEquals(patientRecord, saved);
		
	}
	
	@Test
	@Order(4)
    @Rollback(false)
	public void testFetchPrescriptions() {
		//get patient record
		Optional<PatientRecord> optional2 = patientRecordRepository.findById(1);
		PatientRecord patientRecord=optional2.get();
		
		//fetch prescriptions
		Set<Prescription> prescriptions = patientRecord.getPrescriptions();
	}
	
	
	@Test
	@Order(5)
    @Rollback(false)
	public void testRegistrationApproval()
	{
		
	}
	


}
