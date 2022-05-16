package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.conta.Conta;

public class Banco {

	private String NOME = "+Plus Digital BANK";
	
	private List<Conta> conta = new ArrayList<>();

	public Banco() {
	}

	public String getNOME() {
		return NOME;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(List<Conta> conta) {
		this.conta = conta;
	}
}
