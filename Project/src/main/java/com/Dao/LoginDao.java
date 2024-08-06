package com.Dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Entity.User;



@Repository
public class LoginDao {

	@Autowired
	SessionFactory factory;
	
	public String getpassword(String username)
	{
	Session session=factory.openSession();
	
	User userFromDB=session.get(User.class,username);
	
	return userFromDB.getPassword();
	}
	
}
