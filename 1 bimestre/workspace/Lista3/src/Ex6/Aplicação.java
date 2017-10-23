package Ex6;

import java.util.Scanner;

public class Aplicação {

	public static void main(String[] args) {
		Cadastro cad= new Cadastro();
		Scanner scan = new Scanner(System.in);
		cad.teste();
		cad.imprimirCliente();
		cad.relatorio();
		/*int sair = 0;
		int opcao = 0;
		while(sair == 0) {
			switch(opcao) {
			case 0:{//Imprime as opcoes
				cad.printopcoes();
				opcao = scan.nextInt();
				break;
			}
			case 1:{//Lista os clientes
				cad.relatorio();
				opcao = 0;
				break;
			}
			case 2:{//Cadastra um novo Cliente
				cad.cadastrarCliente();
				opcao = 0;
				break;
			}
			case 3: {//Edita um cliente
				cad.editarCliente();
				opcao = 0;
				break;
			}
			case 4: {//Exclui um cliente
				cad.excluirCliente();
				opcao = 0;
				break;
			}
			case 5:{//Sair
				sair = 1;
				System.out.println("\nAplicação finalizada!\n");
				break;
			}
			default:{
				cad.printopcoes();
				opcao = scan.nextInt();
			}
			}
		}
		*/
		scan.close();
	}

}
