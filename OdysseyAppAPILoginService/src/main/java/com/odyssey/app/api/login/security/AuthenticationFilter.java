package com.odyssey.app.api.login.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.odyssey.app.api.login.ui.model.LoginRequestModel;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private Environment environment;
	
	public AuthenticationFilter(Environment environment) {
		this.environment = environment;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {

			LoginRequestModel creds = new ObjectMapper().readValue(req.getInputStream(), LoginRequestModel.class);

			Authentication authentication = new CustomAuthentication(creds.getUsername(), creds.getPassword());
			if(!creds.getUsername().equals(creds.getPassword())) {
				throw new CustomAuthenticationException("Login not successful");
			}
			authentication.setAuthenticated(true);
			return authentication;

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String userName = auth.getName();
		String prefix = environment.getProperty("authorization.secret.prefix");
		res.addHeader(environment.getProperty("authorization.token.header.name"), prefix + "#" + userName);
	}
}
