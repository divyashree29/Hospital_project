package com.ty.hospital.service;

import java.util.List;

import com.ty.hospital.dto.User;

public interface UserService {
	
	public User saveUser(User user); 
	public User updateUser(int user_id,User user);
	public boolean deleteUser(int user_id);
	public User getUserById(int id);
	public User getUserByRole(String role);
	public User getUserByPhone(long phone);
	public User validateUser(String email,String password);
    public List<User> getAllUsers();
	
}
