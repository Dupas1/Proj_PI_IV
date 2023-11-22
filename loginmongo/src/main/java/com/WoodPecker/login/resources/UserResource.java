package com.WoodPecker.login.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WoodPecker.login.domain.User;


@RestController
@RequestMapping(value="/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria = new User("1", "Maria Silva", "20", "48095188560", "maria@gmail.com", "102030");
		User alex = new User("2", "Alex Green", "26", "48054840218", "alex@gmail.com", "302010");
	
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		
		return ResponseEntity.ok().body(list);
	}
}
