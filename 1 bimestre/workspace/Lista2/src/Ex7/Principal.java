package Ex7;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Empregado emp = new Empregado();
		System.out.println("Horas trabalhadas: ");
		emp.horas = sc.nextDouble();
		System.out.println("Valor da hora: ");
		emp.valor = sc.nextDouble();
		
		System.out.println("Salario Bruto: "+emp.salario());
		sc.close();


	}

}
