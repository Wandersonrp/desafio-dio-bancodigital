package model.entities.conta.pessoajuridica;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.Conta;

public class ContaCorrentePessoaJuridica extends Conta {
	
	public ContaCorrentePessoaJuridica(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta corrente pessoa jurídica");
		sb.append("\nAgência: " + AGENCIA);
		sb.append("\nNúmero da Conta: " + numeroConta);
		sb.append("\nCliente: " + cliente.getNome());
		return sb.toString();
	}
}
