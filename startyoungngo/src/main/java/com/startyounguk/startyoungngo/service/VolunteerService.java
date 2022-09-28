package com.startyounguk.startyoungngo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startyounguk.startyoungngo.dao.SignUpDao;
import com.startyounguk.startyoungngo.dao.VolenteerDao;
import com.startyounguk.startyoungngo.modle.SignUpDetails;
import com.startyounguk.startyoungngo.modle.Volenteer;

@Service
public class VolunteerService {

	@Autowired
	private VolenteerDao volenteerDao;
	
		
	public Optional<Volenteer> findVolunteerByEmail(Volenteer volenteer) {
		return volenteerDao.findById(volenteer.getEmail());
		
	}

	public Optional<Volenteer> saveVolenteer(Volenteer volenteer) {
		// TODO Auto-generated method stub
		try {
			volenteerDao.save(volenteer);
			return Optional.ofNullable(volenteer);
				
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error creating new user"+ e.getMessage());
			return null;
		}
	
	}


}
