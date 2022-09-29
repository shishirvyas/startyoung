package com.startyounguk.startyoungngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startyounguk.startyoungngo.dao.EmailSubscriptionDAO;
import com.startyounguk.startyoungngo.modle.EmailSubscription;

@Service
public class EmailSubscriptionService {
	
	@Autowired
	EmailSubscriptionDAO emailSubscriptionDAO;
	
	
	public void saveEmail(EmailSubscription emailSubscription) {
		emailSubscriptionDAO.save(emailSubscription);
	}

}
