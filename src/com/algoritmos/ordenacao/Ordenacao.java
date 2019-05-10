package com.algoritmos.ordenacao;

import java.util.Arrays;

public class Ordenacao {

	public static void quickSorte(int[] array, int esquerda, int direita) {
		int esquerd = esquerda;
		int direit = direita;
		int pivo = array[esquerda];
		int aux;

		while (esquerd <= direit) {
			while (array[esquerd] < pivo) {
				esquerd++;
			}

			while (array[direit] > pivo) {
				direit--;
			}

			if (esquerd <= direit) {
				aux = array[esquerd];
				array[esquerd] = array[direit];
				array[direit] = aux;

				esquerd++;
				direit--;
			}
		}

		if (direit > esquerda)
			quickSorte(array, esquerda, direit);
		if (esquerd < direita)
			quickSorte(array, esquerd, direita);
	}

	public static void insertionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int aux = array[i];
			for (int a = i - 1; a >= 0 && array[a] > aux; a--) {
				array[a + 1] = array[a];
				array[a] = aux;
			}
		}
	}

	public void selectionSort(int[] array, int tamanho) {
		int minimo, aux;
		for (int i = 0; i < (tamanho - 1); i++) {
			minimo = i;
			for (int a = (i + 1); a < tamanho; a++) {
				if (array[a] < array[minimo])
					minimo = a;
			}
			if (array[i] != array[minimo]) {
				aux = array[i];
				array[i] = array[minimo];
				array[minimo] = aux;
			}
		}
	}

	public void mergeSort(int[] array) {
		int n = array.length;

		if (n < 2)
			return;

		int middle = n / 2;

		int[] esquerda = Arrays.copyOfRange(array, 0, middle);
		int[] direita = Arrays.copyOfRange(array, middle, n);

		mergeSort(esquerda);
		mergeSort(direita);
		merge(esquerda, direita, array);

	}

	private void merge(int[] esquerda, int[] direita, int[] finalArray) {
		int nEsquerda = esquerda.length;
		int nDireita = direita.length;

		int indexEsquerda = 0;
		int indexDireita = 0;
		int indexArray = 0;

		while (indexEsquerda < nEsquerda && indexDireita < nDireita) {

			if (esquerda[indexEsquerda] <= direita[indexDireita]) {
				finalArray[indexArray] = esquerda[indexEsquerda];
				indexEsquerda++;
			} else {
				finalArray[indexArray] = direita[indexDireita];
				indexDireita++;
			}

			indexArray++;
		}

		while (indexEsquerda < nEsquerda) {
			finalArray[indexArray] = esquerda[indexEsquerda];
			indexEsquerda++;
			indexArray++;
		}

		while (indexDireita < nDireita) {
			finalArray[indexArray] = direita[indexDireita];
			indexDireita++;
			indexArray++;
		}
	}
}
