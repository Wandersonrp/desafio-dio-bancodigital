package teste;

import java.util.Locale;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;

public class TesteExtratoBancario {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Banco banco = new Banco();
		
		System.out.println("=== Teste 01: Extrato banc�rio Conta Corrente Pessoa F�sica: ===\n");
		ClientePessoaFisica cliente  = new ClientePessoaFisica("Alex", "000.000.000.00");
		ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(cliente);
		String resultadoPesquisa = ccpf.extratoSaldoPessoaFisica(cliente, ccpf, banco);
		System.out.println(resultadoPesquisa);
		
		System.out.println("\n=== Teste 02: Extrato banc�rio Conta Pessoa Jur�dica: ===\n");
		ClientePessoaJuridica clientePJ  = new ClientePessoaJuridica("Supermercado Compre Aqui",
				"00.000.000/0001-00");
		ContaCorrentePessoaJuridica ccpj = new ContaCorrentePessoaJuridica(cliente);
		resultadoPesquisa = ccpj.extratoSaldoPessoaJuridica(clientePJ, ccpj, banco);
		System.out.println(resultadoPesquisa);
		
		System.out.println("\n=== Teste 03: Extrato banc�rio Conta Poupan�a: ===\n");
		ClientePessoaFisica clientePoupanca = new ClientePessoaFisica("Jo�o", "000.000.000-00");
		ContaPoupanca contaPoupanca = new ContaPoupanca(clientePoupanca);
		resultadoPesquisa = contaPoupanca.extratoSaldoPoupanca(clientePoupanca, contaPoupanca, banco);
		System.out.println(resultadoPesquisa);
	}
}
