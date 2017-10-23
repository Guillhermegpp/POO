package Ex2;

import java.util.Scanner;

public class Quadrado {
	private int n;
	private Scanner scan = new Scanner(System.in);
	
	public void recebeN() {
		System.out.println("Digite um numero: ");
		n = scan.nextInt();
	}
	
	public void imprimir(){
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf(" *");
			}System.out.println();
		}
	}
	
	public Scanner getScan() {
		return scan;
	}
	public void setScan(Scanner Scan) {
		this.scan = Scan;
	}
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
}
