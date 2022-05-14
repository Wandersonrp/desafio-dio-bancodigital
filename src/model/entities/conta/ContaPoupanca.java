package model.entities.conta;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.exception.SaqueException;
import model.entities.exception.TransferirException;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
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
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	@Override
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	public String extratoSaldoPoupanca(ClientePessoaFisica cliente, Conta conta, Banco banco) {
		StringBuilder sb = new StringBuilder();
		sb.append("==========================================================\n");
		sb.append("\t\t  " + banco.getNOME());
		sb.append("\n==========================================================");
		sb.append("\n================= EXTRATO BANCÁRIO =======================\n");
		sb.append("\nNúmero da conta: " + conta.getNumeroConta());
		sb.append("\nAgência: " + conta.getAGENCIA());
		sb.append("\nConta: " + numConta);
		sb.append("\nCliente: " + cliente.getNome());
		sb.append("\nCPF: " + cliente.getCpf());
		sb.append("\nSaldo: R$ " + String.format("%.2f", conta.getSaldo()));
		sb.append("\n==========================================================");
		return sb.toString();
	}
}
