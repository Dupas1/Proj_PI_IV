package com.WoodPecker.login.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WoodPecker.login.domain.FlashCard;
import com.WoodPecker.login.repository.FlashCardRepository;
import com.WoodPecker.login.services.exception.ObjectNotFoundException;

@Service
public class FlashCardService {
	
	@Autowired
	private FlashCardRepository repo;
	
	
	public FlashCard findById(String id) {
		Optional<FlashCard> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	

}
