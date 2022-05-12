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
	
	public Conta(Cliente cliente) {
		NumeroConta numero = new NumeroConta();
		this.numConta = numero.gerarNumeroConta();
		this.numeroConta = AGENCIA + numConta;
		this.saldo = 0d;
		this.cliente = cliente;
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
}
