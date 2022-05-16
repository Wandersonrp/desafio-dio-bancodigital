package model.services.criarconta;

import model.entities.cliente.Cliente;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;

public class CriarCliente {

	public static Cliente criarClientePf(String nome, String cpf) {
		return new ClientePessoaFisica(nome, cpf);
	}
	
	public static Cliente criarClientePj(String nome, String cnpj) {
		return new ClientePessoaJuridica(nome, cnpj);
	}
}
