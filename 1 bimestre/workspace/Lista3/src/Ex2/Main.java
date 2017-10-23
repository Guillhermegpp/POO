package Ex2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Produto p1= new Produto();
		Scanner sc = new Scanner(System.in);
		double b=0;
		String resp = "S";
		System.out.println("Codigos: P1 P2 P3 P4");
		System.out.println("Codigo Quantidade");
		while(resp.equals("S")) {
			p1.code = sc.next();
			p1.qt = sc.nextInt();
			b = p1.somar(b);
			System.out.printf("Adicionar mais produto? (S/N)");
			resp = sc.next();
			
		}
		System.out.println("Valor Total: R$"+b);
		p1.imprimir();
		
		sc.close();
	}
	
}
