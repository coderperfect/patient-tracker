package com.tracker.patienttracker.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.patienttracker.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@RestController
public class AuthenticationController {

	@Autowired
	UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
		
		LOGGER.info("Authenticate Start");
		LOGGER.debug(authHeader);
		Map<String, String> m=new HashMap<String, String>();			
		LOGGER.info("Authenticate END");
		String user=getUser(authHeader);
		LOGGER.debug(user);
		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		String token=generateJwt(user);
		LOGGER.debug("Token is: "+token);
		m.put("token", token);
		LOGGER.debug("Role is: "+role);
		m.put("role", role);
		return m;
	}
	
	private String getUser(String authHeader) {
		LOGGER.info("getUser method");
		return new String(Base64.getDecoder().decode(authHeader.split(" ")[1])).split(":")[0];
	}
	
	private String generateJwt(String user) {		
		LOGGER.info("generate JWT token creation method");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");		
		String token = builder.compact();
		return token;
	}
}
