package com.desafio.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.domain.ContaBancaria;
import com.desafio.domain.Transacao;

@Repository
@Transactional(readOnly = false)
public interface TransacaoRepository extends MongoRepository<Transacao, Long> {
	List<Transacao> findByContaIn(ContaBancaria conta);
			
	
}
