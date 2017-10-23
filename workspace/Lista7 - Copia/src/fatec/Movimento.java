package fatec;

import java.io.Serializable;

public abstract class Movimento implements Serializable{
	private String nome;
	private double valor;
	
	public Movimento (String nome, double valor){
		this.nome = nome;
		this.valor = valor;
	}
	
	public abstract void imprime();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
