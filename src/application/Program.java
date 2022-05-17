package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		} while(opcao != 0);
		
		
		//acessarContas(conta);
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
	
	public static Conta criarContaPessoaJuridica(int value, Cliente cliente) throws InputMismatchException {
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
			System.out.println("\n" + cliente.getNomeFormatado() + ", para criar uma conta escolha uma das opções abaixo:\n");
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
				String nomeFormatado = formatarNome(nome);
				System.out.print("\n" + nomeFormatado + ", digite o seu CPF (somente números): ");
				String cpf = scan.nextLine();
				String cpfFormatado = formatarCpf(cpf);
				Cliente clientePf = CriarCliente.criarClientePf(nome, cpfFormatado);
				clientePf.setNomeFormatado(nomeFormatado);
				int opt = menuInformarCriarConta(clientePf, value);
				criarContaPessoaFisica(opt, clientePf);
				return clientePf;
			case 2:
				System.out.print("\nDigite o nome da empresa: ");
				scan.nextLine();
				String nomeEmpresa = scan.nextLine();
				System.out.print("\nDigite o CNPJ da empresa " + nomeEmpresa + ": ");
				String cnpj = scan.nextLine();
				String cnpjFormatado = formatarCnpj(cnpj);
				Cliente clientePj = CriarCliente.criarClientePj(nomeEmpresa, cnpjFormatado);
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
		System.out.println("\nBem-vindo ao atendimento +PlusBank!\nEscolha uma das opções para se cadastrar:\n");
		System.out.println("1 - Pessoa física");
		System.out.println("2 - Pessoa jurídica");
		System.out.println("0 - Sair");
	}
	
	public static String formatarNome(String value) {
		String[] vetor = value.split(" ");
		String nome = vetor[0];
		return nome;
	}
	
	public static void informarContaCriada(Cliente cliente, Conta conta) {
		Banco banco = new Banco();
		System.out.println("\n==========================================================\n");
		System.out.println("\t\t  " + banco.getNOME());
		System.out.println("\n==========================================================\n");
		System.out.println("\nCliente: " + cliente.getNome());
		if (cliente.getDocumento().length() == 14 ) {
			System.out.println("\nCPF: " + cliente.getDocumento());
		} else {
			System.out.println("\nCNPJ: " + cliente.getDocumento());
		}
		System.out.println("\nNúmero da conta: " + conta.getNumeroConta());
		System.out.println("\nSaldo: R$ " + String.format("%.2f", conta.getSaldo()) + "\n");
	}
	
	public static String formatarCpf(String value) {
		String traco = "-";
		String ponto = ".";
		String[] cpf = value.split("");
		String[] vetor = new String[14];
		
		int cont = 0;
		for (int i = 0; i < vetor.length; i++) {
			
			if (i == 3 || i == 7) {
				vetor[i] = ponto;
				continue;
			}
			if (i == 11) {
				vetor[i] = traco;
				continue;
			}
			vetor[i] = cpf[cont];
			cont++;
		}
		String cpfFormatado = Arrays.stream(vetor).collect(Collectors.joining());
		return cpfFormatado;
	}
	
	public static String formatarCnpj(String value) {
		String traco = "-";
		String ponto = ".";
		String barra = "/";
		String[] cnpj = value.split("");
		String[] vetor = new String[18];
		
		int cont = 0;
		for (int i = 0; i < 18; i++) {
			if (i == 2 || i == 6) {
				vetor[i] = ponto;
				continue;
			}
			if (i == 10) {
				vetor[i] = barra;
				continue;
			}
			if (i == 15) {
				vetor[i] = traco;
				continue;
			}
			vetor[i] = cnpj[cont];
			cont++;
		}
		String cnpjFormatado = Arrays.stream(vetor).collect(Collectors.joining());
		return cnpjFormatado;
	}
	
	public static void acessarContas(List<Conta> list) {
		System.out.println("==========================================================\n");
		System.out.println("\t\t Lista de Contas do " + banco.getNOME());
		System.out.println("==========================================================\n");
		for (Conta c : list) {
			System.out.println(c + "\n");
			System.out.println("==========================================================\n");
		}
	}
	
	public static void menuAcoesConta(Conta conta) {
		System.out.println("==========================================================\n");
		if (conta.getCliente().getDocumento().length() == 14) {
			System.out.println("\n" + conta.getCliente().getNomeFormatado() + ", escolha uma das opções a seguir: ");
		} else {
			System.out.println("\n" + conta.getCliente().getNome() + ", escolha uma das opções a seguir: ");
		}
		System.out.println("1 - Depositar ");
		System.out.println("2 - Sacar ");
		System.out.println("3 - Transferir ");
		System.out.println("4 - Extrato");
		System.out.println("0 - Sair");
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
					System.out.println("\nTaxa de saque R$ 5.00\n");
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
						System.out.println(c.getCliente().getDocumento());
					}
					
					System.out.println("\nDigite o CPF/CNPJ do titular conta de destino: ");
					String cpf = scan.next();
					String cpfFormatado = formatarCpf(cpf);
					try {
						for (Conta c : contas) {
							if (c.getCliente().getDocumento().equals(cpfFormatado)) {
								conta.transferir(valor, c);
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
