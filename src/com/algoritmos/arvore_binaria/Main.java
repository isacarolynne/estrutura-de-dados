package com.algoritmos.arvore_binaria;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		ArvoreBinaria arvore = new ArvoreBinaria();

		exibirMenu(arvore, dados);
		dados.close();
	}

	public static void exibirMenu(ArvoreBinaria arvore, Scanner dados) {
		int opcao = 0;
		char letra;
		do {
			System.out.println("Escolha uma opção: " + "\n1.Inserir \n2.Remover \n3.Buscar \n4.Exibir \n0.Sair");

			opcao = dados.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite uma letra para inserção: ");
				letra = dados.next().charAt(0);
				arvore.inserir(letra);
				break;
			case 2:
				System.out.println("Digite uma letra para remoção: ");
				letra = dados.next().charAt(0);
				arvore.remover(letra);
				break;
			case 3:
				System.out.println("Digite uma letra para busca: ");
				letra = dados.next().charAt(0);
				try {
					if (arvore.buscar(letra))
						System.out.println("Nó: " + letra + " existe!");
					else
						System.out.println("Nó: " + letra + " inexistente!");
				} catch (NullPointerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("\nExibindo em Ordem:  ");
				arvore.imprimir();
				System.out.println();
				break;
			case 0:
				opcao = 0;
				break;
			}
		} while (opcao != 0);
	}

}
