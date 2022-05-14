package teste;

import java.util.Locale;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;
import model.services.criarconta.CriarConta;

public class TesteCriarConta {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Banco banco = new Banco();
		
		System.out.println("=== Teste 01 CriarContaPj ===");
		
		ClientePessoaJuridica clientePj = new ClientePessoaJuridica("Lojas Compre", 
				"00.000.000/0001-00");
		ContaCorrentePessoaJuridica ccpj = CriarConta.criarContaPj(clientePj);
		ccpj.depositar(500d);
		String result = ccpj.extratoSaldoPessoaJuridica(clientePj, ccpj, banco);
		System.out.println(result);
		
		System.out.println("\n=== Teste 02 CriarContaPf ===");
		
		ClientePessoaFisica clientePf = new ClientePessoaFisica("Albert", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf = CriarConta.criarContaPf(clientePf);
		ccpf.depositar(200d);
		ccpf.transferir(100d, ccpj);
		result = ccpf.extratoSaldoPessoaFisica(clientePf, ccpf, banco);
		System.out.println(result);
		
		result = ccpj.extratoSaldoPessoaJuridica(clientePj, ccpj, banco);
		System.out.println();
		System.out.println(result);
		
		System.out.println("\n=== Teste 03 CriarContaPoupanca ===");
		ClientePessoaFisica clientePoupanca = new ClientePessoaFisica("Ana", "000.000.000-00");
		ContaPoupanca contaPoupanca = CriarConta.criarContaPoupanca(clientePoupanca);
		contaPoupanca.depositar(1500d);
		result = contaPoupanca.extratoSaldoPessoaFisica(clientePoupanca, contaPoupanca, banco);
		System.out.println(result);
	}
}
