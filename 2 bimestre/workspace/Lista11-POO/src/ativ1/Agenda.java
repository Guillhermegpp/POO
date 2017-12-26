package ativ1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Agenda {
	Collection<Pessoa> agenda;
	Scanner scan;
	boolean add = false;
	public boolean f;

	public Agenda() {
		agenda = new TreeSet<Pessoa>();
		// agenda = new HashSet<Pessoa>();
		scan = new Scanner(System.in);
	}

	public void inserir() {
		System.out.println("Nome: ");
		String nome = scan.next();
		System.out.println("Email: ");
		String email = scan.next();
		System.out.println("Telefone: ");
		String telefone = scan.next();
		try {
			cadastrar(nome, email, telefone);
			if (add)
				System.out.println("Contato adicionado");
			else
				System.out.println("Contato repetido");
		} catch (Exception e) {
			System.out.println("Algo deu errado");
		}
	}

	public void salvar(Collection<Pessoa> agenda2) throws Exception {
		FileOutputStream saida = new FileOutputStream("lista11.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(agenda2);
		saidaO.close();
	}

	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("lista11.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		Set<Pessoa> p = (Set<Pessoa>) entradaO.readObject();
		agenda = p;
	}

	public void GetDB() {
		new Thread() {

			@Override
			public void run() {
				try {
					receber();
				} catch (Exception e) {

				}
			}
		}.start();

	}

	public void cadastrar(String n, String e, String t) {
		new Thread() {

			@Override
			public void run() {
				if (agenda.add(new Pessoa(n, e, t)) == false)
					add = true;
				try {
					salvar(agenda);
				} catch (Exception e1) {
				}

			}
		}.start();

	}

	public void excluir() throws InterruptedException {
		
		f = false;
		System.out.println("Digite o nome que deseja excluir: ");
		String nome = scan.nextLine();
		Iterator<Pessoa> it = agenda.iterator();
		while (it.hasNext()) {
			if (it.next().nome.equalsIgnoreCase(nome)) {
				System.out.println("Deseja realmente excluir " + nome + " da agenda?? (S/N)");
				String r = scan.next();
				scan.nextLine();
				if (r.equalsIgnoreCase("S")) {
					System.out.println("Excluido");
					Excluir(nome);
				}
				f = true;
			}
		}
		if (!f)
			System.out.println("Nao encontrado");

	}

	public void Excluir(String nome) {
		new Thread() {

			@Override
			public void run() {
				Iterator<Pessoa> it = agenda.iterator();
				while (it.hasNext()) {
					if (it.next().nome.equalsIgnoreCase(nome)) {
						it.remove();
						try {
							salvar(agenda);
						} catch (Exception e) {
							System.out.println("Erro");
						}
					}
				}

			}
		}.start();

	}

	public void ordenar() {
		ArrayList<Pessoa> a = (ArrayList<Pessoa>) agenda;
		Collections.sort(a);
		agenda = a;
	}

	public void imprimir() {
		for (Pessoa pessoa : agenda) {
			pessoa.toString();
		}
	}

}
