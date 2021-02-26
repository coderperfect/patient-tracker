package com.tracker.patienttracker.service;

import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.exception.PatientNotFoundException;
import com.tracker.patienttracker.model.Doctor;
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
	private PatientRecordRepository patientRecordRepository;
	
	public Set<Prescription> prescriptions(int patientId, int doctorId) {
		Doctor doctor = doctorService.getDoctor(doctorId);
		Patient patient = patientService.getPatient(patientId);
		//getpatientRecord
		Optional<PatientRecord> optional = patientRecordRepository.findByPatientAndDoctor(patient, doctor);
		if(!optional.isPresent()) {
			throw new PatientNotFoundException();
		}
		PatientRecord patientRecord=optional.get();
		return patientRecord.getPrescriptions();
	}
	
	public Set<TestReport> testReports(int patientId, int doctorId) {
		Doctor doctor = doctorService.getDoctor(doctorId);
		Patient patient = patientService.getPatient(patientId);
		//getpatientRecord
		Optional<PatientRecord> optional = patientRecordRepository.findByPatientAndDoctor(patient, doctor);
		
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
	
	
	
	
}
