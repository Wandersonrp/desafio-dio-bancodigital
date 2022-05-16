package model.entities.conta;

import model.entities.Banco;
import model.entities.NumeroConta;
import model.entities.cliente.Cliente;

public abstract class Conta implements ContaInterface {

	protected static final String AGENCIA = "0001 ";
	
	protected Double saldo;
	protected String numConta;
	protected String numeroConta;
	
	protected Cliente cliente;
	
	protected Banco banco;
	
	public Conta(Cliente cliente, Banco banco) {
		NumeroConta numero = new NumeroConta();
		this.numConta = numero.gerarNumeroConta();
		this.numeroConta = AGENCIA + numConta;
		this.saldo = 0d;
		this.cliente = cliente;
		this.banco = banco;
	}
	
	public String getAGENCIA() {
		return AGENCIA;
	}

	public Double getSaldo() {
		return saldo;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Banco getBanco() {
		return banco;
	}
	
	@Override
	public String obterExtrato(Cliente cliente, Conta conta, Banco banco) {
		StringBuilder sb = new StringBuilder();
		sb.append("==========================================================\n");
		sb.append("\t\t  " + banco.getNOME());
		sb.append("\n==========================================================");
		sb.append("\n================= EXTRATO BANCÁRIO =======================\n");
		sb.append("\nNúmero da conta: " + conta.getNumeroConta());
		sb.append("\nAgência: " + conta.getAGENCIA());
		sb.append("\nConta: " + numConta);
		sb.append("\nCliente: " + cliente.getNome());
		if (cliente.getDocumento().length() == 14) {
			sb.append("\nCPF: " + cliente.getDocumento());
		} else {
			sb.append("\nCNPJ: " + cliente.getDocumento());
		}
		sb.append("\nSaldo: R$ " + String.format("%.2f", conta.getSaldo()));
		sb.append("\n==========================================================");
		return sb.toString();
	}
}
