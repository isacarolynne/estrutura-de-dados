package com.algoritmos.arvore_binaria;

public class ArvoreBinaria {

	Node raiz;

	public void imprimir() {
		imprimirPorOrdem(raiz);
	}

	private void imprimirPorOrdem(Node node) {
		if (node != null) {
			imprimirPorOrdem(node.esquerda);
			System.out.print(node.getValor() + " ");
			imprimirPorOrdem(node.direita);
		}
	}

	private boolean validarCaractere(char valor) {
		if (valor >= '0' && valor <= '9') {
			return false;
		} else {
			return true;
		}
	}

	public boolean buscar(char valor) throws NullPointerException {
		if (raiz == null) {
			throw new NullPointerException("Árvore Vazia!");
		} else {
			return buscar(raiz, valor);
		}
	}

	private boolean buscar(Node n, char valor) {
		if (n == null) {
			return false;
		} else {
			if (n.valor == valor) {
				return true;
			} else if (valor > n.valor) {
				return buscar(n.direita, valor);
			} else if (valor < n.valor) {
				return buscar(n.esquerda, valor);
			} else {
				return false;
			}
		}
	}

	public void inserir(char valor) {
		inserir(raiz, valor);
	}

	private void inserir(Node n, char valor) {
		if (validarCaractere(valor)) {

			if (n == null) {
				this.raiz = (new Node(valor));
			} else if (buscar(n, valor)) {
				System.out.println("O No já existe, " + "não pode adicionar número igual");

			} else {
				if (valor < n.getValor()) {
					if (n.getEsquerda() != null) {
						inserir(n.getEsquerda(), valor);
					} else {
						n.esquerda = (new Node(valor));
					}
				} else if (valor > n.getValor()) {
					if (n.getDireita() != null) {
						inserir(n.direita, valor);
					} else {
						n.direita = (new Node(valor));
					}
				}

			}
		} else {
			System.out.println("No inválido!");
		}
	}

	public void remover(char valor) {
		if (raiz == null) {
			System.out.println("Árvore Vazia!");
		} else {
			remover(raiz, valor);

		}
	}

	private Node remover(Node node, char valor) {
		Node nodeAuxDireito = null;
		Node nodeAux = null;

		if (buscar(node, valor)) {

			if (node.valor == valor) {
				if (node.esquerda == node.direita) { // Se o Nó não possuir ramos (filhos) ou possuir ramos iguais
					node = null;
				} else if (node.esquerda == null) { // Se o Nó não possuir o ramo esquerdo
					node = node.direita;
				} else if (node.direita == null) { // Se o Nó não possuir o ramo direito
					node = node.esquerda;
				} else { // Se o Nó possuir os ramos direito e esquerdo
					nodeAuxDireito = node.direita;
					nodeAux = nodeAuxDireito;

					while (nodeAuxDireito.esquerda != null) { // Percorre todos os nodes do ramo esquerdo
						nodeAux = nodeAuxDireito;
						nodeAuxDireito = nodeAuxDireito.esquerda;
					}

					node.valor = nodeAuxDireito.valor;

					if (nodeAuxDireito.equals(nodeAux)) {
						while (nodeAuxDireito.direita != null) { // Percorre todos os nodes do ramo direito
							node.direita = nodeAuxDireito.direita;
							nodeAuxDireito = nodeAuxDireito.direita;
						}
					}

					if (nodeAux.direita == null) {
						nodeAux = node.direita;
						if (nodeAux.valor == node.valor)
							node.direita = null;
					}

					nodeAux.esquerda = null;
					nodeAuxDireito = null;

					return node;
				}
			} else if (node.valor > valor) {
				node.esquerda = (remover(node.esquerda, valor));
			} else {
				node.direita = (remover(node.direita, valor));
			}
			this.raiz = node;

			return node;
		} else {
			System.out.println("No Inexistente!");
		}

		return node;
	}
}
