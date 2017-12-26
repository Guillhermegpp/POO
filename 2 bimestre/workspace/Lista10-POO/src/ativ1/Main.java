package ativ1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Agenda agenda = new Agenda();
		agenda.GetDB();
		boolean ciclo = true;
		while (ciclo) {
			System.out.println("1 - Cadastrar\n2 - Listar\n3 - Excluir\n4 - Sair\n");
			String op = scan.next();
			switch (op) {
			case "1":
				agenda.inserir();
				break;
			case "2":
				agenda.imprimir();
				break;
			case "3":
				agenda.remover();
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
