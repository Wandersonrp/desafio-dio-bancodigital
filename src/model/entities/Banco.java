package model.entities;

import java.util.ArrayList;
import java.util.List;

import model.entities.conta.Conta;

public class Banco {

	private static String NOME = "+Plus Digital BANK";
	
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
	
	public static void acessarContas(List<Conta> list) {
		System.out.println("==========================================================\n");
		System.out.println("\t Lista de Contas do " + NOME);
		System.out.println("==========================================================\n");
		
		for (Conta c : list) {
			System.out.println(c + "\n");
			System.out.println("==========================================================\n");
		}
	}
}
