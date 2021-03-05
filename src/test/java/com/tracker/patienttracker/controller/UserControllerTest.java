package com.tracker.patienttracker.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
		
	@Test
	@Order(1)
	@WithMockUser(authorities = "ROLE_ADMIN")
	void testGetApproval() throws Exception {
		Mockito.when(userService.userApproval(1002)).thenReturn("good");
		mockMvc.perform(MockMvcRequestBuilders.patch("/user/approval/{userId}",1002)
				.param("isComplete", "true")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
}
	@Test
	@Order(2)
	@WithMockUser(authorities = "ROLE_ADMIN")
	void testGetDenial() throws Exception {
		Mockito.when(userService.userDenial(1002)).thenReturn("good");
		mockMvc.perform(MockMvcRequestBuilders.patch("/user/denial/{userId}",1002)
				.param("isComplete", "true")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
}
}


