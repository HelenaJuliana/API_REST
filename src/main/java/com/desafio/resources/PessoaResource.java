package com.desafio.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.domain.Pessoa;
import com.desafio.dto.PessoaDTO;
import com.desafio.services.PessoaService;


@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findALL(){
		
		List<Pessoa> list = service.findALL();
		List<PessoaDTO> listDto = list.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<PessoaDTO> findById(@PathVariable String id) {
		
		Pessoa obj = service.findById(id);
		return ResponseEntity.ok().body(new PessoaDTO(obj));			
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PessoaDTO objDto){
		Pessoa obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
	    return ResponseEntity.created(uri).build();
		
	}
	
	
	
	

}
