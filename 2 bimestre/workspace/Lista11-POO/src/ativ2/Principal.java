package ativ2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Tamanho do vetor: ");
		int n = scan.nextInt();
		int v[] = new int[n];
		for (int i = 0; i < v.length; i++) {
			System.out.printf("A[%d]: ",i);
			v[i] = scan.nextInt();
		}
		
		int r = indiceEquilibrio(v);
		if (r != -1) 
			System.out.println("Indice de Equibrio: "+ r);
		else
			System.out.println("Não existe indice de equilibrio");
		
	}

	public static int indiceEquilibrio(int A[]) {
		int somaA = 0, somaB = 0;
		int p;
		for (int i = 0; i < A.length; i++) {
			somaA += A[i];
			for (int j = i + 2; j < A.length; j++) {
				somaB += A[j];
			}
			if (somaA == somaB) {
				p = i + 1;
				return p;
			} else
				somaB = 0;
		}
		return -1;
	}

}
