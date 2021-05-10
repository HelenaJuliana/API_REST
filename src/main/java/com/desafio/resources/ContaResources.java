package com.desafio.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.ContaBancaria;
import com.desafio.domain.Transacao;
import com.desafio.services.ContaService;

@Controller
@RequestMapping(value = "/contas")
public class ContaResources {

	@Autowired
	private ContaService contaService;
	private String cpf;
	private double saldo;
	private String nomeCompleto;

	// salva uma conta
	@RequestMapping(method = RequestMethod.POST, path = "salvar")
	public ResponseEntity<?> salvar(@RequestBody @Valid ContaBancaria conta) {

		ContaBancaria c = (ContaBancaria) this.contaService.salvar(conta);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	// realiza um deposito em uma determinada conta
	@RequestMapping(method = RequestMethod.PUT, path = "depositar/{valor}/{id}")
	public ResponseEntity<?> depositar(@PathVariable double valor, @PathVariable Long id) {

		this.contaService.deposita(valor, id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	 private boolean valorLimiteDeposito(BigDecimal valor) {
		    return valor.compareTo(new BigDecimal("0")) > 0 && valor.compareTo(new BigDecimal("2000")) <= 0;
}

	
	
	// verifica se a conta existe pelo flag
	@RequestMapping(method = RequestMethod.GET, path = "buscarConta/{id}")
	public ResponseEntity<?> verificarContaAtiva(@PathVariable Long idConta) {

		ContaBancaria contaBancaria = ContaService.verificarConta(idConta);
		if (contaBancaria.isFlagAtivo() == false)
			
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(contaBancaria.getPessoa(), HttpStatus.OK);
	}

}
