package com.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.domain.ContaBancaria;
import com.desafio.domain.Transacao;
import com.desafio.repository.ContaRepository;
import com.desafio.services.exception.ObjectNotFoundException;


@Service
public class ContaService {
	

	@Autowired
	private TransacaoService transService;

	@Autowired
	private static ContaRepository<?> repo;
	
	public List<ContaBancaria> findALL(){
		
		return repo.findAll();
	}
	
	public ContaBancaria findById(Long id)  {
		ContaBancaria conta = repo.findByIdConta(id);
		if (conta == null) {
		throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return conta;
		}
		
	public  ContaBancaria insert(ContaBancaria obj) {
		return (ContaBancaria) repo.insert(obj);
		
	}
	

	public void deposita(double valor, Long idConta) {
		repo.setFixedSaldoFor(valor, idConta);
	}

	public void sacar(double valor, Long idConta) {
		repo.setFixedSaldo(valor, idConta);
	}

	public ContaBancaria buscarSado(Long idConta) {
		return repo.findByIdConta(idConta);
	}

	public List<ContaBancaria> listar() {
		return repo.findAll();
	}

	public static ContaBancaria verificarConta(Long idConta) {
		return repo.findByIdConta(idConta);
	}
	

	public List<Transacao> extratoConta(Long id) {
		ContaBancaria c = verificarConta(id);
		return transService.buscarContas(c);
		
    }

	public ContaBancaria salvar(ContaBancaria conta) {
		return repo.save(conta);
	}
	
}
