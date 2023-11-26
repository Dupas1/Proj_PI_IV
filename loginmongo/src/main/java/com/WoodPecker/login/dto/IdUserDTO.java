package com.WoodPecker.login.dto;

import java.io.Serializable;

import com.WoodPecker.login.domain.User;

public class IdUserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;

	
	public IdUserDTO() {}
	
	public IdUserDTO(User obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
