package model.entities.conta;

import model.entities.cliente.Cliente;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.exception.SaqueException;
import model.entities.exception.TransferirException;

public class ContaPoupanca extends ContaCorrentePessoaFisica{
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void sacar(Double valor) {
		double taxaSaque = 0d;
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
}
