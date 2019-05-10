package com.algoritmos.ordenacao;

public class Main {

	public static void main(String[] args) {

		Ordenacao ordenacao = new Ordenacao();

		int[] array1 = { 5, 1, 9, 3, 10, 8, 7, 22, 14 };
		Ordenacao.quickSorte(array1, 0, array1.length - 1);

		int[] array2 = { 2, 1, 9, 25, 10, 6, 11, 20, 12 };
		Ordenacao.insertionSort(array2);

		int[] array3 = { 5, 1, 4, 8, 23, 6, 9, 2, 15 };
		ordenacao.selectionSort(array3, 9);

		int[] array4 = { 2, 1, 5, 7, 12, 18, 27, 9, 10 };
		ordenacao.mergeSort(array4);

		System.out.print("QuickSorte: ");
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
		System.out.println();
		System.out.print("InsertionSort: ");
		for (int a = 0; a < array2.length; a++) {
			System.out.print(array2[a] + " ");
		}
		System.out.println();
		System.out.print("SelectionSort: ");
		for (int e = 0; e < array3.length; e++) {
			System.out.print(array3[e] + " ");
		}
		System.out.println();
		System.out.print("MergeSort: ");
		for (int o = 0; o < array4.length; o++) {
			System.out.print(array4[o] + " ");
		}
	}

}
