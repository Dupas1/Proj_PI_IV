package com.WoodPecker.login.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.WoodPecker.login.domain.FlashCard;
import com.WoodPecker.login.services.FlashCardService;


@RestController
@RequestMapping(value="/FlashCard")
public class FlashCardResource {
	
	@Autowired
	private FlashCardService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<FlashCard> findById(@PathVariable String id){
		
		FlashCard obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
}










