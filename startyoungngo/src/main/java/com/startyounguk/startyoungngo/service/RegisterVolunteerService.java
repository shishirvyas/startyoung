package com.startyounguk.startyoungngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startyounguk.startyoungngo.dao.RegisterVolunteerInterface;
import com.startyounguk.startyoungngo.dao.VolunteerDetails;

@Service
public class RegisterVolunteerService {

	@Autowired
	private RegisterVolunteerInterface registerVolunteerInterfaceDao;
	
	public Optional<VolunteerDetails> findUserByMobile(VolunteerDetails volunteerDetails) {
		return registerVolunteerInterfaceDao.findById(volunteerDetails.getMobileNumber());
		
	}

	public Optional<VolunteerDetails> saveVolunteer(VolunteerDetails volunteerDetails) {
		// TODO Auto-generated method stub
		try {
			registerVolunteerInterfaceDao.save(volunteerDetails);
			return Optional.ofNullable(volunteerDetails);
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error creating new user"+ e.getMessage());
			return null;
		}
	
	}
}
