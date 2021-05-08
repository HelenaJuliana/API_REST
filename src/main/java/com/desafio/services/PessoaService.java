package com.desafio.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.Pessoa;
import com.desafio.repository.PessoaRepository;
import java.util.Optional;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repo;
	
	public List<Pessoa> findALL(){
		
		return repo.findAll();
	}
	
	public Optional findById(String id) throws Exception {
		Optional pessoa = repo.findById(id);
		if (pessoa == null) {
		throw new Exception("Objeto não encontrado");
		}
		return pessoa;
		}
		
		
	}
	


