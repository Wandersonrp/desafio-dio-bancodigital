package model.services.criarconta;

import model.entities.cliente.Cliente;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;

public class CriarConta {

	public static ContaCorrentePessoaJuridica criarContaPj(Cliente cliente) {
		return new ContaCorrentePessoaJuridica(cliente);
	}
	
	public static ContaCorrentePessoaFisica criarContaPf(Cliente cliente) {
		return new ContaCorrentePessoaFisica(cliente);
	}
	
	public static ContaPoupanca criarContaPoupanca(Cliente cliente) {
		return new ContaPoupanca(cliente);
	}
}
