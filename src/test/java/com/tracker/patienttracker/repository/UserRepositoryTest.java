package com.tracker.patienttracker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.util.DateUtil;

@DataJpaTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace =Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	public User userMethod() {
		User obj= new User();
		obj.setFirstName("abcdefg");
		obj.setLastName("abcdefg");
		obj.setGender("male");
		obj.setDateOfBirth(DateUtil.convertToDate("22/07/1998"));
		obj.setContactNo("1234567890");
		obj.setPassword("K@1234kask");
		obj.setAddress("akasakakas");
		obj.setRole("ROLE_PATIENT");
		return obj;
	}
	
	@Test
    @Rollback(true)
	public void testaddUserRecord() {
		UserRepositoryTest obj=new UserRepositoryTest();
		User obj1=obj.userMethod();
		User userObj=userRepository.save(obj1);		
		assertEquals(userObj, obj1);		
	}
		

	@Test
    @Rollback(true)
	public void testfetchUserRecord() {
		UserRepositoryTest obj=new UserRepositoryTest();
		User obj1=obj.userMethod();
		User userObj=userRepository.save(obj1);		
		assertEquals(userRepository.findById(userObj.getUserId()).get(), obj1);		
	}
		
}
