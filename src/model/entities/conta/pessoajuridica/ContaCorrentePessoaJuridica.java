package model.entities.conta.pessoajuridica;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.cliente.ClientePessoaJuridica;
import model.entities.conta.Conta;
import model.entities.exception.SaqueException;
import model.entities.exception.TransferirException;

public class ContaCorrentePessoaJuridica extends Conta {
	
	public ContaCorrentePessoaJuridica(Cliente cliente, Banco banco) {
		super(cliente, banco);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sacar(Double valor) {
		double taxaSaque = 5d;
		double valorTaxaSaque = valor + taxaSaque;
		SaqueException saqueException = new SaqueException();
		saqueException.exceptionSaque(saldo, valor, taxaSaque, valorTaxaSaque);
		saldo -= valor + taxaSaque;
	}

	@Override
	public void transferir(Double valor, Conta contaDestino) {
		TransferirException transferirException = new TransferirException();
		transferirException.exceptionTransferir(valor, this.saldo, contaDestino);
		this.saldo -= valor;
		contaDestino.depositar(valor);
	}
	
	@Override
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta corrente pessoa jur�dica");
		sb.append("\nAg�ncia: " + AGENCIA);
		sb.append("\nN�mero da Conta: " + numeroConta);
		sb.append("\nCliente: " + cliente.getNome());
		return sb.toString();
	}
}
