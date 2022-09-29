package com.startyounguk.startyoungngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startyounguk.startyoungngo.modle.EmailSubscription;

@Repository
public interface EmailSubscriptionDAO extends JpaRepository<EmailSubscription, Integer>{

	
}
