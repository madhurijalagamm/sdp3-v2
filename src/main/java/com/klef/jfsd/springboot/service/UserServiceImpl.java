package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userrepo;
	
	@Override
	public User checkuserlogin(String email, String password) {
		return userrepo.checkuserlogin(email, password);
	}

	@Override
	public String adduser(User u) {
		userrepo.save(u);
		return "Employee Added Successfully";
	}
	
}
