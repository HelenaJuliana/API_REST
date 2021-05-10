package com.desafio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.domain.Pessoa;
import com.desafio.repository.PessoaRepository;

public class PessoaRepositoryTest {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	private static final String cpf = "12345678912";
	private static final String cpfInvalido = "1234567";
	
	
	@Before
	public void setUp() throws Exception {
		Pessoa pessoa =  new Pessoa();
		pessoa.setNome("Helena Barros ");
		pessoa.setCPF(cpf);
		this.pessoaRepository.save(pessoa);
	}
	
	@Test
	public void testBuscarPorCpfValido() {
		Pessoa pessoa = this.pessoaRepository.findAllById(cpfInvalido);
		assertEquals(cpf, pessoa.getCPF());
	}
	@Test
	public void testBuscarPorCpfInvalido() {
		Pessoa pessoa = this.pessoaRepository.findAllById(cpfInvalido);
		assertNotEquals(cpfInvalido, pessoa);
	}
	
	@After
	public final void tearDown() {
		this.pessoaRepository.deleteAll();
	}


}
