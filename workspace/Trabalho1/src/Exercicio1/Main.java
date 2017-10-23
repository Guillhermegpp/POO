package Exercicio1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Estoque es = new Estoque();
		Scanner scan = new Scanner(System.in);
		es.setProdutos(es.receber());
		int sair = 0;
		int opcao = 0;
		while(sair == 0) {
			switch(opcao) {
			case 0:{//Imprime as opcoes
				es.printopcoes();
				opcao = scan.nextInt();
				break;
			}
			case 1:{
				es.cadastrar();
				opcao = 0;
				break;
			}
			case 2:{
				es.baixa();
				opcao = 0;
				break;
			}
			case 3:{
				es.relatorio();
				opcao = 0;
				break;
			}
			case 4: {
				es.excluir();
				opcao = 0;
				break;
			}
			case 5:{
				es.editar();
				opcao = 0;
				break;
			}
			case 6:{//Nova Qualificacao
				es.newcoment();
				opcao = 0;
				break;
			}
			case 7:{//Sair
				es.imprimirComments();
				opcao = 0;
				break;
			}
			case 8:{//Sair
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
