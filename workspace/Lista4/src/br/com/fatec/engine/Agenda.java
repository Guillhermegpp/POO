package br.com.fatec.engine;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
//http://www.devmedia.com.br/java-collections-set-list-e-iterator/29637
import br.com.fatec.modelo.Aluno;
import br.com.fatec.modelo.Professor;

public class Agenda {
	private List<Aluno> alunos;
	private List<Professor> professores;
	Scanner scan = new Scanner(System.in);
	
	public void opcoes() {
		System.out.println("1 - Cadastrar\n2 - Listar\n3 - Editar\n4 - Excluir\n5 - Sair\n");
	}
	
	public Agenda() {
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
	}

	public void inserir(){
		System.out.println("1 - Aluno \t2 - Professor");
		int n = scan.nextInt();
		System.out.println("Nome: ");
		String nome = scan.next();
		System.out.println("Telefone: ");
		String tel = scan.next();
		System.out.println("Email: ");
		String email = scan.next();
		if (n == 1){
			System.out.println("Nº Matricula: ");
			String nmat = scan.next();
			Aluno novo = new Aluno(nome,tel,email,nmat);
			alunos.add(novo);
		}
		else{
			System.out.println("Registro: ");
			String reg = scan.next();
			System.out.println("Quantidade Hora: ");
			String qtHora = scan.next();
			Professor novo = new Professor(nome,tel,email,reg,qtHora);
			professores.add(novo);
		}
		System.out.println("CADASTRADO");
	}
	
	public void editar() {
		listarTodos();
		System.out.println("1 - Aluno\t2 - Professor");
		int p = scan.nextInt();
		System.out.println("Indice para edição:");
		int indice = scan.nextInt();
		if(p == 1) {
			System.out.println("Nome: ");
			String nome = scan.next();
			System.out.println("Telefone: ");
			String tel = scan.next();
			System.out.println("Email: ");
			String email = scan.next();
			System.out.println("Nº Matricula: ");
			String nmat = scan.next();
			Aluno edit = new Aluno(nome,tel,email,nmat);
			alunos.set(indice,edit);
		}
		else if(p == 2){
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
			Professor edit = new Professor(nome,tel,email,reg,qtHora);
			professores.set(indice,edit);
		}
		else
			editar();
	}
	
	public void excluir() {
		listarTodos();
		System.out.println("1 - Aluno\t2 - Professor");
		int p = scan.nextInt();
		System.out.println("Indice para exclusao:");
		int indice = scan.nextInt();
		if(p == 1) 
			alunos.remove(indice);
		else if(p == 2)
			professores.remove(indice);
		else
			excluir();
	}
	
	public void listarTodos(){
		System.out.println("Lista de contatos de alunos: ");
		int i=0;
		for (Aluno aluno : alunos) {
			System.out.println("ID: "+i+"\nNome: "+aluno.getNome());
			System.out.println("Telefone: "+aluno.getTelefone());
			System.out.println("Email: "+aluno.getEmail());
			System.out.println("Nº Matricula: "+aluno.getNumeroMatricula()+"\n");	
			i++;
		}
		System.out.println("Lista de contatos de professores");
		i =0 ;
		for (Professor professor : professores) {
			System.out.println("ID: "+i+"\nNome: "+professor.getNome());
			System.out.println("Telefone: "+professor.getTelefone());
			System.out.println("Email: "+professor.getEmail());
			System.out.println("Registro: "+professor.getNumeoResistro());
			System.out.println("Quantidade Hora: "+professor.getQuantidaddeHoraAula()+"\n");	
			i++;
		}
	}
	
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
}
