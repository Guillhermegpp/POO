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
					while(login.autenticacao() == false)
						telaInicial();
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
				case 7:{
					int o = 0;
					Usuarios login = new Usuarios();
					login.setContas(login.carregaUsuarios());
					login.imprimir();
					o = scan.nextInt();
					switch(o){
						case 1:{
							login.cadLogin();
							login.salvaUsuarios();;
							break;
						}
						case 2:{
							login.editLogin();
							login.salvaUsuarios();
							break;
						}
						case 3:{
							login.excLogin();
							login.salvaUsuarios();
							break;
						}
						case 4:{
							break;
						}
						default :{
							login.imprimir();
							break;
						}
					}
					break;
				}				
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
