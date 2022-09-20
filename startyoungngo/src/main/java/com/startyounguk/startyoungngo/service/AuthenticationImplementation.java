package com.startyounguk.startyoungngo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startyounguk.startyoungngo.dao.LoginDao;

@Service
public class AuthenticationImplementation implements AuthenticationService {
 
	@Autowired 
	private LoginDao loginDao;
	
	@Transactional
	@Override
	public boolean isLoginValid(String user, String password) {
		// TODO Auto-generated method stub
		return loginDao.isLoginValid(user, password);
	}

}
