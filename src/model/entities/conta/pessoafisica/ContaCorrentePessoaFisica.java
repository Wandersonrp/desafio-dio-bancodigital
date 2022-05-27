package model.entities.conta.pessoafisica;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.Conta;

public class ContaCorrentePessoaFisica extends Conta {

	public ContaCorrentePessoaFisica(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta corrente pessoa f�sica");
		sb.append("\nAg�ncia: " + AGENCIA);
		sb.append("\nN�mero da Conta: " + numeroConta);
		sb.append("\nCliente: " + cliente.getNome());
		return sb.toString();
	}
}
