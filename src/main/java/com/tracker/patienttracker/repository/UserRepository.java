package com.tracker.patienttracker.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tracker.patienttracker.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//
//	@Modifying
//	@Query(value="update User u set u.approved=1 where u.userId=:userId")
//	void userApproval(@Param(value = "userId") int userId);
//
//	@Modifying
//	@Query(value="update User u set u.approved=-1 where u.userId=:userId")
//	void userDenial(@Param(value = "userId") int userId);
	
	@Query(value="select * from user  where approved=0",nativeQuery=true)
	public  Set<User> userApprovalPendingList();
	
	public Optional<User> findByUserIdAndRoleAndPassword(int id, String role, String password);
	
	//public Optional<User> findByUserIdAndPassword(int id, String password);	
}
