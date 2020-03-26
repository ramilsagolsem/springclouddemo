package com.odyssey.app.api.login.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LoginController {
	
	@Autowired
	private Environment environment;

	@GetMapping("/status/check")
	public String status() {
		return "Running on port: "+environment.getProperty("local.server.port") +" with test data :"+environment.getProperty("config.test.value");
	}
}
