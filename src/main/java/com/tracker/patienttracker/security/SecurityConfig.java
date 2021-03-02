package com.tracker.patienttracker.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tracker.patienttracker.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
	CustomUserDetailsService userDetailsService;


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.cors();
		http.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/billing/**").hasAnyAuthority("ROLE_ADMIN","ROLE_CLERK")
		.antMatchers("/inpatientrecord/**").hasAnyAuthority("ROLE_ADMIN","ROLE_CLERK")
		.antMatchers("/testreport/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/patient/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/treatment/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/patient/details").hasAnyAuthority("ROLE_PATIENT","ROLE_CLERK")
		.antMatchers("/patientrecord/**").hasAnyAuthority("ROLE_DOCTOR")
		.antMatchers("/users/help").hasAnyAuthority("ROLE_ADMIN","ROLE_DOCTOR","ROLE_PATIENT","ROLE_CLERK")
		.antMatchers("/users/login").permitAll()
		.antMatchers("/users/registration").permitAll()
		.antMatchers("/doctors/**").permitAll()
		.anyRequest().authenticated();
		
		 http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
	}
	
	  @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Bean
	    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
	        return new JwtAuthenticationFilter();
	    }
	
	
}
