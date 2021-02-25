package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
