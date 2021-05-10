package com.desafio.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.desafio.domain.Pessoa;

@Repository
public interface PessoaRepository<T> extends MongoRepository<Pessoa, String> {

	Pessoa findAllById(String id);

	

}
