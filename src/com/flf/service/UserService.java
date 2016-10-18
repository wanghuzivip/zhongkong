package com.flf.service;

import java.util.List;

import com.flf.entity.Limit;
import com.flf.entity.User;

public interface UserService {
	List<User> listAllUserByLmit(Limit limit);
	
	User getUserById(Integer userId);
	
	boolean insertUser(User user);
	
	boolean updateUser(User user);
	
	List<User> getUserInfo(User user);
	
	boolean deleteUser(int userId);
	
	int getCount(User user);
}
