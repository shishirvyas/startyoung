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
import com.startyounguk.startyoungngo.dao.VolunteerDetails;
import com.startyounguk.startyoungngo.modle.EmailSubscription;
import com.startyounguk.startyoungngo.modle.SignUpDetails;
import com.startyounguk.startyoungngo.modle.Status;
import com.startyounguk.startyoungngo.service.AuthenticationService;
import com.startyounguk.startyoungngo.service.EmailSubscriptionService;
import com.startyounguk.startyoungngo.service.RegisterVolunteerService;
import com.startyounguk.startyoungngo.service.SignUpService;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class StartYoungController {
	
	@Autowired
	private AuthenticationService  authenticationService;
	@Autowired
	private SignUpService signUpService;
	@Autowired
	RegisterVolunteerService registerVolunteerService;
	@Autowired
	EmailSubscriptionService emailSubscriptionService;
	
//	@GetMapping("/login")
//	public boolean login(final @RequestParam Map<String, String> params) {
//		
//		return authenticationService.isLoginValid(params.get("mobile"), params.get("password"));
//		
//	}
	
	
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
	public Status registerVolunteer(final @RequestBody VolunteerDetails volunteerDetails) {
		
		if(volunteerDetails.getMobileNumber().length()!=10) {
			System.out.println("Enter valid 10 digit mobile number");
			return Status.FAILED;
		}else {
			Optional<VolunteerDetails> userOptional= registerVolunteerService.findUserByMobile(volunteerDetails);
			
			if(userOptional.isPresent()) {
				System.out.println("User Already Exists");
				return Status.ALREADY_EXISTS;
			}else {
				registerVolunteerService.saveVolunteer(volunteerDetails);
				return Status.CREATED;
			}
				
		}
	}
	
	@PostMapping("/subscribeemail")
	public Status subscribeForEmail(final@RequestBody EmailSubscription emailSubscription) {
		
		emailSubscriptionService.saveEmail(emailSubscription);
		
		return Status.CREATED;
	}
	

}
