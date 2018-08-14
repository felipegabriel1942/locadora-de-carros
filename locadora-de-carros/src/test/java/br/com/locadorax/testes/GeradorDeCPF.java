package br.com.locadorax.testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeradorDeCPF {

	public static void main(String[] args) {
		System.out.println("O CPF gerado foi: " + gerarCPF());
	}

	public static String gerarCPF() {

		// Atributos
		int somatorio = 0;
		int peso = 10;
		int resto = 0;
		int primeiroDigitoVerificador = 0;
		int segundoDigitoVerificador = 0;

		Random gerador = new Random();
		List<Integer> listaDeNumeros = new ArrayList<Integer>();

		// Lista com os valores gerados
		for (int i = 0; i < 9; i++) {
			listaDeNumeros.add(gerador.nextInt(10));
		}

		for (int i = 0; i < 9; i++) {
			somatorio = somatorio + (peso * listaDeNumeros.get(i));
			peso--;

		}

		resto = somatorio % 11;

		if (resto < 2) {
			primeiroDigitoVerificador = 0;
		} else {
			primeiroDigitoVerificador = 11 - resto;
		}

		listaDeNumeros.add(listaDeNumeros.size(), primeiroDigitoVerificador);

		// reiniciando variaveis
		somatorio = 0;
		resto = 0;
		peso = 11;

		for (int i = 0; i < 10; i++) {
			somatorio = somatorio + (peso * listaDeNumeros.get(i));
			peso--;

		}

		resto = somatorio % 11;

		if (resto < 2) {
			segundoDigitoVerificador = 0;
		} else {
			segundoDigitoVerificador = 11 - resto;
		}

		listaDeNumeros.add(listaDeNumeros.size(), segundoDigitoVerificador);

		return converteListaCPFEmString(listaDeNumeros);
	}

	public static String converteListaCPFEmString(List<Integer> lista) {
		List<String> listaCPFString = new ArrayList<String>();
		String cpfString = "";

		for (int i = 0; i < lista.size(); i++) {
			listaCPFString.add(lista.get(i).toString());
		}

		for (int i = 0; i < listaCPFString.size(); i++) {
			cpfString += listaCPFString.get(i);

		}

		return cpfString;
	}
}
