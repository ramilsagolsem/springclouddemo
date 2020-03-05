package com.odyssey.app.api.login.security;

import org.springframework.security.core.AuthenticationException;

public class CustomAuthenticationException extends AuthenticationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2853739650619637306L;

	public CustomAuthenticationException(String msg) {
		super(msg);
	}
	
	public CustomAuthenticationException(String msg, Throwable ex) {
		super(msg,ex);
	}

}
