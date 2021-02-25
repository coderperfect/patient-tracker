package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
