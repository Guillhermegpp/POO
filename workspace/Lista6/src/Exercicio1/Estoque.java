package Exercicio1;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Estoque {
	private ArrayList<Produto> produtos;
	private Scanner scan;

	public Estoque() {
		produtos = new ArrayList<Produto>();
		scan = new Scanner(System.in);
	}

	

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public void printopcoes() {
		System.out.println("1 - Cadastrar\n2 - Relatório\n3 - Editar\n4 - Excluir\n5 - Sair");		
	}

	public void cadastrar() throws Exception {
		String p;int qt;
		System.out.printf("Produto: ");
		p = scan.next();
		System.out.printf("Quantidade: ");
		qt = scan.nextInt();
		produtos.add(new Produto(p,qt));
		System.out.println("Cadastrado!!!");
		salvar(produtos);
		
	}
	
	//Gravar os dados em disco
	public void salvar(ArrayList<Produto> p) throws Exception {
		FileOutputStream saida = new FileOutputStream("Lista6.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(p);
		saidaO.close();
	}
	
	//Recuperar os dados em disco
	@SuppressWarnings({ "resource", "unchecked" })
	public void receber() throws Exception {
		FileInputStream entrada = new FileInputStream("Lista6.db");
		ObjectInputStream entradaO = new ObjectInputStream(entrada);
		ArrayList<Produto> p = (ArrayList<Produto>) entradaO.readObject();
		
		produtos = p;
	}
	
	public void editar() throws Exception {
		receber();
		System.out.println("Digite o indice para editar o contato: ");
		int c = scan.nextInt();
		imprimir(c);
		System.out.println("Deseja realmente alterar esse item? (S/N)");
		
		String r = scan.next();
		if (r.toUpperCase().equals("S")) {
			System.out.println("Produto: "+produtos.get(c).getProduto() +"\nProduto: ");
			String p = scan.next();

			System.out.println("Quantidade atual: "+ produtos.get(c).getQt() +"\nQuantidade: ");
			int qt = scan.nextInt();
			produtos.set(c, new Produto(p,qt));
			System.out.println("\nEditado com sucesso!!!");
		}
		salvar(produtos);
	}

	public void excluir() throws Exception {
		receber();
		System.out.println("Digite o indice para o contato ser excluido: ");
		int c = scan.nextInt();
		imprimir(c);
		System.out.println("Deseja realmente excluir esse item? (S/N)");
		String r = scan.next();
		if (r.toUpperCase().equals("S")) {
			produtos.remove(c);
			System.out.println("Cadastro Excluido");
		}
		salvar(produtos);
	}
	
	
	public void imprimir() throws Exception {
		receber();
		for (int i = 0; i < produtos.size(); i++) {
			System.out.println("ID: "+i+" Produto: "+produtos.get(i).getProduto() + "\tQuantidade: "+ produtos.get(i).getQt());
		}
		
	}
	
	public void imprimir(int i) throws Exception {
		receber();
		System.out.println("ID: "+i+" Produto: "+produtos.get(i).getProduto() + "\tQuantidade: "+ produtos.get(i).getQt());	
	}

	public void relatorio() throws Exception {
		receber();
		int qtTotal = 0;
		for (Produto produto : produtos) {
			qtTotal += produto.getQt();
		}
		System.out.println("Quantidade total de Produtos cadastrados: "+qtTotal);
		ordenar();	
	}
	
	public void ordenar() throws Exception {
		receber();
		Collections.sort(produtos);
		imprimir();
	}
}
