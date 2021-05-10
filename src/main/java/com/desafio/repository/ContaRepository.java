package com.desafio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.desafio.domain.ContaBancaria;

@Transactional(readOnly = false)
public interface ContaRepository<T> extends MongoRepository<ContaBancaria, Long> {
	
	
	@Query("update Conta c set c.saldo = c.saldo + ?1 where c.idConta = ?2")
	void setFixedSaldoFor(double  valor , Long idConta);
	
	
	ContaBancaria findByIdConta(Long idConta);
	
	
	@Query("update Conta c set c.saldo = c.saldo - ?1 where c.idConta = ?2")
	void setFixedSaldo(double  quant, Long idConta);
	


}
