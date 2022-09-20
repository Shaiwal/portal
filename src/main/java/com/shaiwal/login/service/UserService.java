package com.shaiwal.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.shaiwal.login.model.User;

public interface UserService extends UserDetailsService{
	
	 public User findUserByEmail(String email);
	 
	 public void saveUser(User user);

}
