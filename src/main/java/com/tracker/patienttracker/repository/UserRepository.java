package com.tracker.patienttracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Query(value="update User u set u.approved=true where u.userId=:userId")
	void userApproval(@Param(value = "userId") int userId);

}
