package com.desafio.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Pessoa;
import com.desafio.dto.PessoaDTO;
import com.desafio.repository.PessoaRepository;
import com.desafio.services.exception.ObjectNotFoundException;

import java.util.Optional;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public List<Pessoa> findALL(){
		
		return repo.findAll();
	}
	
	public Pessoa findById(String id)  {
		Pessoa pessoa = repo.findAllById(id);
		if (pessoa == null) {
		throw new ObjectNotFoundException("");
		}
		return pessoa;
		}
		
	public Pessoa insert(Pessoa obj) {
		return (Pessoa) repo.insert(obj);
		
	}
	
	public Pessoa fromDTO(PessoaDTO objDto) {
		return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getCpf());
		
	}
		
	
}
	


