package com.users.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.users.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory;
	private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	@Inject
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	public Session currentSession(){
		return sessionFactory.openSession();
	}
	
	public User findByUserName(String username){
		List<User> userList=(List<User>)currentSession().createCriteria(User.class).add(Restrictions.eq("username",username)).list();
		if(userList.isEmpty())
		{
			return null;
		}else{
			return userList.get(0);
		}
		
	}
	
	public void save(User user){
		System.out.println(user.getPassword());
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		//user.setUserRole(userRole);
		Session session=this.currentSession();
		Transaction tx=null;
		try{
			tx=session.beginTransaction();
			session.save(user);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
