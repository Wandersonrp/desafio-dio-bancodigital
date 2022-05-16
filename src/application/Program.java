package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.Conta;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;
import model.services.criarconta.CriarCliente;
import model.services.criarconta.CriarConta;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Banco banco = new Banco();
		
		menuCadastrarCliente();
		
		int opcao = sc.nextInt();
		
		cadastrarCliente(opcao);
		
		
	}
	
	public static Conta  criarContaPessoaFisica(int value, Cliente cliente) {
		switch (value) {
			case 1:
				ContaCorrentePessoaFisica ccpf = CriarConta.criarContaPf(cliente);
				String nome = formatarNome(cliente.getNome());
				System.out.println("\nParabéns, " + nome + "!\n"
						+ "Conta Corrente criada com sucesso!");
				informarContaCriada(cliente, ccpf);
				System.out.println("\nCPF: " + cliente.getDocumento());
				return ccpf;
			case 2:
				ContaPoupanca cpoupanca = CriarConta.criarContaPoupanca(cliente);
				nome = formatarNome(cliente.getNome());
				System.out.println("\nParabéns, " + nome + "!\n"
						+ "Conta Poupança criada com sucesso!");
				informarContaCriada(cliente, cpoupanca);
				return cpoupanca;
			case 0:
				System.out.println("Saindo");
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
		return null;
	}
	
	public static void criarContaPessoaJuridica(int value, Cliente cliente) {
		switch (value) {
			case 3:
				ContaCorrentePessoaJuridica ccpj = CriarConta.criarContaPj(cliente);
				break;
			case 0:
				System.out.println("Saindo");
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
	}
	
	public static int menuInformarCriarConta(Cliente cliente, int opt) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n" + cliente.getNome() + ", escolha uma das opções abaixo:\n");
		if (opt == 1) {
			System.out.println("1 - Criar conta corrente");
			System.out.println("2 - Criar conta poupança");
			
		} else if (opt == 2) {
			System.out.println("1 - Criar conta corrente para pessoa jurídica");
		}
	
		System.out.println("0 - Sair");
		
		int op2 = scan.nextInt();
		scan.close();
		return op2;
	}
	
	public static Cliente cadastrarCliente(int value) throws InputMismatchException {
		Scanner scan = new Scanner(System.in);
		switch (value) {
			case 1:
				System.out.print("Digite o seu nome completo: ");
				String nome = scan.nextLine();
				String nomeFormatado = formatarNome(nome);
				System.out.print("\n" + nomeFormatado + ", digite o seu CPF (somente números): ");
				String cpf = scan.nextLine();
				String cpfFormatado = formatarCpf(cpf);
				Cliente clientePf = CriarCliente.criarClientePf(nome, cpfFormatado);
				int opt = menuInformarCriarConta(clientePf, value);
				criarContaPessoaFisica(opt, clientePf);
				scan.close();
				return clientePf;
			case 2:
				System.out.print("Digite o nome da empresa: ");
				String nomeEmpresa = scan.nextLine();
				System.out.print("\nDigite o CNPJ da empresa " + nomeEmpresa + ": ");
				String cnpj = scan.nextLine();
				Cliente clientePj = CriarCliente.criarClientePj(nomeEmpresa, cnpj);
				scan.close();
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
		System.out.println("Bem-vindo ao atendimento +PlusBank!\nEscolha uma das opções para se cadastrar:\n");
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
		System.out.println("\nNúmero da conta: " + conta.getNumeroConta());
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
}
