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
}
