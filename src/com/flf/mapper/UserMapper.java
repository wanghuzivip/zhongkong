package com.flf.mapper;

import java.util.List;

import com.flf.entity.Limit;
import com.flf.entity.User;

public interface UserMapper  {
	List<User> listAllUserByLmit(Limit limit);
	
	User getUserById(Integer userId);
	
	void insertUser(User user);
	
	void updateUser(User user);
	
	List<User> getUserInfo(User user);
	
	void deleteUser(int userId);
	
	int getCount(User user);
}
