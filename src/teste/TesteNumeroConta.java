package teste;

import model.entities.Banco;
import model.entities.cliente.ClientePessoaFisica;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;

public class TesteNumeroConta {

	public static void main(String[] args) {
		Banco banco = new Banco();
		
		ClientePessoaFisica clientePF = new ClientePessoaFisica("Ana", "000.000.000-00");
		ContaCorrentePessoaFisica ccpf = new ContaCorrentePessoaFisica(clientePF, banco);
		System.out.println(ccpf.getNumeroConta());
	}
}
