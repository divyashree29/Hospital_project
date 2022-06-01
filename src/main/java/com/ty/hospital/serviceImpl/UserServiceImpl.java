package com.ty.hospital.serviceImpl;

import java.util.List;

import com.ty.hospital.dao.impl.UserDaoImpl;
import com.ty.hospital.dto.User;
import com.ty.hospital.service.UserService;

public class UserServiceImpl implements UserService {

	public User saveUser(User user) {
		return UserDaoImpl.saveUser(user);
		
	}

	public User updateUser(int user_id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getUserByPhone(long phone) {
		// TODO Auto-generated method stub
		return null;
	}

	public User validateUser(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
