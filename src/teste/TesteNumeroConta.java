package teste;

import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;

public class TesteNumeroConta {

	public static void main(String[] args) {
		
		ClientePessoaFisica clientePF = new ClientePessoaFisica("Ana", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(clientePF);
		System.out.println(ccpf.getNumeroConta());
	}
}
