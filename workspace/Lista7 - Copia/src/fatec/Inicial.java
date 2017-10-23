package fatec;

import java.util.Scanner;



public class Inicial {
	static Scanner scan = new Scanner(System.in);
	
	public static void telaInicial() {

		Usuarios login = new Usuarios();
		login.setContas(login.carregaUsuarios());
		System.out.println("1 - Entrar\n"
				+ "2 - Cadastrar usuario");
		
		int option = 0;
		boolean rodar = true;
		while(rodar){
			option = scan.nextInt();
			switch(option){
				case 1:{
					while(login.autenticacao() == false);
					depoisLogin();
					break;
				}
				case 2:{
					login.cadLogin();
					login.salvaUsuarios();
					telaInicial();
					break;
				}
								
				case 3:{
					rodar = false;
					System.out.println("Programa encerrado.");
					break;
				}
				default :{
					telaInicial();
				}
			}
		}
	}
	
	public static void depoisLogin() {
		Estoque caixa = new Estoque();
		caixa.setFluxo(caixa.loadCaixa());
		int option = 0;
		boolean rodar = true;
		while(rodar){
			caixa.imprimir();
			caixa.opcoes();
			option = scan.nextInt();
			switch(option){
				case 1:{
					caixa.printEntradas();
					caixa.cadEntrada();
					break;
				}
				case 2:{
					caixa.printSaidas();
					caixa.cadSaida();
					break;
				}
				case 3:{
					caixa.printEntradas();
					caixa.editEntrada();
					break;					
				}
				case 4:{
					caixa.printSaidas();
					caixa.editSaida();
					break;					
				}
				case 5:{
					caixa.printEntradas();
					caixa.excEntrada();
					break;					
				}
				case 6:{
					caixa.printSaidas();
					caixa.excSaida();
					break;
				}
				/*case 7:{
					int o = 0;
					contas.imprime();
					o = input.nextInt();
					switch(o){
						case 1:{
							contas.addLogin();
							contas.saveDB();
							break;
						}
						case 2:{
							contas.editLogin();
							contas.saveDB();
							break;
						}
						case 3:{
							contas.delLogin();
							contas.saveDB();
							break;
						}
						case 4:{
							break;
						}
						default :{
							System.out.println("Opção inválida.\n");
							break;
						}
					}
					break;
				}				*/
				case 8:{
					rodar = false;
					System.out.println("Programa encerrado.");
					caixa.salvaCaixa();
					break;
				}
				default :{
					depoisLogin();
				}
			}
		}
	}
}
