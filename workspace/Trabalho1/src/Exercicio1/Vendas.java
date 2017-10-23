package Exercicio1;


import java.util.List;

@SuppressWarnings("serial")
public class Vendas extends Produto{

	public Vendas(String produto, int qt, List<String> comments, List<String> qualif) {
		super(produto, qt,comments,qualif);
	}
	
	public Vendas(String produto, int qt, String comentario, int q) {
		super(produto, qt);
		addcomments(comentario,q);
	}

	

}
