package Exercicio1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Produto implements Comparable<Produto>, Serializable{
	private String produto;
	private int qt;
	
	public Produto(String produto, int qt) {
		this.produto = produto;
		this.qt = qt;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	@Override
	public int compareTo(Produto o) {
		return produto.compareTo(o.getProduto());
	}
	
	
	
}
