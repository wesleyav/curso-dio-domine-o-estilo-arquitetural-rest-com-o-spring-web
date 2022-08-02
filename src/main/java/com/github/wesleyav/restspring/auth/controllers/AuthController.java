package com.github.wesleyav.restspring.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.wesleyav.restspring.auth.services.UserService;
import com.github.wesleyav.restspring.config.jwt.JwtRequest;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody JwtRequest request) {
		return userService.signin(request);
	}

}
