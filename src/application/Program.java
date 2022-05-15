package application;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.entities.Banco;
import model.entities.cliente.Cliente;
import model.entities.conta.Conta;
import model.entities.conta.ContaPoupanca;
import model.entities.conta.pessoafisica.ContaCorrentePessoaFisica;
import model.entities.conta.pessoajuridica.ContaCorrentePessoaJuridica;
import model.services.criarconta.CriarCilente;
import model.services.criarconta.CriarConta;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		/*menuCadastrarCliente();
		int opcao = sc.nextInt();
		cadastrarCliente(opcao);*/
		
		System.out.println("Digite o cpf");
		String cpf = sc.next();
		String cpfFormatado = formatarCpf(cpf);
		System.out.println(cpfFormatado);
		
	}
	
	public static void criarContaPessoaFisica(int value, Cliente cliente) {
		switch (value) {
			case 1:
				ContaCorrentePessoaFisica ccpf = CriarConta.criarContaPf(cliente);
				String nome = formatarNome(cliente.getNome());
				System.out.println("\nParabéns, " + nome + "!\n"
						+ "Conta Corrente criada com sucesso!");
				informarContaCriada(cliente, ccpf);
				break;
			case 2:
				ContaPoupanca cpoupanca = CriarConta.criarContaPoupanca(cliente);
				nome = formatarNome(cliente.getNome());
				System.out.println("\nParabéns, " + nome + "!\n"
						+ "Conta Poupança criada com sucesso!");
				informarContaCriada(cliente, cpoupanca);
				break;
			case 0:
				System.out.println("Saindo");;
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
	}
	
	public static void criarContaPessoaJuridica(int value, Cliente cliente) {
		switch (value) {
			case 3:
				ContaCorrentePessoaJuridica ccpj = CriarConta.criarContaPj(cliente);
				break;
			case 0:
				System.out.println("Saindo");;
				break;	
			default: 
				System.out.println("Opção informada inválida!");
		}
	}
	
	public static int menuInformarCriarConta(String value, int opt) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("\n" + value + ", escolha uma das opções abaixo:\n");
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
	
	public static Cliente cadastrarCliente(int value) {
		Scanner scan = new Scanner(System.in);
		switch (value) {
			case 1:
				System.out.print("Digite o seu nome completo: ");
				String nome = scan.nextLine();
				String nomeFormatado = formatarNome(nome);
				System.out.print("\n" + nomeFormatado + ", digite o seu CPF: ");
				String cpf = scan.nextLine();
				Cliente clientePf = CriarCilente.criarClientePf(nome, cpf);
				int opcao = menuInformarCriarConta(nomeFormatado, value);
				criarContaPessoaFisica(opcao, clientePf);
				scan.close();
				return clientePf;
			case 2:
				System.out.print("Digite o nome da empresa: ");
				String nomeEmpresa = scan.nextLine();
				System.out.print("\nDigite o CNPJ da empresa " + nomeEmpresa + ": ");
				String cnpj = scan.nextLine();
				Cliente clientePj = CriarCilente.criarClientePj(nomeEmpresa, cnpj);
				opcao = menuInformarCriarConta(nomeEmpresa, value);
				criarContaPessoaJuridica(opcao, clientePj);
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
}
