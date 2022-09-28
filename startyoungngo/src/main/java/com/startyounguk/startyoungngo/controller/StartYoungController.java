package com.startyounguk.startyoungngo.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.startyounguk.startyoungngo.modle.SignUpDetails;
import com.startyounguk.startyoungngo.modle.Status;

import com.startyounguk.startyoungngo.modle.Volenteer;

import com.startyounguk.startyoungngo.service.AuthenticationService;
import com.startyounguk.startyoungngo.service.SignUpService;

import com.startyounguk.startyoungngo.service.VolunteerService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StartYoungController {
	
	@Autowired
	private AuthenticationService  authenticationService;
	@Autowired
	private SignUpService signUpService;
	

	@Autowired
	private VolunteerService volunteerService;

	
	@GetMapping("/loginUser")
	public boolean isUserPresent(final @RequestParam Map<String, String> params) {
	
		return	signUpService.validateLogin(params.get("mobile"),params.get("password"));
	}
	
	@PostMapping("/signup")
	public com.startyounguk.startyoungngo.modle.Status signUp(final @RequestBody SignUpDetails userDetails) {
		if(userDetails.getMobileNumber().length()!=10) {
			System.out.println("Enter valid 10 digit mobile number");
			return Status.FAILED;
		}else {
			Optional<SignUpDetails> userOptional= signUpService.findUserByMobile(userDetails);
			
			if(userOptional.isPresent()) {
				System.out.println("User Already Exists");
				return Status.ALREADY_EXISTS;
			}else {
				signUpService.saveNewUser(userDetails);
				return Status.CREATED;
			}
				
		}

	}
	
	@PostMapping("/regvolunteer")
	public com.startyounguk.startyoungngo.modle.Status registerVolunteer(final @RequestBody Volenteer volenteer) {
		
			Optional<Volenteer> volDetaild= volunteerService.findVolunteerByEmail(volenteer);
			
			if(volDetaild.isPresent()) {
				System.out.println("You are Already Registered");
				return Status.ALREADY_EXISTS;
			}else {
				volunteerService.saveVolenteer(volenteer);
				return Status.CREATED;
			}
				
		
		

	}
}
