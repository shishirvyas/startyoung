package com.startyounguk.startyoungngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startyounguk.startyoungngo.service.AuthenticationService;

@RestController
@RequestMapping("/api")
public class StartYoungController {
	
	@Autowired
	private AuthenticationService  authenticationService;
	
	@GetMapping("/login")
	public boolean login() {
		
		return authenticationService.isLoginValid("shishir", "shishir");
		
	}
	
	
	

}
