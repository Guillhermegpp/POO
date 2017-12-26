package ativ1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Pessoa implements Serializable {
	private String nome, email, tel;

	public Pessoa(String nome, String email, String tel) {
		this.nome = nome;
		this.email = email;
		this.tel = tel;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		System.out.println("Nome: " + nome + "    \t| " + "Email: " + email + "     \t| " + "Telefone: " + tel);
		return null;

	}

}
