package br.com.fatec.engine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

//http://www.devmedia.com.br/java-collections-set-list-e-iterator/29637
import br.com.fatec.modelo.Aluno;
import br.com.fatec.modelo.Pessoa;
import br.com.fatec.modelo.Professor;

public class Agenda {
	private List<Pessoa> pessoas;
	Scanner scan = new Scanner(System.in);

	public void opcoes() {
		System.out.println("1 - Cadastrar\n2 - Listar\n3 - Editar\n4 - Excluir\n5 - Sair\n");
	}

	public Agenda() {
		pessoas = new ArrayList<Pessoa>();
	}

	public void salvar(List<Pessoa> pessoas) throws Exception {
		FileOutputStream saida = new FileOutputStream("lista5.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(pessoas);
		saidaO.close();
	}

	// Recuperar os dados em disco
	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("lista5.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		List<Pessoa> p = (ArrayList<Pessoa>) entradaO.readObject();
		pessoas = p;
	}

	public void inserir() throws Exception {
		System.out.println("1 - Aluno \t2 - Professor");
		Pessoa novo;
		int n = scan.nextInt();
		System.out.println("Nome: ");
		String nome = scan.next();
		System.out.println("Telefone: ");
		String tel = scan.next();
		System.out.println("Email: ");
		String email = scan.next();
		if (n == 1) {
			System.out.println("Nº Matricula: ");
			String nmat = scan.next();
			novo = new Aluno(nome, tel, email, nmat);
			// alunos.add(novo);
		} else {
			System.out.println("Registro: ");
			String reg = scan.next();
			System.out.println("Quantidade Hora: ");
			String qtHora = scan.next();
			novo = new Professor(nome, tel, email, reg, qtHora);
			// professores.add(novo);
		}

		pessoas.add(novo);
		salvar(pessoas);
		System.out.println("CADASTRADO");
	}

	public void editar() throws Exception {
		listarTodos();
		System.out.println("1 - Aluno\t2 - Professor");
		int p = scan.nextInt();
		System.out.println("Indice para edição:");
		int indice = scan.nextInt();
		if (p == 1) {
			System.out.println("Nome: ");
			String nome = scan.next();
			System.out.println("Telefone: ");
			String tel = scan.next();
			System.out.println("Email: ");
			String email = scan.next();
			System.out.println("Nº Matricula: ");
			String nmat = scan.next();
			Aluno edit = new Aluno(nome, tel, email, nmat);
			pessoas.set(indice, edit);
		} else if (p == 2) {
			System.out.println("Nome: ");
			String nome = scan.next();
			System.out.println("Telefone: ");
			String tel = scan.next();
			System.out.println("Email: ");
			String email = scan.next();
			System.out.println("Registro: ");
			String reg = scan.next();
			System.out.println("Quantidade Hora: ");
			String qtHora = scan.next();
			Professor edit = new Professor(nome, tel, email, reg, qtHora);
			pessoas.set(indice, edit);
		} else
			editar();
		salvar(pessoas);
	}

	public void excluir() throws Exception {
		listarTodos();
		System.out.println("1 - Aluno\t2 - Professor");
		int p = scan.nextInt();
		System.out.println("Indice para exclusao:");
		int indice = scan.nextInt();
		if (p == 1)
			pessoas.remove(indice);
		else if (p == 2)
			pessoas.remove(indice);
		else
			excluir();
		salvar(pessoas);
	}

	public void listarTodos() throws Exception {
		receber();
		int i = 0;
		System.out.println("Lista de contatos de alunos: ");
		for (Pessoa pessoa : pessoas) {
			if(pessoa instanceof Aluno){
				System.out.println("ID: " + i + "\nNome: " + pessoa.getNome());
				System.out.println("Telefone: " + pessoa.getTelefone());
				System.out.println("Email: " + pessoa.getEmail());
				System.out.println("Nº Matricula: " + ((Aluno) pessoa).getNumeroMatricula() + "\n");
			}
			i++;
		}
		i = 0;
		System.out.println("Lista de contatos de professores");
		for (Pessoa pessoa : pessoas) {
			if (pessoa instanceof Professor) {
				System.out.println("ID: " + i + "\nNome: " + pessoa.getNome());
				System.out.println("Telefone: " + pessoa.getTelefone());
				System.out.println("Email: " + pessoa.getEmail());
				System.out.println("Registro: " + ((Professor) pessoa).getNumeoResistro());
				System.out.println("Quantidade Hora: " + ((Professor) pessoa).getQuantidaddeHoraAula() + "\n");
				
			}
			i++;
		}
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	
}
