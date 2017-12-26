package ativ1;

import java.io.Serializable;

public class Pessoa implements Comparable<Pessoa>, Serializable {
	private String nome, email, telefone;
	private String rua, cidade, estado;
	private int numero;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Pessoa(String nome, String email, String telefone, String rua, String cidade, String estado, int numero) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}

	@Override
	public String toString() {
		System.out.println("Nome: " + getNome() + "    \t| " + "Email: " + getEmail() + "     \t| " + "Telefone: "
				+ getTelefone());
		return null;

	}

	@Override
	public int compareTo(Pessoa p) {

		return getNome().compareToIgnoreCase(p.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
