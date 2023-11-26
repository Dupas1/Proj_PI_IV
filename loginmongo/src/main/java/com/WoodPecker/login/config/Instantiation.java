package com.WoodPecker.login.config;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.WoodPecker.login.domain.FlashCard;
import com.WoodPecker.login.domain.User;
import com.WoodPecker.login.dto.IdUserDTO;
import com.WoodPecker.login.repository.FlashCardRepository;
import com.WoodPecker.login.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FlashCardRepository FlashCardRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		userRepository.deleteAll();
		FlashCardRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown","fem", "maria@gmail.com","senha4","phone",LocalDate.now());
		User alex = new User(null, "Alex Green","masc","alex@gmail.com","senha5","phone",LocalDate.now());
		User bob = new User(null, "Bob Grey","24","bob@gmail.com","senha6","phone",LocalDate.now());
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		FlashCard flashcard1 = new FlashCard(null,"Qual é o seu nome ?",null,"Pessoal",null,sdf.parse("21/11/2023"),1,new IdUserDTO(maria));
		FlashCard flashcard2 = new FlashCard(null,"Qual é o nome da sua mãe ?",null,"Pessoal",null,sdf.parse("20/11/2023"),1,new IdUserDTO(alex));
		
		FlashCardRepository.saveAll(Arrays.asList(flashcard1,flashcard2));
		
	}

}
