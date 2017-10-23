package lista7;

import java.io.Serializable;

public class Entrada implements Manipulador, Serializable {
	String nome;
	double valor;
	
	public Entrada (String nome, double valor){
		this.nome = nome;
		this.valor = valor;
	}
	
	public void imprime(){
		System.out.println(String.format("%-41s %-10.2f",nome,valor));
	}

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
