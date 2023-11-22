package com.WoodPecker.login.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.WoodPecker.login.domain.User;
import com.WoodPecker.login.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown","20","CPF", "maria@gmail.com","senha4");
		User alex = new User(null, "Alex Green","22","CPF","alex@gmail.com","senha5");
		User bob = new User(null, "Bob Grey","24","CPF","bob@gmail.com","senha6");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
