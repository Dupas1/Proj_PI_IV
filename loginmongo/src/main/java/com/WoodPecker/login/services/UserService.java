package com.WoodPecker.login.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WoodPecker.login.domain.User;
import com.WoodPecker.login.dto.UserDTO;
import com.WoodPecker.login.repository.UserRepository;
import com.WoodPecker.login.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	

	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User( objDto.getId(), objDto.getName(),objDto.getGender(), objDto.getEmail(), objDto.getPsw(), objDto.getPhone(), objDto.getEntryDate());
	}


}
