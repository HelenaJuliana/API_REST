package com.desafio.dto;

import java.util.Date;
import java.util.List;

import com.desafio.domain.ContaBancaria;
import com.desafio.domain.Pessoa;
import com.desafio.domain.Transacao;

public class ContaDTO {

	private static Long idConta;
	private static final long serialVersionUID = 1L;
	private int saldo;
	private Pessoa pessoa;
	private Date dataCriacao;
	private List<Transacao> transacoes;
	private boolean flagAtivo;
	public static Long getIdConta() {
		return idConta;
	}
	
public ContaDTO() {
		
	}
	

public ContaDTO(ContaBancaria obj) {
	saldo = obj.depositar(saldo);
	pessoa = obj.getPessoa();
	dataCriacao = obj.getDataCriacao();
	transacoes = obj.getTransacoes();
	
}

	public static void setIdConta(Long idConta) {
		ContaDTO.idConta = idConta;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public List<Transacao> getTransacoes() {
		return transacoes;
	}
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
	public boolean isFlagAtivo() {
		return flagAtivo;
	}
	public void setFlagAtivo(boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
