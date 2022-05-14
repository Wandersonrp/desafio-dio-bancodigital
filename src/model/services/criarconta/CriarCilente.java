package model.services.criarconta;

import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;

public class CriarCilente {

	public static ClientePessoaFisica criarClientePf(String nome, String cpf) {
		return new ClientePessoaFisica(nome, cpf);
	}
	
	public static ClientePessoaJuridica criarClientePj(String nome, String cnpj) {
		return new ClientePessoaJuridica(nome, cnpj);
	}
}
