package com.desafio.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.desafio.domain.Pessoa;
import com.desafio.repository.PessoaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void run(String... args) throws Exception {

		pessoaRepository.deleteAll();

		Pessoa maria = new Pessoa(null, "Maria José Da Silva", "12345678945");
		Pessoa alex = new Pessoa(null, "Alex Da Silva ", "12345678956");
		Pessoa helena = new Pessoa(null, "Helena Barrosy", "12345678912");

		pessoaRepository.saveAll(Arrays.asList(maria, alex, helena));

	}

}
