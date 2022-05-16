package model.entities.cliente;

import model.entities.conta.Conta;

public abstract class Cliente {
	
	protected String nome;
	private String nomeFormatado;
	protected String documento;
	
	protected Conta conta;
	
	public Cliente(String nome, String documento) {
		this.nome = nome;
		this.documento = documento;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeFormatado() {
		return nomeFormatado;
	}

	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
