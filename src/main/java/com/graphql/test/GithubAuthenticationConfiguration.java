package com.graphql.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class GithubAuthenticationConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests(
				a -> a.antMatchers("/", "/vendor/**").permitAll().anyRequest().authenticated())
				.oauth2Login();
		
		
	}

}
