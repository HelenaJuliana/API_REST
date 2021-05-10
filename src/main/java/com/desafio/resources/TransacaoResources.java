package com.desafio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Transacao;
import com.desafio.services.TransacaoService;


@Controller
@RestController
@RequestMapping(value= "/transacao")
public class TransacaoResources {
	
	
	@Autowired
	private TransacaoService transacaoService;

	
	@RequestMapping(method=RequestMethod.POST, path="salvar" )
	public ResponseEntity<?> depositar(@RequestBody Transacao trans){
		
		Transacao transacao = this.transacaoService.salvar(trans);
		return new ResponseEntity<>(transacao, HttpStatus.OK);
	}
	

	@RequestMapping(method=RequestMethod.DELETE, path="deletar/{id}" )
	public ResponseEntity<?> saldo( @PathVariable Long id){
		
		 this.transacaoService.delete(id);
		
		return new ResponseEntity<>( HttpStatus.OK); 
	}
	
	
	@RequestMapping(method=RequestMethod.GET, path="listar" )
	public ResponseEntity<?> listar(){
		
		 List<Transacao> transacoes = this.transacaoService.listar();
		return new ResponseEntity<>(transacoes, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, path="buscar/{id}"  )
	public ResponseEntity<?> lisbuscarPorId(@PathVariable Long id){
		transacaoService.buscarPeloId(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
