package com.startyounguk.startyoungngo.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.startyounguk.startyoungngo.modle.Login;

@Repository
public class LoginDaoImplementation implements LoginDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public boolean isLoginValid(String user, String password) {

		Session cuSession = entityManager.unwrap(Session.class);
		
		TypedQuery<Login> query = cuSession.createQuery( "FROM Login lo WHERE lo.username = ?0 and lo.pwd = ?1", Login.class);

		query.setParameter(0, user).setParameter(1, password);
		return !CollectionUtils.isEmpty(query.getResultList())  ;
	}
	
	

}
