package com.startyounguk.startyoungngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterVolunteerInterface extends JpaRepository<VolunteerDetails, String>{
	

}
