package Exercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Estoque es = new Estoque();
		Scanner scan = new Scanner(System.in);
		
		int sair = 0;
		int opcao = 0;
		while(sair == 0) {
			switch(opcao) {
			case 0:{//Imprime as opcoes
				es.printopcoes();
				opcao = scan.nextInt();
				break;
			}
			
			case 1:{//1 - Cadastrar
				es.cadastrar();
				opcao = 0;
				break;
			}
			case 2:{//2 - Relatório
				es.relatorio();
				opcao = 0;
				break;
			}
			case 3:{//3 - Editar
				es.editar();
				opcao = 0;
				break;
			}
			case 4: {//4 - Excluir
				es.excluir();
				opcao = 0;
				break;
			}
			case 5:{//5 - Sair
				sair = 1;
				System.out.println("\nAplicação finalizada!\n");
				break;
			}
			default:{
				es.printopcoes();
				opcao = scan.nextInt();
			}
			}
		}
		scan.close();
	}
}
