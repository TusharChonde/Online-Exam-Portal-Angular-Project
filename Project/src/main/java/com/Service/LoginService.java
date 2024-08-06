package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.LoginDao;

@Service
public class LoginService {

	
	@Autowired
	public LoginDao dao;
	
	public boolean validate(com.Entity.User user)
	{
		String dbpassword=dao.getpassword(user.getUsername());
		
		if(dbpassword.equals(user.getPassword()))
		{
			return true;
		
		}
		else {
			return false;
		}
	}
	
	
}
