package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.cliente.ClientePessoaFisica;
import model.entities.cliente.ClientePessoaJuridica;
import model.services.criarconta.CriarCilente;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		menuCadastrarCliente();
		int opcao = sc.nextInt();
		cadastrarCliente(opcao);
		
		
	}
	
	/*public static void criarContaPessoaFisica(int value) {
		switch (value) {
			case 1:
				CriarConta.criarContaPf(null);
				break;
			case 2:
				CriarConta.criarContaPoupanca(null);
				break;
			case 3:
				CriarConta.criarContaPj(null);
				break;	
		}
	}*/
	
	public static void menuCriarConta(String value, int opt) {
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
	}
	
	public static void cadastrarCliente(int value) {
		Scanner scan = new Scanner(System.in);
		switch (value) {
			case 1:
				System.out.print("Digite o seu nome completo: ");
				String nome = scan.nextLine();
				String nomeFormatado = formatarNome(nome);
				System.out.print("\n" + nomeFormatado + ", digite o seu CPF: ");
				String cpf = scan.nextLine();
				ClientePessoaFisica clientePf = CriarCilente.criarClientePf(nome, cpf);
				menuCriarConta(nomeFormatado, value);
				break;
			case 2:
				System.out.print("Digite o nome da empresa: ");
				String nomeEmpresa = scan.nextLine();
				System.out.print("\nDigite o CNPJ da empresa " + nomeEmpresa + ": ");
				String cnpj = scan.nextLine();
				ClientePessoaJuridica clientePj = CriarCilente.criarClientePj(nomeEmpresa, cnpj);
				menuCriarConta(nomeEmpresa, value);
				break;
			case 0:
				System.out.println("Saindo");
				break;
			default: 
				System.out.println("Opção informada inválida!");
				break;
		}
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
}
