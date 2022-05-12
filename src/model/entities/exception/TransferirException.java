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
			throw new TransferirException("Imposs�vel realizar a opera��o de tranfer�ncia! O valor a transferir R$ " 
					+ String.format("%.2f", valor) + " � menor que zero.");
		}
		if (saldo < valor) {
			throw new TransferirException("Imposs�vel realizar a opera��o de transfer�ncia!\n O valor de saldo(R$ " 
					+ String.format("%.2f", saldo) + ") � menor que o valor a transferir (R$ " 
					+ String.format("%.2f", valor) + ")!");
		}
		if (contaDestino == null) {
			throw new TransferirException("Imposs�vel realizar a opera��o de transfer�ncia! A conta informada � inv�lida!");
		}
	}
}
