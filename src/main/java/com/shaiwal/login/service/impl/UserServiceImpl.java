package com.shaiwal.login.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shaiwal.login.model.Role;
import com.shaiwal.login.model.User;
import com.shaiwal.login.repository.RoleRepository;
import com.shaiwal.login.repository.UserRepository;
import com.shaiwal.login.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private RoleRepository roleRespository;
	 
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;

	 @Override
	 public User findUserByEmail(String email) {
	  return userRepository.findByEmail(email);
	 }

	 @Override
	 public void saveUser(User user) {
	  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	  user.setStatus("active");
	 // Role userRole = roleRespository.findById(2);
	  user.setRoleid(3);
	  userRepository.save(user);
	 }

	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email);
	        System.out.println(user);
	        if (user == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(),
	            user.getPassword(),
	            mapRolesToAuthorities(user.getRoleid()));
	    }

	    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(int roleId) {
	    	Role role = roleRespository.findById(roleId);
	    	List<Role> roleList = new ArrayList<Role>();
	    	roleList.add(role);
	    	System.out.println(roleList);
	        return roleList.stream()
	            .map(rol -> new SimpleGrantedAuthority(((Role) rol).getRolename()))
	            .collect(Collectors.toList());
	    }

}
