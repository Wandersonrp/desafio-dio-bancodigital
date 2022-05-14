package model.services.criarconta;

import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;

public class CriarConta {

	public static ContaCorrentePessoaJuridica criarContaPj(ClientePessoaJuridica cliente) {
		return new ContaCorrentePessoaJuridica(cliente);
	}
	
	public static ContaCorrentePessoaFisica criarContaPf(ClientePessoaFisica cliente) {
		return new ContaCorrentePessoaFisica(cliente);
	}
	
	public static ContaPoupanca criarContaPoupanca(ClientePessoaFisica cliente) {
		return new ContaPoupanca(cliente);
	}
}