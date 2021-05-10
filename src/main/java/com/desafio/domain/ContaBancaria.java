package com.desafio.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "conta")
public class ContaBancaria implements Serializable {
	@Id
	@NotEmpty
	private static Long idConta;
	private static final long serialVersionUID = 1L;
	private int saldo;
	private Pessoa pessoa;
	private Date dataCriacao;
	private List<Transacao> transacoes;
	private boolean flagAtivo;

	public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// métodos
	public int depositar(int valorDeposito) {
		if (valorDeposito > 0) {
			this.saldo = this.saldo + valorDeposito;
			return this.saldo;
		} else {
			return this.saldo;
		}
	}

	// conta valor negativo
	public void saca(double valor) throws Exception {
		if (valor > this.saldo) {
			throw new Exception("sem saldo");
		} else {
			this.saldo -= valor;
		}
	}

	public int sacar(int valorSaque) {
		if (this.saldo >= valorSaque) {
			this.saldo = this.saldo - valorSaque;
			return this.saldo;
		} else {
			return this.saldo;
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + saldo;
		result = prime * result + ((transacoes == null) ? 0 : transacoes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (idConta == null) {
			if (other.idConta != null)
				return false;
		} else if (!idConta.equals(other.idConta))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (saldo != other.saldo)
			return false;
		if (transacoes == null) {
			if (other.transacoes != null)
				return false;
		} else if (!transacoes.equals(other.transacoes))
			return false;
		return true;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public int getSaldo() {
		return saldo;
	}

	public Long getId() {
		return idConta;
	}

	public boolean isFlagAtivo() {
		return isFlagAtivo();
	}

	public void setFlagAtivo(boolean flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public ContaBancaria(Long idConta, int saldo, Pessoa pessoa, double limiteSaqueDiario, Date dataCriacao,
			List<Transacao> transacoes) {
		super();
		this.idConta = idConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.dataCriacao = dataCriacao;
		this.transacoes = transacoes;
	}

	public ContaBancaria(Object object, int i, String string, String string2) {
		this.idConta = idConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.dataCriacao = dataCriacao;
	}

}
