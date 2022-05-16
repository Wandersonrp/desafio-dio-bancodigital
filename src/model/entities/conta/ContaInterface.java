package model.entities.conta;

import model.entities.Banco;
import model.entities.cliente.Cliente;

public interface ContaInterface {

	void sacar(Double valor);
	
	void depositar(Double valor);
	
	void transferir (Double valor, Conta contaDestino);
	
	String obterExtrato(Cliente cliente, Conta conta, Banco banco);
}
