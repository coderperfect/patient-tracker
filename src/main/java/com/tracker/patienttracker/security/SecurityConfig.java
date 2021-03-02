package com.tracker.patienttracker.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		super.configure(auth);
		LOGGER.info("Start of configure(AuthenticationManagerBuilder auth) ");
		auth.userDetailsService(customerDetailsService);
		LOGGER.info("End of configure(AuthenticationManagerBuilder auth) ");
	}

	/*
	 * @Bean public PasswordEncoder passwordEncoder() {
	 * LOGGER.info("Start and End of PasswordEncoder"); return new
	 * BCryptPasswordEncoder(); }
	 */
//	 @Bean
//	public PasswordEncoder noOppasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		LOGGER.info("Start of Configure method in Security Config class");
//		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated()
//		.and().exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors();
		http.csrf().disable().httpBasic().and().authorizeRequests()			
		.antMatchers("/login").permitAll()
		.antMatchers("/registration").permitAll()
		.antMatchers("/authenticate").hasAnyRole("DOCTOR","PATIENT","CLERK","ADMIN")
		.antMatchers("/help").hasAuthority("DOCTOR")		
		.anyRequest().authenticated();
		LOGGER.info("End of Configure method in Security Config class");
	}
	
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//	}
	
	
}
