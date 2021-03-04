package com.tracker.patienttracker.service;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceTest {
	@Autowired
	UserService userService;
	
	@Test
	@Order(1)
	void testGetPendingApprovalRequest()
	{
		assertNotNull(userService.userApprovalPendingList());
	}
	@Test
	@Order(2)
	void testGetApproval()
	{
		userService.userApproval(1);
		assertEquals(1,1);
	}
	@Test
	@Order(3)
	void testGetDenial()
	{
		userService.userDenial(1);
		assertEquals(1,1);
	}
	@Test
	@Order(4)
	void testGetUserById()
	{
		String str=userService.getUserByUserId(1).getFirstName();
		assertEquals(str,userService.getUserByUserId(1).getFirstName());
	}
}
