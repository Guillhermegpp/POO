package lista7;
import java.util.Arrays;
import java.util.Scanner;

public class PrincipalCaixa {
	
	public static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		DBLogin contas = new DBLogin();
		contas.setContas(contas.loadDB());
		while(contas.efetuarLogin() == false);		
		
		Caixa caixa = new Caixa();
		caixa.movimentacoes = caixa.loadCaixa();
		int option = 0;
		boolean rodar = true;
		while(rodar){
			caixa.imprime();
			caixa.imprimeOpcoes();
			option = input.nextInt();
			switch(option){
				case 1:{
					caixa.imprimeEntradas();
					caixa.addEntrada();
					break;
				}
				case 2:{
					caixa.imprimeEntradas();
					caixa.editEntrada();
					break;
				}
				case 3:{
					caixa.imprimeEntradas();
					caixa.delEntrada();
					break;					
				}
				case 4:{
					caixa.imprimeSaidas();
					caixa.addSaida();
					break;					
				}
				case 5:{
					caixa.imprimeSaidas();
					caixa.editSaida();
					break;					
				}
				case 6:{
					caixa.imprimeSaidas();
					caixa.delSaida();
					break;
				}
				case 7:{
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
				}				
				case 8:{
					rodar = false;
					System.out.println("Até logo.");
					caixa.saveCaixa();
					break;
				}
				default :{
					System.out.println("Opção Inválida.");
				}
			}
		}
	}
}
