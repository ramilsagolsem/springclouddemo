package com.odyssey.app.api.login.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthentication implements Authentication{
	
	private static final long serialVersionUID = 5419974163925133022L;
	/**
	 * 
	 */

	private String name;
	private String password;
	private boolean authenticated;
	
	public CustomAuthentication(String name, String password) {
		this.name = name;
		this.password = password;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public Object getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAuthenticated() {
		// TODO Auto-generated method stub
		return authenticated;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		authenticated = isAuthenticated;
		
	}

}
