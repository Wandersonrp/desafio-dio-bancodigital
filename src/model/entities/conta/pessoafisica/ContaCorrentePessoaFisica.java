package model.entities.conta.pessoafisica;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.Conta;
import model.entities.exception.SaqueException;
import model.entities.exception.TransferirException;

public class ContaCorrentePessoaFisica extends Conta {

	public ContaCorrentePessoaFisica(Cliente cliente, Banco banco) {
		super(cliente, banco);
	}

	@Override
	public void depositar(Double valor) {
		saldo += valor;
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Conta corrente pessoa física");
		sb.append("\nAgência: " + AGENCIA);
		sb.append("\nNúmero da Conta: " + numeroConta);
		sb.append("\nCliente: " + cliente.getNome());
		return sb.toString();
	}
}
