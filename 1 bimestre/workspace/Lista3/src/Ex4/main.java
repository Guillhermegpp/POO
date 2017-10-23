package Ex4;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a,b;
		a = scan.nextInt();
		b = scan.nextInt();
		System.out.println(Multiplicidade.multiplo(a, b));
		
	}
}
