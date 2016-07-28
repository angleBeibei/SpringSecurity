package com.users.dao;

import com.users.model.User;

public interface UserDao {
	User findByUserName(String username);
	void save(User user);
}
