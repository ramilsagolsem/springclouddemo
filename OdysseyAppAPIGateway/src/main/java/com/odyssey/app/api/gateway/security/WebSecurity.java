package com.odyssey.app.api.gateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private Environment environment;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.authorizeRequests()
		.antMatchers(environment.getProperty("api.gateway.actuator.url.path")).permitAll()
		.anyRequest().authenticated()
		.and()
    	.addFilter(new AuthorizationFilter(authenticationManager(), environment));;
		
    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
