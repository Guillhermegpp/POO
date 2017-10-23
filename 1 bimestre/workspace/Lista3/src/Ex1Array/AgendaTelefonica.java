package Ex1Array;

import java.util.Scanner;

public class AgendaTelefonica {
	private Pessoa[] pessoas;
	private Scanner scanner;
	
	public AgendaTelefonica() {
		pessoas = new Pessoa[5];
		scanner = new Scanner(System.in);
	}
	
	public void cadastrarPessoa() {
		for (int i = 0; i < pessoas.length; i++) {
			if(pessoas[i] == null) {
				System.out.println("\nInsira um nome para a pessoa: ");
				String nome = scanner.next();
				System.out.println("\nInsira um telefone para a pessoa: ");
				String telefone = scanner.next();
				System.out.println("\nInsira um email para a pessoa: ");
				String email = scanner.next();
				Pessoa nova = new Pessoa(nome,telefone,email);
				pessoas[i] = nova;
				System.out.println("\nNovo contato adicionado\n");
				break;				
			}
		}
	}
	
	public void imprimirOpcoes() {
		System.out.println("\nEscolha uma das opções: ");
		System.out.println("1- Listar contatos: ");
		System.out.println("2- Incluir contatos: ");
		System.out.println("2- Excluir contatos: ");
		System.out.println("3- Sair: ");
	}
	
	public void imprimirPessoas() {
		int i =0;
		for (Pessoa pessoa : pessoas) {
			if(pessoa != null) {
				System.out.println("\nIndice: " + i 
					+ "\nNome: "+pessoa.getNome()
					+"\nTelefone: "+pessoa.getTelefone()
					+"\nEmail: "+pessoa.getEmail());
				i++;
				
			}
		}
	}

	public Pessoa[] getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(Pessoa[] pessoas) {
		this.pessoas = pessoas;
	}
	
	public void excluirPessoa() {
		System.out.println("Digite o indice para o contato ser excluido: ");
		int c = scanner.nextInt();
		System.out.println("Excluir indice " + c +" "+ pessoas[c].getNome()+ "? (S/N)");
		String r = scanner.next();
		if (r.toUpperCase().equals("S")) {
			pessoas[c] = null;
			System.out.println("Cadastro Excluido");
		}
	}
}

