package com.WoodPecker.login.dto;

import java.io.Serializable;
import java.time.LocalDate;



import com.WoodPecker.login.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String gender;
	private String email;
	private String psw;
	private String phone;
	private LocalDate entryDate = LocalDate.now();
	
	public UserDTO() {}
	
	
	
	public UserDTO(User x) {
		id = x.getId();
		name = x.getName();
		gender = x.getGender();
		email = x.getEmail();
		psw = x.getPsw();
		phone = x.getPhone();
		entryDate = x.getEntryDate();
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
