package com.tracker.patienttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.InPatientRecord;
import com.tracker.patienttracker.model.Patient;
import com.tracker.patienttracker.model.Room;
import com.tracker.patienttracker.repository.InPatientRecordRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InPatientRecordService {
	@Autowired
	InPatientRecordRepository inPatientRecordRepository;
	
	@Autowired
	PatientService patientService;
	
	@Autowired
	RoomService roomService;
	
	public List<InPatientRecord> getAllInPatientRecords() {
		return inPatientRecordRepository.getAllInPatientRecords();
	}
	
	public InPatientRecord getInPatientRecordByPatientId(int patientId) {
		return inPatientRecordRepository.getInPatientRecordByPatientId(patientId);
	}
	
	public InPatientRecord addInPatientRecord(int patientId, int roomNo, InPatientRecord inPatientRecord) {
		Patient patient = patientService.getPatient(patientId);
		Room room = roomService.getRoomByNo(roomNo);
		
		inPatientRecord.setPatient(patient);
		inPatientRecord.setRoom(room);
		
		inPatientRecord = inPatientRecordRepository.save(inPatientRecord);
				
		return inPatientRecord;
	}
}