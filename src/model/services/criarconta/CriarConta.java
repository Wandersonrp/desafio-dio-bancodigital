package model.services.criarconta;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;

public class CriarConta {

	public static ContaCorrentePessoaJuridica criarContaPj(Cliente cliente, Banco banco) {
		return new ContaCorrentePessoaJuridica(cliente, banco);
	}
	
	public static ContaCorrentePessoaFisica criarContaPf(Cliente cliente, Banco banco) {
		return new ContaCorrentePessoaFisica(cliente, banco);
	}
	
	public static ContaPoupanca criarContaPoupanca(Cliente cliente, Banco banco) {
		return new ContaPoupanca(cliente, banco);
	}
}
