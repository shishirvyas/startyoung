package com.startyounguk.startyoungngo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startyounguk.startyoungngo.modle.Volenteer;

@Repository
public interface VolenteerDao extends JpaRepository<Volenteer, String>{


}
