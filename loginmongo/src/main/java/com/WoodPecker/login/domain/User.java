package com.WoodPecker.login.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String gender;
	private String email;
	private String psw;
	private String phone;
	private String entryDate;
	
	public User() {}


	public User(String id, String name, String gender, String email, String psw, String phone, String entryDate) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.psw = psw;
		this.phone = phone;
		this.entryDate = entryDate;
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


	public String getEntryDate() {
		return entryDate;
	}


	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
}
