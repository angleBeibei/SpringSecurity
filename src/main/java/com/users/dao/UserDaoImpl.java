package com.users.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.users.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	@Inject
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public Session currentSession(){
		return sessionFactory.openSession();
	}
	
	public User findByUserName(String username){
		return (User)currentSession().createCriteria(User.class).add(Restrictions.eq("username",username)).list().get(0);
	}
}
