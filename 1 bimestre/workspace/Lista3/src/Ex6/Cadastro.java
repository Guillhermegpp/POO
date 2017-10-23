package Ex6;

import java.util.Scanner;

public class Cadastro {
	private Cliente[] clientes;
	private Scanner scan;
	private String mes[] = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
	private double[] Smeses;

	public Cadastro() {
		clientes = new Cliente[10];
		scan = new Scanner(System.in);
		Smeses = new double[12];
	}


	public Cliente[] getClientes() {
		return clientes;
	}


	public void setClientes(Cliente[] clientes) {
		this.clientes = clientes;
	}


	public void printopcoes() {
		System.out.println("1 - Listar\n2 - Cadastrar\n3 - Editar\n4 - Excluir\n5 - Sair");		
	}
	public void cadastrarCliente() {
		for (int i = 0; i < clientes.length; i++) {
			if(clientes[i] == null) {
				System.out.println("Nome: ");
				String nome = scan.next();

				System.out.println("Email: ");
				String email = scan.next();

				System.out.println("Telefone: ");
				String telefone = scan.next();

				System.out.println("Endereço: ");
				String endereco = scan.next();

				double meses[] = new double[12];
				System.out.println("Rendimento mensal(R$): ");
				for (int j = 0; j < 12; j++) {
					System.out.printf(mes[j]+": ");
					meses[j] = scan.nextDouble();
				}
				Cliente novo = new Cliente(nome,email,telefone,endereco,meses);
				clientes[i] = novo;
				i++;
				System.out.println("\nAdicionado com sucesso!!!");
				System.out.println(clientes[i].somar());
				break;
			}
		}
	}

	public void imprimirCliente() {
		int i =0;
		for (Cliente cliente : clientes) {
			if(cliente != null) {
				System.out.printf("\nIndice: " + i 
						+ "\nNome: "+cliente.getNome()
						+"\nEmail: "+cliente.getEmail()
						+"\nTelefone: "+cliente.getTelefone()
						+"\nEndereço: "+cliente.getEndereco()
						+"\nMeses: ");
				for (int k = 0; k < 12; k++) {
					System.out.print(mes[k]+": R$"+cliente.meses[k]+"\n");
				}
				System.out.println("\nRendimento Total: R$"+cliente.somar()+"\n");
				i++;
			}	
		}
	}

	public void excluirCliente() {
		System.out.println("Digite o indice para o contato ser excluido: ");
		int c = scan.nextInt();
		System.out.println("Excluir indice " + c +", Nome: "+ clientes[c].getNome()+ "? (S/N)");
		String r = scan.next();
		if (r.toUpperCase().equals("S")) {
			clientes[c] = null;
			System.out.println("Cadastro Excluido");
		}

	}

	public void editarCliente() {
		imprimirCliente();
		System.out.println("Digite o indice para editar o contato: ");
		int c = scan.nextInt();
		System.out.println("Editar indice " + c +", Nome: "+ clientes[c].getNome()+ "? (S/N)");
		String r = scan.next();
		if (r.toUpperCase().equals("S")) {
			System.out.println("Nome atual: "+clientes[c].getNome() +"\nNome: ");
			String nome = scan.next();

			System.out.println("Email atual: "+clientes[c].getEmail() +"\nEmail: ");
			String email = scan.next();

			System.out.println("Telefone  atual: "+clientes[c].getTelefone() +"\nTelefone: ");
			String telefone = scan.next();

			System.out.println("Endereço  atual: "+clientes[c].getEndereco() +"\nEndereço: ");
			String endereco = scan.next();
			double meses[] = new double[12];

			System.out.println("Rendimento mensal(R$): ");
			for (int j = 0; j < 12; j++) {
				System.out.printf(clientes[c].meses[j] + " / "+mes[j]+": ");
				meses[j] = scan.nextDouble();
			}
			Cliente novo = new Cliente(nome,email,telefone,endereco,meses);
			clientes[c] = novo;

			System.out.println("\nEditado com sucesso!!!");
		}
	}
//Metodo de teste!!!****************************************************************************
	public void teste() {
		double meses[] = new double[12];
		for (int i = 0; i < mes.length; i++) {
			meses[i]= 158+i;
		}
		Cliente novo = new Cliente("guilherme","guibassuai","6456465460","oijdsfsd",meses);
		clientes[0] = novo;
		for (int i = 0; i < mes.length; i++) {
			meses[i]= 25+i;
		}
		novo = new Cliente("joao","guibassuai","6456465460","oijdsfsd",meses);
		clientes[1] = novo;
	}
//**************************************************************************************************
	public double[] calcMeses() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; clientes[j] != null; j++) {
				Smeses[i] += clientes[j].meses[i];
			}
		}
		return Smeses;
	}

	public void relatorio() {
		double soma = 0;
		//Soma o total de gastos de todos os meses e clientes
		for (int i = 0; clientes[i] != null; i++) {
			soma+= clientes[i].somar();
		}
		System.out.println("Total gasto: R$"+soma);
		calcMeses();
		//Soma o total de gastos por mes de todos os clientes
		System.out.println("Total de gasto por mes: ");
		for (int i = 0; i < 12; i++) {
			System.out.println(mes[i] + " : R$" + Smeses[i]);
		}
		maior();
	}
	
	public void maior() {
		double maior = 0;
		int indice = 0;

		//Mostra qual cliente gastou mais no total
		maior = 0;
		for (int j = 0; clientes[j] != null; j++) {
			if (maior < clientes[j].somar()) {
				maior = clientes[j].somar();
				indice = j;
			}
		}
		System.out.println("Quem mais gastou: " +" Nome: "+ clientes[indice].getNome() +" Valor : " + maior + "\n");


		//Mostra o cliente que mais gastou de cada mes
		for (int i = 0; i < 12; i++) {
			maior = 0;
			for (int j = 0; clientes[j] != null; j++) {
				if (clientes[j].meses[i] > maior) {
					maior = clientes[j].meses[i];
					indice = j;
				}
			}
			System.out.println("Mes: "+mes[i] +" Nome: "+ clientes[indice].getNome() +" Valor : "+ maior);
		}
	}
}
