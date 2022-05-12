package model.entities;

import java.util.Random;

public class NumeroConta {
	
	// classe para gerar número de conta aleatório
	public String gerarNumeroConta() {
		Random gerador = new Random();
		String[] numeroConta = new String[8];
		for (int i = 0; i < 8; i++) {
			int numeroGerado = gerador.nextInt(9)+1;
			numeroConta[i] = Integer.toString(numeroGerado);
		}
		String obj = "";
		String juncao = "";
		
		for (int i = 0; i < 8; i++) {
		    obj = numeroConta[i];
		    if (i == 6) {
		        obj = "-";
		    }
		    juncao += obj;
		}
		return juncao;
	}
}
