package com.desafio.dto;

import java.io.Serializable;

import com.desafio.domain.Pessoa;

public class PessoaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String id;
	String nome;
	String cpf;
	
	public PessoaDTO() {
		
	}
	public PessoaDTO(Pessoa obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCPF();
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
