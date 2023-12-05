package com.wishfy.EMS.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public static final String[] public_URL={
			"/employees/getAllEmployees",
			"/v2/api-docs",
			"/v3/api-docs",
			"/swagger-ui/**",
			"/swagger-resources/**",
			"/webjars/**"
	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf()
		.disable()
		.authorizeRequests()
		.antMatchers(public_URL).permitAll()
		.anyRequest()
		.authenticated()
		.and().httpBasic();
	}

	
}