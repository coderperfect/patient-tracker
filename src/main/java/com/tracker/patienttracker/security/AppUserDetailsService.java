package com.tracker.patienttracker.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tracker.patienttracker.model.User;
import com.tracker.patienttracker.repository.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetails LoadUserByUsername method called in AppUserDeatilsService Class ");
		Optional<User> user= userRepository.findById(Integer.parseInt(username));	
		if(!user.isPresent())
			throw new UsernameNotFoundException("User Not Found");
		System.out.println(user);
		return new AppUser(user.get());
	}
	
	

}
