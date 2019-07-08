package com.example.demo.repo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	public boolean addNewUser(User user) {
		if(user != null) {
			User uTemp = userRepo.findByEmail(user.getEmail());
			if(uTemp == null) {
				userRepo.save(user);
				return true;
			}
		}
		return false;
	}

}
