package com.ticketpedia.usermanagement.authorization;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class AuthConfiguration extends WebSecurityConfigurerAdapter {
	// Authentication
	// Creating users from database

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsService);

	}
}
