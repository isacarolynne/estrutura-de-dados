package com.algoritmos.arvore_binaria;

public class Node {

	Node esquerda;
	Node direita;
	char valor;

	public Node() {

	}

	public Node getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Node esquerda) {
		this.esquerda = esquerda;
	}

	public Node getDireita() {
		return direita;
	}

	public void setDireita(Node direita) {
		this.direita = direita;
	}

	public Node(char valor) {
		this.valor = valor;
	}

	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}
}
