package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

}
