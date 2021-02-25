package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.InPatientRecord;

@Repository
public interface InPatientRecordRepository extends JpaRepository<InPatientRecord, Integer>{
	// List of In Patients
		//Select * from inpatientrecord where dischargeDate = null
		@Query(value = "Select i From InPatientRecord i where i.dischargeDate = null")
		public InPatientRecord getAllInPatientRecords();
		
		// List of In Patients
		//Select * from inpatientrecord where patientId=patientId
		@Query(value = "Select i From InPatientRecord i left join i.patient p where p.patientId=:patientId")
		public InPatientRecord getInPatientRecordByPatientId(int patientId);
}
