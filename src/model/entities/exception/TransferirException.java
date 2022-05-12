package model.entities.exception;

import model.entities.conta.Conta;

public class TransferirException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TransferirException() {
	}
	
	public TransferirException(String msg) {
		super(msg);
	}
	
	public void exceptionTransferir(double valor, double saldo, Conta contaDestino) {
		if (valor <= 0d) {
			throw new TransferirException("Impossível realizar a operação de tranferência! O valor a transferir R$ " 
					+ String.format("%.2f", valor) + " é menor que zero.");
		}
		if (saldo < valor) {
			throw new TransferirException("Impossível realizar a operação de transferência!\n O valor de saldo(R$ " 
					+ String.format("%.2f", saldo) + ") é menor que o valor a transferir (R$ " 
					+ String.format("%.2f", valor) + ")!");
		}
		if (contaDestino == null) {
			throw new TransferirException("Impossível realizar a operação de transferência! A conta informada é inválida!");
		}
	}
}
