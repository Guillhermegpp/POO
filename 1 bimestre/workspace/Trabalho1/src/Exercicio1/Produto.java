package Exercicio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Produto implements Comparable<Produto>, Serializable {
	private String produto;
	private int qt;
	private List<String> comments = new ArrayList<String>();
	private List<String> qualif = new ArrayList<String>();

	public static void classifica() {
		System.out.println("1 - Bom\n2 - Regular\n3 - Ruim");
	}

	public void addcomments(String comentario, int q) {
		comments.add(comentario);
		String qualific = "N/D";
		if (q == 1)
			qualific = "Bom";
		else if (q == 2)
			qualific = "Regular";
		else if (q == 3)
			qualific = "Ruim";
		qualif.add(qualific);
	}

	public Produto(String produto, int qt, List<String> comments, List<String> qualif) {
		this.produto = produto;
		this.qt = qt;
		this.comments = comments;
		this.qualif = qualif;
	}

	public Produto(String produto, int qt) {
		this.produto = produto;
		this.qt = qt;

	}

	public void imprimeAe(int i) {
		System.out.println("ID: " + i + " Produto: " + produto + "\tQuantidade: " + qt);
	}

	public void imprimeComentario(int i) {
		System.out.println("ID: " + i + " Produto: " + produto + "\tQuantidade: " + qt);
		comentarios();
	}

	public void comentarios() {
		int a = 0, b = 0, c = 0, i = 0;
		for (String string : qualif) {
			if (string.equals("Bom"))
				a++;
		}
		System.out.println("Bom : " + a + " pessoa(s)");
		for (String string : qualif) {
			if (string.equals("Bom")) {
				System.out.println("Comentario: " + comments.get(i));
			}
			i++;
		}
		for (String string : qualif) {
			if (string.equals("Regular")) {
				b++;
			}
		}
		i = 0;
		System.out.println("Regular : " + b + " pessoa(s)");
		for (String string : qualif) {
			if (string.equals("Regular")) {
				System.out.println("Comentario: " + comments.get(i));
			}
			i++;
		}
		for (String string : qualif) {
			if (string.equals("Ruim")) {
				c++;
			}
		}
		i = 0;
		System.out.println("Ruim : " + c + " pessoa(s)");
		for (String string : qualif) {
			if (string.equals("Ruim")) {
				c++;
				System.out.println("Comentario: " + comments.get(i));
			}
			i++;
		}

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

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	public List<String> getQualif() {
		return qualif;
	}

	public void setQualif(List<String> qualif) {
		this.qualif = qualif;
	}

	@Override
	public int compareTo(Produto o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
