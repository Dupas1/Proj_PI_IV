package com.WoodPecker.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WoodPecker.login.domain.User;
import com.WoodPecker.login.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	

	public List<User> findAll() {
		return repo.findAll();
	}

}
