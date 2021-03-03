package com.tracker.patienttracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.error.UnauthorizedException;
import com.tracker.patienttracker.model.AuthResponse;
import com.tracker.patienttracker.model.UserData;
import com.tracker.patienttracker.repository.UserRepository;
import com.tracker.patienttracker.security.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
	@Autowired
	private UserRepository userdao;
	@Autowired
	private JwtUtil jwtutil;

	@Override
	public UserDetails loadUserByUsername(String uid) {
		Optional<com.tracker.patienttracker.model.User> userData = userdao.findById(Integer.parseInt(uid));
		if (!userData.isPresent()) {
			log.error("Unauthorized exception");
			throw new UnauthorizedException("unauthorized");
		}
		com.tracker.patienttracker.model.User user = userData.get();
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(user.getRole()));
		System.out.println(roles);
		return new User(String.valueOf(user.getUserId()), user.getPassword(),roles);
	}

	@Override
	public UserData login(UserData userlogincredentials) {
		final UserDetails userdetails = loadUserByUsername(String.valueOf(userlogincredentials.getUserId()));
		int uid=0;
		String generateToken = "";
		if (userdetails.getPassword().equals(userlogincredentials.getPassword())) {
			uid = userlogincredentials.getUserId();
			Optional<com.tracker.patienttracker.model.User> opuser = userdao.findById(uid);
			if(!opuser.isPresent())
			{
				throw new UsernameNotFoundException("Not Approved");
			}
			com.tracker.patienttracker.model.User user = opuser.get();
			if(user.getApproved()<1) {
				throw new InvalidDataAccessApiUsageException("Invalid User");
			}
			String role = userdetails.getAuthorities().toArray()[0].toString();
			generateToken = jwtutil.generateToken(userdetails,role);
			return new UserData(uid, null, generateToken, role);
		} else {
			log.error("Unauthorized exception");
			throw new UnauthorizedException("Unauthorized");
		}
	}

	@Override
	public AuthResponse getValidity(String token) {
		AuthResponse res = new AuthResponse();
		if (jwtutil.validateToken(token)) {
			res.setUid(jwtutil.extractUsername(token));
			res.setValid(true);
//			res.setName(userdao.findById(Integer.parseInt(jwtutil.extractUsername(token))).get().getUname());
			res.setRole(userdao.findById(Integer.parseInt(jwtutil.extractUsername(token))).get().getRole());
		} else {
			res.setValid(false);
			log.info("At Validity : ");
			log.error("Token Has Expired");
		}
		return res;
	}

	

}
