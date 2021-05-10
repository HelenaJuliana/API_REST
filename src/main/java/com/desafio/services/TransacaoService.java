package com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.ContaBancaria;
import com.desafio.domain.Transacao;
import com.desafio.repository.TransacaoRepository;



@Service
public class TransacaoService {
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public Transacao salvar(Transacao trans) {
		return transacaoRepository.save(trans);
	}
	
	public List<Transacao> listar() {
		return transacaoRepository.findAll();
	}
	
	public void delete(Long id) {
		transacaoRepository.deleteById(id);
	}
	
	public void buscarPeloId(Long id) {
		transacaoRepository.findById(id);
	}
	public List<Transacao> buscarContas(ContaBancaria conta) {
		return transacaoRepository.findByContaIn(conta);
	}
}
