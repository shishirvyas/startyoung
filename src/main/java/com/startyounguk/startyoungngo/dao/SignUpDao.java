package com.startyounguk.startyoungngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startyounguk.startyoungngo.modle.SignUpDetails;

@Repository
public interface SignUpDao extends JpaRepository<SignUpDetails, String> {
	

}
