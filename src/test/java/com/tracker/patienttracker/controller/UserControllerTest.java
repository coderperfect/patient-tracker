package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.tracker.patienttracker.model.Billing;
import com.tracker.patienttracker.security.JwtUtil;
import com.tracker.patienttracker.service.CustomUserDetailsService;
import com.tracker.patienttracker.service.UserService;

@WebMvcTest(DoctorController.class)
public class UserControllerTest {
		@Autowired
		MockMvc mockMvc;
		@MockBean
		CustomUserDetailsService customUserDetailsService;
		@MockBean
		JwtUtil jwtUtil;
		@MockBean
		UserService userService;
//		
//	@Test
//	@Order(1)
//	@WithMockUser(authorities = "ROLE_ADMIN")
//	void testGetApproval() throws Exception {
//		when(userService.userApproval(1002)).thenReturn(true);
//		
//		ResultActions actions = mockMvc.perform(patch("/user/approval/1002"));
//		actions.andExpect(status().isOk());
//	}
}
