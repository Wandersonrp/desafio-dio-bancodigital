package teste;

import java.util.Locale;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.exception.TransferirException;

public class TesteTransferir {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Banco banco = new Banco();
		
		// transferir sem saldo (dispara TransferirException)
		System.out.println("\n=== Teste 01 Transferir ===\n");
		ClientePessoaFisica clientePf = new ClientePessoaFisica("Ana", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(clientePf);
		
		ClientePessoaFisica clientePf2 = new ClientePessoaFisica("Maria", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf2 = new ContaCorrentePessoaFisica(clientePf2);
		try {
			ccpf.transferir(300.00, ccpf2);
		}
		catch(TransferirException e) {
			e.printStackTrace();
		} 
		finally {
			String resultadoCcpf = ccpf.extratoSaldoPessoaFisica(clientePf, ccpf, banco);
			System.out.println(resultadoCcpf);
			System.out.println();
			String resultadoCcpf2 = ccpf2.extratoSaldoPessoaFisica(clientePf2, ccpf2, banco);
			System.out.println(resultadoCcpf2);
		}
		
		// transferir com saldo, porém valor de tranferência negativo (dispara TransferirException)
		System.out.println("\n=== Teste 02 Transferir ===\n");
		ClientePessoaFisica clientePf3 = new ClientePessoaFisica("João", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf3 = new ContaCorrentePessoaFisica(clientePf3);
		
		ClientePessoaFisica clientePf4 = new ClientePessoaFisica("Alex", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf4 = new ContaCorrentePessoaFisica(clientePf4);
		try {
			ccpf3.depositar(500d);
			ccpf3.transferir(-200d, ccpf4);
		}
		catch(TransferirException e) {
			e.printStackTrace();
		} 
		finally {
			String resultadoCcpf3 = ccpf3.extratoSaldoPessoaFisica(clientePf3, ccpf3, banco);
			System.out.println(resultadoCcpf3);
			System.out.println();
			String resultadoCcpf4 = ccpf4.extratoSaldoPessoaFisica(clientePf4, ccpf4, banco);
			System.out.println(resultadoCcpf4);
		}
		
		// transferir com conta de destino null (dispara TransferirException)
		System.out.println("\n=== Teste 03 Transferir ===\n");
		ClientePessoaFisica clientePf5 = new ClientePessoaFisica("Mario", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf5 = new ContaCorrentePessoaFisica(clientePf5);
		try {
			ccpf5.depositar(500d);
			ccpf5.transferir(200d, null);
		}
		catch (TransferirException e) {
			e.printStackTrace();
		}
		finally {
			String resultadoCcpf5 = ccpf5.extratoSaldoPessoaFisica(clientePf5, ccpf5, banco);
			System.out.println(resultadoCcpf5);
		}
		
		// transferir sem exception
		System.out.println("\n=== Teste 04 Transferir ===\n");
		ClientePessoaFisica clientePf6 = new ClientePessoaFisica("Igor", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf6 = new ContaCorrentePessoaFisica(clientePf6);
		
		ClientePessoaFisica clientePf7 = new ClientePessoaFisica("Caio", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf7 = new ContaCorrentePessoaFisica(clientePf7);
		
		try {
			ccpf6.depositar(1000d);
			ccpf6.transferir(200d, ccpf7);
		}
		catch(TransferirException e) {
			e.printStackTrace();
		}
		finally {
			String resultadoCcpf6 = ccpf6.extratoSaldoPessoaFisica(clientePf6, ccpf6, banco);
			System.out.println(resultadoCcpf6);
			System.out.println();
			String resultadoCcpf7 = ccpf7.extratoSaldoPessoaFisica(clientePf7, ccpf7, banco);
			System.out.println(resultadoCcpf7);
		}
	}
}
