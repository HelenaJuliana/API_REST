package com.desafio.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.domain.Pessoa;

@RestController
@RequestMapping(value="/pessoas")
public class PessoaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Pessoa>> findALL(){
		
		Pessoa maria = new Pessoa("1","Maria Barros", "10243093570");
		Pessoa pedro = new Pessoa("2","Pedro Silva", "12345678910");
		
		List<Pessoa> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, pedro));
		return ResponseEntity.ok().body(list);
		
	}

}
