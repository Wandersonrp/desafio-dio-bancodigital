package model.entities.conta;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;

public class ContaPoupanca extends ContaCorrentePessoaFisica{
	
	public ContaPoupanca(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta poupança");
		sb.append("\nAgência: " + AGENCIA);
		sb.append("\nNúmero da Conta: " + numeroConta);
		sb.append("\nCliente: " + cliente.getNome());
		return sb.toString();
	}
}
