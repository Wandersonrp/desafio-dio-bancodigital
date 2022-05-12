package model.entities.conta;

public interface ContaInterface {

	void sacar(Double valor);
	
	void depositar(Double valor);
	
	void transferir (Double valor, Conta contaDestino);
}
