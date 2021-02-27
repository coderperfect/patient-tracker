package com.tracker.patienttracker.service;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.dto.PatientRecordDTO;
import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.model.Doctor;
import com.tracker.patienttracker.model.MedicineQuantity;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.PatientRecord;
import com.tracker.patienttracker.model.Prescription;
import com.tracker.patienttracker.model.TestReport;
import com.tracker.patienttracker.model.Treatment;
import com.tracker.patienttracker.repository.PatientRecordRepository;
import com.tracker.patienttracker.repository.PatientRepository;

@Service
public class PatientRecordService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private TreatmentService treatmentService;

	@Autowired
	private PatientRecordRepository patientRecordRepository;
	
	public Set<Prescription> prescriptions(int patientRecordId, int doctorId) {
		Doctor doctor = doctorService.getDoctor(doctorId);
		//Patient patient = patientService.getPatient(patientId);
		Optional<PatientRecord> optional = patientRecordRepository.findByrecordIdAndDoctor(patientRecordId, doctor);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getPrescriptions();
	}
	
	public Set<TestReport> testReports(int patientRecordId, int doctorId) {
		Doctor doctor = doctorService.getDoctor(doctorId);
		
		//getpatientRecord
		Optional<PatientRecord> optional = patientRecordRepository.findByrecordIdAndDoctor(patientRecordId, doctor);
		
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getTestreports();
	}
	
	public Set<Treatment> treatments(int patientRecordId, int doctorId) {
		Doctor doctor = doctorService.getDoctor(doctorId);
		//Patient patient = patientService.getPatient(patientId);
		Optional<PatientRecord> optional = patientRecordRepository.findByrecordIdAndDoctor(patientRecordId, doctor);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		
		PatientRecord patientRecord=optional.get();
		return patientRecord.getTreatments();
	}
	
	public String addPrescription(PatientRecordDTO dto) {
		int patientRecordId = dto.getRecordId();
		int doctorId = dto.getDoctorId();
		Doctor doctor =  doctorService.getDoctor(doctorId);
		
		Optional<PatientRecord> optional = patientRecordRepository.findByrecordIdAndDoctor(patientRecordId, doctor);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		
		Prescription prescription = dto.getPrescription();
		double prescriptionCost = 0;
		for(MedicineQuantity mq : prescription.getMedicineQuantities()) {
			prescriptionCost = prescriptionCost + mq.getQuantity()*mq.getMedicine().getMedicineCost();
		}
		
		PatientRecord patientRecord=optional.get();
		prescription.setPrescriptionCost(prescriptionCost);
		patientRecord.getPrescriptions().add(prescription);
		PatientRecord record = patientRecordRepository.save(patientRecord);
		
		return "Added Successfully";
		
	}

	public String addTreatment(PatientRecordDTO dto) {
		int patientRecordId = dto.getRecordId();
		int doctorId = dto.getDoctorId();
		Doctor doctor =  doctorService.getDoctor(doctorId);
		
		Optional<PatientRecord> optional = patientRecordRepository.findByrecordIdAndDoctor(patientRecordId, doctor);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		
		Treatment treatment = dto.getTreatment();
		PatientRecord patientRecord=optional.get();
		
		Set<Treatment> treatments = patientRecord.getTreatments();
		treatments.add(treatment);
		patientRecord.setTreatments(treatments);
		PatientRecord record = patientRecordRepository.save(patientRecord);
		
		return "Added Successfully";
	}
	
	
	
	
	
	
}
