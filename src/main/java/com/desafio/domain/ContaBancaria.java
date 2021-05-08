package com.desafio.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ContaBancaria implements Serializable {
	@Id
	private Long idConta;
	private static final long serialVersionUID = 1L;
	private int saldo;
    private Pessoa pessoa;
    private double limiteSaqueDiario;
    private static int contador;
    private Date dataCriacao;
    private List<Transacao> transacoes;
    
    
    public ContaBancaria(Pessoa pessoa) {
    	idConta = (long) ContaBancaria.contador++;
        this.pessoa = pessoa;
    }
	
 public Long getIdConta() {
		return idConta;
	}

	public void setIdConta(Long idConta) {
		this.idConta = idConta;
	}

	public double getLimiteSaqueDiario() {
		return limiteSaqueDiario;
	}

	public void setLimiteSaqueDiario(double limiteSaqueDiario) {
		this.limiteSaqueDiario = limiteSaqueDiario;
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

	public static void setContador(int contador) {
		ContaBancaria.contador = contador;
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

    public int sacar(int valorSaque) {
        if (this.saldo >= valorSaque) {
            this.saldo = this.saldo - valorSaque;
            return this.saldo;
        } else {
            return this.saldo;
        }
    }
    
    @Override
	public String toString() {
		return "ContaBancaria [idConta=" + idConta + ", saldo=" + saldo + ", pessoa=" + pessoa + ", limiteSaqueDiario="
				+ limiteSaqueDiario + ", dataCriacao=" + dataCriacao + ", transacoes=" + transacoes + "]";
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((idConta == null) ? 0 : idConta.hashCode());
		long temp;
		temp = Double.doubleToLongBits(limiteSaqueDiario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(limiteSaqueDiario) != Double.doubleToLongBits(other.limiteSaqueDiario))
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

    
    public static int getContador() {
        return ContaBancaria.contador;
    }

	public ContaBancaria(Long idConta, int saldo, Pessoa pessoa, double limiteSaqueDiario, Date dataCriacao,
			List<Transacao> transacoes) {
		super();
		this.idConta = idConta;
		this.saldo = saldo;
		this.pessoa = pessoa;
		this.limiteSaqueDiario = limiteSaqueDiario;
		this.dataCriacao = dataCriacao;
		this.transacoes = transacoes;
	}
}

