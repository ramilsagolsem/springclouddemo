package com.odyssey.app.api.login.ui.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class LoginController {

	@GetMapping("/status/check")
	public String status() {
		return "Welcome";
	}
}
