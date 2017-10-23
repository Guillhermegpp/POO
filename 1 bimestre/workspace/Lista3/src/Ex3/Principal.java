package Ex3;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Estacionamento cr1 = new Estacionamento();

		System.out.println("Horas: ");
		cr1.hora = sc.nextInt();
		System.out.println("Minutos: ");
		cr1.min = sc.nextInt();
		System.out.println("Cobrança: R$"+cr1.cobranca());
		sc.close();
	}

}
