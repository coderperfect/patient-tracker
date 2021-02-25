package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Treatment;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {

}
