package model.entities.cliente;

import model.entities.conta.Conta;

public abstract class Cliente {
	
	protected String nome;
	
	protected Conta conta;
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
