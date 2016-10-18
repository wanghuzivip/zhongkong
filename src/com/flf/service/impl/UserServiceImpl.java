package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Limit;
import com.flf.entity.User;
import com.flf.mapper.UserMapper;
import com.flf.service.UserService;

public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(userId);
	}

	public boolean insertUser(User user) {
		try {
			userMapper.insertUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
		return true;
	}


	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			userMapper.updateUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}	
		return true;
	
	}

	
	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public boolean deleteUser(int userId){
		try {
			userMapper.deleteUser(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<User> listAllUserByLmit(Limit limit) {
		// TODO Auto-generated method stub
		return userMapper.listAllUserByLmit(limit);
	}

	@Override
	public List<User> getUserInfo(User user) {
		// TODO Auto-generated method stub
		return userMapper.getUserInfo(user);
	}

	@Override
	public int getCount(User user) {
		// TODO Auto-generated method stub
		return userMapper.getCount(user);
	}
	
}
