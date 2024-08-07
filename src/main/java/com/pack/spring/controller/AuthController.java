package com.pack.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.spring.dto.RequestResponse;
import com.pack.spring.utils.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<RequestResponse> signUp(@RequestBody RequestResponse signUpRequest) {
		return ResponseEntity.ok(authService.signUp(signUpRequest));
	}

	@PostMapping("/signin")
	public ResponseEntity<RequestResponse> signIn(@RequestBody RequestResponse signInRequest) {
		return ResponseEntity.ok(authService.signIn(signInRequest));
	}

	@PostMapping("/refresh")
	public ResponseEntity<RequestResponse> refreshToken(@RequestBody RequestResponse refreshTokenRequest) {
		return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
	}
}
