package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.Conta;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;
import model.entities.exception.SaqueException;
import model.entities.exception.TransferirException;
import model.services.criarconta.CriarCliente;
import model.services.criarconta.CriarConta;
import model.util.ClasseValidacao;

public class Program {

	private static Banco banco = new Banco();
	private static List<Conta> contas = new ArrayList<>();
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws InputMismatchException {
		
		Locale.setDefault(Locale.US);
		
		int opcao = 0;
		
		do {
			menuCadastrarCliente();
			opcao = scan.nextInt();
			cadastrarCliente(opcao);
			System.out.println();
		} while(opcao != 0);
		
		banco.acessarContas(contas);
		 
		scan.close();
	}
	
	public static Conta  criarContaPessoaFisica(int value, Cliente cliente) {
		Scanner scan = new Scanner(System.in);
		switch (value) {
			case 1:
				ContaCorrentePessoaFisica ccpf = CriarConta.criarContaPf(cliente, banco);
				
				System.out.println("\nParabéns, " + cliente.getNomeFormatado() + "!\n"
						+ "Conta Corrente criada com sucesso!");
				
				contas.add(ccpf);
				informarContaCriada(cliente, ccpf);
				menuAcoesConta(ccpf);
				
				int opt = scan.nextInt();
				escolherAcoesConta(opt, cliente, ccpf);
				return ccpf;
			case 2:
				ContaPoupanca cpoupanca = CriarConta.criarContaPoupanca(cliente, banco);
				
				System.out.println("\nParabéns, " + cliente.getNomeFormatado() + "!\n"
						+ "Conta Poupança criada com sucesso!");
				
				contas.add(cpoupanca);
				informarContaCriada(cliente, cpoupanca);
				menuAcoesConta(cpoupanca);
				
				opt = scan.nextInt();
				escolherAcoesConta(opt, cliente, cpoupanca);
				return cpoupanca;
			case 0:
				System.out.println("Saindo");
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
		return null;
	}
	
	public static Conta criarContaPessoaJuridica(int value, Cliente cliente) {
		switch (value) {
			case 1:
				ContaCorrentePessoaJuridica ccpj = CriarConta.criarContaPj(cliente, banco);
				
				System.out.println("\nParabéns, " + cliente.getNome() + "!\n"
						+ "Conta Corrente Pessoa Jurídica criada com sucesso!");
				
				contas.add(ccpj);
				informarContaCriada(cliente, ccpj);
				menuAcoesConta(ccpj);
				
				int opt = scan.nextInt();
				escolherAcoesConta(opt, cliente, ccpj);
				return ccpj;
			case 0:
				System.out.println("Saindo");
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
		return null;
	}
	
	public static Integer menuInformarCriarConta(Cliente cliente, int opt) {
		if (opt == 1) {
			System.out.println("\n" + cliente.getNomeFormatado() 
					+ ", para criar uma conta escolha uma das opções abaixo:\n");
			System.out.println("1 - Criar conta corrente");
			System.out.println("2 - Criar conta poupança");
			
		} else if (opt == 2) {
			System.out.println("\n" + cliente.getNome() + ", para criar uma conta escolha uma das opções abaixo:\n");
			System.out.println("1 - Criar conta corrente para pessoa jurídica");
		}
	
		System.out.println("0 - Sair");
		try {
			 int op2 = scan.nextInt();
			 return op2;
		} catch (InputMismatchException e) {
			System.out.println("Digite somente o número de acordo com as opções!");
		}
		return null;
	}
	
	public static Cliente cadastrarCliente(int value) throws InputMismatchException {
		switch (value) {
			case 1:
				System.out.print("\nDigite o seu nome completo: ");
				scan.nextLine();
				String nome = scan.nextLine();
				String nomeFormatado = ClasseValidacao.formatarPrimeiroNome(nome);
				
				System.out.print("\n" + nomeFormatado 
						+ ", digite um CPF válido (000.000.000-00): ");
				String cpf = scan.next();
				boolean cpfVerificado = ClasseValidacao.verificarCpf(cpf);
				cpf = ClasseValidacao.validarCpf(cpfVerificado, cpf);
				
				Cliente clientePf = CriarCliente.criarClientePf(nome, cpf);
				clientePf.setNomeFormatado(nomeFormatado);
				
				int opt = menuInformarCriarConta(clientePf, value);
				criarContaPessoaFisica(opt, clientePf);
				return clientePf;
			case 2:
				System.out.print("\nDigite o nome da empresa: ");
				scan.nextLine();
				String nomeEmpresa = scan.nextLine();
				
				System.out.print("\nDigite o CNPJ (00.000.000/0001-00) da empresa " 
				+ nomeEmpresa + ": ");
				String cnpj = scan.next();
				boolean cnpjVerificado = ClasseValidacao.verificarCnpj(cnpj);
				cnpj = ClasseValidacao.validarCnpj(cnpjVerificado, cnpj);
				
				Cliente clientePj = CriarCliente.criarClientePj(nomeEmpresa, cnpj);
				
				opt = menuInformarCriarConta(clientePj, value);
				criarContaPessoaJuridica(opt, clientePj);
				return clientePj;
			case 0:
				System.out.println("Saindo");
				break;
			default: 
				System.out.println("Opção informada inválida!");
				break;
		}
		return null;
	}
	
	public static void menuCadastrarCliente() {
		System.out.println("Bem-vindo ao atendimento +PlusBank!" 
				+ "\nEscolha uma das opções para se cadastrar:\n");
		System.out.println("1 - Pessoa física\n2 - Pessoa jurídica\n0 - Sair");
	}
	
	public static void informarContaCriada(Cliente cliente, Conta conta) {
		System.out.println("\n==========================================================\n");
		System.out.println("\t\t  " + banco.getNOME());
		System.out.println("\n==========================================================\n");
		System.out.println("\nCliente: " + cliente.getNome());
		
		if (cliente.getDocumento().length() == 14 ) System.out.println("\nCPF: " + cliente.getDocumento());
		else System.out.println("\nCNPJ: " + cliente.getDocumento());
		
		System.out.println("\nNúmero da conta: " + conta.getNumeroConta());
		System.out.println("\nSaldo: R$ " + String.format("%.2f", conta.getSaldo()) + "\n");
	}
	
	public static void menuAcoesConta(Conta conta) {
		System.out.println("==========================================================\n");
		
		if (conta.getCliente().getDocumento().length() == 14) {
			System.out.println("\n" + conta.getCliente().getNomeFormatado() 
					+ ", escolha uma das opções a seguir: ");
		} else {
			System.out.println("\n" + conta.getCliente().getNome() + ", escolha uma das opções a seguir: ");
		}
		
		System.out.println("1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Extrato\n0 - Sair ");
	}
	
	public static void escolherAcoesConta(int value, Cliente cliente, Conta conta) {
		double valor = 0.0;
		int opcao = 0;
		do {
			switch (value) {
				case 1:
					System.out.println("\nDigite o valor a ser depositado: ");
					valor = scan.nextDouble();
					conta.depositar(valor);
					break;
				case 2:
					System.out.println("\nDigite o valor a sacar: ");
					valor = scan.nextDouble();
					
					try {
						conta.sacar(valor);
					} catch (SaqueException e) {
						System.out.println(e.getMessage());
					} 
					
					break;
				case 3:
					System.out.println("\nDigite o valor a ser transferido: ");
					valor = scan.nextDouble();
					System.out.println("\nContas adicionadas: ");
				
					for (Conta c : contas) {
						if (c.getCliente().getDocumento().equals(conta.getCliente().getDocumento())) {
							continue;
						}
						System.out.println("\nCliente: " + c.getCliente().getNome() + 
								" - Documento: " + c.getCliente().getDocumento());
					}
					
					System.out.println("\nDigite o CPF/CNPJ do titular conta de destino: ");
					String documento = scan.next();
					boolean cpfVerificado = ClasseValidacao.verificarCpf(documento);
					boolean cnpjVerificado = ClasseValidacao.verificarCnpj(documento);
					
					if (cpfVerificado) documento = ClasseValidacao.validarCpf(cpfVerificado, documento);
					if(cnpjVerificado) documento = ClasseValidacao.validarCnpj(cnpjVerificado, documento);
					
					try {
						for (Conta c : contas) {
							if (c.getCliente().getDocumento().equals(documento)) {
								conta.transferir(valor, c);

								System.out.println("\n" + conta.getCliente().getNome() 
										+ ", o valor de R$ " + String.format("%.2f", valor) 
										+ " foi transferido com sucesso para " 
										+ c.getCliente().getNome() + ".");
								break;
							} else {
								System.out.println("\nConta não encontrada!");
							}
						}
						
					} catch (TransferirException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					String extrato = conta.obterExtrato(cliente, conta, banco);
					System.out.println(extrato);
					break;
				case 0:
					System.out.println("Saindo");
					break;
				default: 
					System.out.println("Opão inválida!");
					break;
			}
			System.out.println("\nDeseja realizar outra operação: \n1 - Sim\n2 - Não\n");
			opcao = scan.nextInt();
			if (opcao != 2) {
				menuAcoesConta(conta);
				value = scan.nextInt();
			}
			
		} while (opcao != 2);
	}
}