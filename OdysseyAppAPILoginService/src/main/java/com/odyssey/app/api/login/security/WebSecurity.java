package com.odyssey.app.api.login.security;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{

private static final Logger logger = Logger.getLogger(WebSecurity.class.getName());
	
	@Autowired
	private Environment environment;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/user/**").permitAll()
		.and()
		.addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();
	}
	
	private AuthenticationFilter getAuthenticationFilter() throws Exception
	{
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(environment);
		String path = environment.getProperty("login.url.path");
		logger.info("login.url.path: "+path);
		authenticationFilter.setFilterProcessesUrl(path);
		return authenticationFilter;
	}
}
