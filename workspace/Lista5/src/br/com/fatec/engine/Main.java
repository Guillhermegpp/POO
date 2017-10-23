package br.com.fatec.engine;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Agenda agenda = new Agenda();
		Scanner scan = new Scanner(System.in);
		int sair = 0;
		int opcao = 0;

		while(sair == 0) {
			switch(opcao) {
			case 0:{
				agenda.opcoes();
				opcao = scan.nextInt();
				break;
			}
			case 1:{
				agenda.inserir();
				opcao = 0;
				break;
			}
			case 2:{
				agenda.listarTodos();
				opcao = 0;
				break;
			}
			case 3: {
				agenda.editar();
				opcao = 0;
				break;
			}
			case 4:{
				agenda.excluir();
				opcao = 0;
				break;
			}
			case 5:{
				sair = 1;
				System.out.println("\nAté mais!\n");
				break;
			}
			default:{
				agenda.opcoes();
				opcao = scan.nextInt();
			}
			}
		}
		scan.close();
	}

}
