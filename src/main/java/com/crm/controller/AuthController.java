package com.crm.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.service.impl.AuthServiceImpl;
import com.crm.dto.LoginDto;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private AuthServiceImpl authService;
	
	public AuthController(AuthServiceImpl authService) {
		this.authService = authService;
	}

	@PostMapping("/login")
	public Object post(@Valid @RequestBody LoginDto dto) {
		try {
			String token = authService.login(dto);
			return new ResponseEntity<Object>(token, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
