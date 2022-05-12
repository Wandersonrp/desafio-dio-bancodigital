package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.conta.Conta;

public class Banco {

	private final String NOME = "+Plus Digital BANK";
	
	private List<Conta> conta = new ArrayList<>();

	public String getNOME() {
		return NOME;
	}

	public List<Conta> getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta.add(conta);
	}
}
