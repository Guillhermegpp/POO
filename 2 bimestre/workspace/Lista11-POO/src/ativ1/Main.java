package ativ1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Agenda agenda = new Agenda();
		agenda.GetDB();
		boolean ciclo = true;
		while (ciclo) {
			System.out.println("1 - Cadastrar\n2 - Listar\n3 - Excluir\n4 - Sair\n");
			String op = scan.next();
			scan.nextLine();
			switch (op) {
			case "1":
				agenda.inserir();
				break;
			case "2":
				agenda.imprimir();
				break;
			case "3":
				agenda.excluir();
				
				break;
			case "4":
				ciclo = false;
				break;
			default:
				break;
			}

		}
	}
}
