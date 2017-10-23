package lista7;

import java.io.Serializable;

class Login implements Manipulador,Serializable {
	private String id;
	private String senha;
	
	public Login(String id, String senha){
		this.id = id;
		this.senha = senha;
	}
	
	public void imprime(){
		System.out.println(id);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
