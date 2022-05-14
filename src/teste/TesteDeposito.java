package teste;

import java.util.Locale;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;

public class TesteDeposito {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Banco banco = new Banco();
		
		System.out.println("\n=== Teste 01 Depósito ===\n");
		ClientePessoaFisica clientePF = new ClientePessoaFisica("José", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(clientePF);
		ccpf.depositar(500d);
		String resultado = ccpf.extratoSaldoPessoaFisica(clientePF, ccpf, banco);
		System.out.println(resultado);
		
		System.out.println("\n=== Teste 02 Depósito ===\n");
		ClientePessoaFisica clientePF2 = new ClientePessoaFisica("Alex", "000.000.000-00");
		ContaPoupanca contaPoupanca = new ContaPoupanca(clientePF2);
		contaPoupanca.depositar(500d);
		String resultado2 = contaPoupanca.extratoSaldoPessoaFisica(clientePF2, contaPoupanca, banco);
		System.out.println(resultado2);
	}
}
