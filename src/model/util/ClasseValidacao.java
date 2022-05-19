package model.util;

import java.util.Scanner;

public class ClasseValidacao {
	
	static Scanner scan = new Scanner(System.in);
	
	public static boolean verificarCpf(String value) {
		if (value.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) return true;
		return false;
	}
	
	public static String validarCpf(boolean value, String cpf) {
		do {
			value = verificarCpf(cpf);
			if (!value) {
				System.out.println("\nCPF inválido! Digite um CPF válido (000.000.000-00): ");
				cpf = scan.next();
			}
		} while (!value);
		
		return cpf;
	}
	
	public static boolean verificarCnpj(String value) {
		if (value.matches("\\d{2}.\\d{3}.\\d{3}/0001\\-\\d{2}")) return true;
		
		return false;
	}
	
	public static String validarCnpj(boolean value, String cnpj) {
		do {
			value = verificarCnpj(cnpj);
			if (!value) {
				System.out.println("\nCNPJ inválido! Digite um CNPJ válido (00.000.000/0001-00): ");
				cnpj = scan.next();
			}
		} while (!value);
		
		return cnpj;
	}
	
	public static boolean validarLetraInicialFinal(String value) {
		String nome = value;
		char primeiraLetra = nome.charAt(0);
		char ultimaLetra = nome.charAt(nome.length() - 1);
		
		if (Character.isAlphabetic(primeiraLetra) && Character.isAlphabetic(ultimaLetra)) return true;
		
		return false;
	}
	
	public static boolean validarNome(String value) {
		String nome = value;
		return nome.matches("[A-Z][a-zA-Z]{2,}");
	}
	
	public static String formatarPrimeiroNome(String value) {
		String[] vetor = value.split(" ");
		String nome = vetor[0];
		return nome;
	}
}
