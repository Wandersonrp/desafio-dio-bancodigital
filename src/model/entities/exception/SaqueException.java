package model.entities.exception;

public class SaqueException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaqueException() {
	}
	
	public SaqueException(String msg) {
		super(msg);
	}
	
	public void exceptionSaque(double saldo, double valor, double taxaSaque, double valorTaxaSaque) {
		if (saldo == 0d) {
			throw new SaqueException("Imposs�vel realizar a opera��o de saque! O valor de saldo � R$ " 
		+ String.format("%.2f", saldo) + ".");
		}
		if (valor < 0) {
			throw new SaqueException("Imposs�vel realizar a opera��o de saque! O valor a sacar � menor que R$ 0.00.");
		}
		if (saldo < (valorTaxaSaque)) {
			throw new SaqueException("Imposs�vel realizar a opera��o de saque!\n O valor de saldo(R$ " 
					+ String.format("%.2f", saldo) + ") � menor que o valor de saque + taxa (R$ " 
					+ String.format("%.2f", valorTaxaSaque) + ")!");
		}
	}
}
