package ativ1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
	private ArrayList<Pessoa> pessoas;
	private Scanner scan;
	private String nome,email,tel;
	
	
	public Agenda() {
		pessoas = new ArrayList<>();
		scan = new Scanner(System.in);
	}
	
	public void salvar(ArrayList<Pessoa> pessoas) throws Exception {
		FileOutputStream saida = new FileOutputStream("lista5.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(pessoas);
		saidaO.close();
	}
	
	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("lista5.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		ArrayList<Pessoa> p = (ArrayList<Pessoa>) entradaO.readObject();
		pessoas = p;
	}
	
	public void GetDB(){
		new Thread() {
			
			@Override
			public void run() {
				try {
					receber();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
			}
		}.start();

	}
	
	public void Cadastrar(String n,String e,String t){
		new Thread() {
			
			@Override
			public void run() {
				pessoas.add(new Pessoa(n,e,t));
				try {
					salvar(pessoas);
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
				
			}
		}.start();

	}
	
	
	void inserir() {
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Email: ");
		email = scan.nextLine();
		System.out.println("Tel: ");
		tel = scan.nextLine();
		Cadastrar(nome,email,tel);

		System.out.println("Cadastrado!!!");
	}
	public void Excluir(int index){
		new Thread() {
			
			@Override
			public void run() {
				pessoas.remove(index);
				System.out.println("Removido!!!");
			}
		}.start();

	}
	void imprimir() {
		int id = 0;
		for (Pessoa pessoa : pessoas) {
			System.out.println("ID: "+id+" | Nome: "+pessoa.getNome() + "  \t| Email: "+ pessoa.getEmail() + "    \t| Telefone: "+pessoa.getTel());
			id++;
		}
	}
	
	void remover() {
		imprimir();
		System.out.println("Seleciona o ID: ");
		int i = scan.nextInt();
		scan.nextLine();
		Excluir(i);
	}
	
	
}
