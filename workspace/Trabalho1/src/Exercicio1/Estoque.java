package Exercicio1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estoque {
	private List<Produto> produtos;
	private List<Produto> vendas;
	int indice;
	private Scanner scan;

	public List<Produto> getVendas() {
		return vendas;
	}

	public void setVendas(List<Produto> vendas) {
		this.vendas = vendas;
	}

	public Estoque() throws Exception {
		produtos = new ArrayList<>();
		vendas = new ArrayList<>();
		scan = new Scanner(System.in);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}

	public void printopcoes() {
		System.out.println("*Opções**************************************************\n"
				+ "*1-Cadastrar\t\t2-Vender\t3-Listar\t*\n" + "*4-Remover\t\t5-Editar\t6-Qualificar\t*\n"
				+ "*7-Recomendações\t8-Sair\t\t\t\t*");
		System.out.println("*********************************************************");
	}

	public void cadastrar() throws Exception {
		String p;
		int qt;
		try {
			System.out.printf("Produto: ");
			p = scan.next();
			System.out.printf("Quantidade: ");
			qt = scan.nextInt();
			System.out.println("Comentario(sem espaço): ");
			String comentario = scan.next();
			Produto.classifica();
			int r = scan.nextInt();
			produtos.add(new Compra(p, qt, comentario, r));
			System.out.println("Cadastrado!!!");
			salvar(produtos);
		} catch (Exception e) {
			System.out.println("Ops. Algo deu errado :/");
		}
	}

	public void baixa() throws Exception {
		imprimir();
		System.out.println("Digite o indice do produto");
		int i = scan.nextInt();
		try {
			System.out.println("Quantidade: ");
			int qt = scan.nextInt();
			int qtAnterior = produtos.get(i).getQt();
			if (qt >= qtAnterior) {
				Produto novo = new Vendas(produtos.get(i).getProduto(), produtos.get(i).getQt(),
						produtos.get(i).getComments(), produtos.get(i).getQualif());
				produtos.add(novo);
				produtos.remove(i);
			} else {
				Produto novo = new Vendas(produtos.get(i).getProduto(), produtos.get(i).getQt(),
						produtos.get(i).getComments(), produtos.get(i).getQualif());
				novo.setQt(qt);
				produtos.get(i).setQt(qtAnterior - qt); // Alterando qt estoque
				produtos.add(novo);
			}
			System.out.println("Vendido!");
			salvar(produtos);
		} catch (Exception e) {
			System.out.println("Ops. Algo deu errado :/");
		}

	}

	public void newcoment() throws Exception {
		imprimir();
		try {
			System.out.println("Digite o indice para adicionar mais um comentario: ");
			int r = scan.nextInt();
			imprimir(r);
			System.out.println("Comentario(sem espaço): ");
			String comentario = scan.next();
			Produto.classifica();
			int q = scan.nextInt();
			produtos.get(r).addcomments(comentario, q);
			salvar(produtos);
		} catch (Exception e) {
			System.out.println("Ops. Algo deu errado :/");
		}
	}

	public void salvar(List<Produto> produtos) throws Exception {
		FileOutputStream saida = new FileOutputStream("Trab1.db");
		ObjectOutputStream saidaO = new ObjectOutputStream(saida);
		saidaO.writeObject(produtos);
		saidaO.close();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Produto> receber() throws Exception {
		ArrayList<Produto> banco = new ArrayList<Produto>();
		try {
			FileInputStream entrada = new FileInputStream("Trab1.db");
			ObjectInputStream entradaO = new ObjectInputStream(entrada);
			banco = (ArrayList<Produto>) entradaO.readObject();
			entradaO.close();
		} catch (Exception e) {
			System.out.println("Nenhum banco carregado.");
		}
		return banco;
	}

	public void editar() throws Exception {
		imprimir();
		System.out.println("Digite o indice para editar o contato: ");
		int c = scan.nextInt();
		imprimir(c);
		System.out.println("Deseja realmente alterar esse item? (S/N)");

		String r = scan.next();
		if (r.toUpperCase().equals("S")) {
			System.out.println("Produto: " + produtos.get(c).getProduto() + "\nProduto: ");
			String p = scan.next();

			System.out.println("Quantidade atual: " + produtos.get(c).getQt() + "\nQuantidade: ");
			int qt = scan.nextInt();

			produtos.get(c).setProduto(p);
			produtos.get(c).setQt(qt);
			System.out.println("\nEditado com sucesso!!!");
		}
	}

	public void excluir() throws Exception {
		imprimir();
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
		int i = 0;
		System.out.println("Compras: ");
		for (Produto produto : produtos) {
			if (produto instanceof Compra) {
				produto.imprimeAe(i);
			}
			i++;
		}
		i = 0;
		System.out.println("\nVendas: ");
		for (Produto produto : produtos) {
			if (produto instanceof Vendas) {
				produto.imprimeAe(i);
			}
			i++;
		}
	}

	public void imprimirComments() throws Exception {
		imprimir();
		System.out.println("Digite o indice do produto: ");
		int i = scan.nextInt();
		produtos.get(i).imprimeComentario(i);
	}

	public void imprimir(int i) throws Exception {
		System.out.println(
				"ID: " + i + " Produto: " + produtos.get(i).getProduto() + "\tQuantidade: " + produtos.get(i).getQt());
	}

	public void relatorio() throws Exception {
		int qtTotal = 0;
		for (Produto produto : produtos) {
			if (produto instanceof Compra)
				qtTotal += produto.getQt();
		}
		System.out.println("Quantidade total de Produtos no estoque: " + qtTotal);
		imprimir();
	}

}
