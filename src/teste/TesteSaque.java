package teste;

import java.util.Locale;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.exception.SaqueException;

public class TesteSaque {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Banco banco = new Banco();
		
		String resultado = "";
		
		// sacar com o valor de saldo igual a 0.0 (dispara a SaqueException)
			System.out.println("\n=== Teste 01 Saque ===\n");
			ClientePessoaFisica clientePf = new ClientePessoaFisica("José", "000.000.000-00");
			ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(clientePf);
		try {	
			ccpf.sacar(200d);
			resultado = ccpf.extratoSaldoPessoaFisica(clientePf, ccpf, banco);
			System.out.println(resultado);
		} catch (SaqueException e) {
			e.printStackTrace();
		} finally {
			//sacar com o valor de saldo maior que o saque
			System.out.println("\n=== Teste 02 Saque ===\n");
			ClientePessoaFisica clientePf2 = new ClientePessoaFisica("Antônio", "000.000.000-00");
			ContaCorrentePessoaFisica ccpf2 = new ContaCorrentePessoaFisica(clientePf2);
			ccpf2.depositar(600d);
			ccpf2.sacar(200d);
			resultado = ccpf2.extratoSaldoPessoaFisica(clientePf2, ccpf2, banco);
			System.out.println(resultado);
		}
		
		//sacar com o valor de saldo menor que o valor de saque (dispara SaqueException)
		System.out.println("\n=== Teste 03 Saque ===\n");
		ClientePessoaFisica clientePf3 = new ClientePessoaFisica("Carlos", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf3 = new ContaCorrentePessoaFisica(clientePf3);
		ccpf3.depositar(600d);
		ccpf3.sacar(1000d);
		resultado = ccpf.extratoSaldoPessoaFisica(clientePf3, ccpf3, banco);
		System.out.println(resultado);
	}
}
