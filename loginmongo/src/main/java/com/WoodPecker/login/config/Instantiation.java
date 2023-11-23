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
		
		User maria = new User(null, "Maria Brown","fem", "maria@gmail.com","senha4","phone",null);
		User alex = new User(null, "Alex Green","masc","alex@gmail.com","senha5","phone",null);
		User bob = new User(null, "Bob Grey","24","bob@gmail.com","senha6","phone",null);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
	}

}
