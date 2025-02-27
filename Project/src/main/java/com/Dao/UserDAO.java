package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.Entity.User;

@Repository
public class UserDAO 
{
	@Autowired
	SessionFactory factory;
	
	public List<User> getAllUsers()
	{
		
		Session session=factory.openSession();
		
		Query query=session.createQuery("from User");
		
		return query.list();
		
	}
	
	
	public User getUser(String username)
	{

		Session session=factory.openSession();
		
		Query<User> query=session.createQuery("from User where username=:username");
		
		query.setParameter("username",username);
		
		return query.list().get(0);
		
	}

	
	public  void deleteUser(String username)
	{

		Session session=factory.openSession();
		
		Query<User> query=session.createQuery("delete from User where username=:username");
		
		query.setParameter("username",username);
		
		Transaction tx=session.beginTransaction();
		
			query.executeUpdate();
		
		tx.commit();
		
		
	}


	public void saveUser(User user) {
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
		
				session.save(user);
				
		tx.commit();
				
		
	}
	
	
	
}
