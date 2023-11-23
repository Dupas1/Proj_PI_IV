package com.WoodPecker.login.dto;

import java.io.Serializable;

import com.WoodPecker.login.domain.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String idade;
	private String cpf;
	private String email;
	private String senha;
	
	public UserDTO() {}
	
	public UserDTO(User x) {
		id = x.getId();
		nome = x.getNome();
		idade = x.getIdade();
		cpf = x.getCpf();
		email = x.getEmail();
		senha = x.getSenha();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
