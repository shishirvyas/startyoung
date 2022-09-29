package com.startyounguk.startyoungngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startyounguk.startyoungngo.dao.SignUpDao;
import com.startyounguk.startyoungngo.modle.SignUpDetails;

@Service
public class SignUpService {

	@Autowired
	private SignUpDao signUpDao;
	
		
	public Optional<SignUpDetails> findUserByMobile(SignUpDetails signUpDetails) {
		return signUpDao.findById(signUpDetails.getMobileNumber());
		
	}

	public Optional<SignUpDetails> saveNewUser(SignUpDetails signUpDetails) {
		// TODO Auto-generated method stub
		try {
			signUpDao.save(signUpDetails);
			return Optional.ofNullable(signUpDetails);
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error creating new user"+ e.getMessage());
			return null;
		}
	
	}

	public boolean validateLogin(String mobile, String password) {
		// TODO Auto-generated method stub
		Optional<SignUpDetails> userDetails = signUpDao.findById(mobile);
		if(userDetails.isPresent()) {
			if(userDetails.get().getPassword().equals(password)) {
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
}
