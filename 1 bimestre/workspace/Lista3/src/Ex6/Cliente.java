package Ex6;

public class Cliente {
	private String nome;
	private String email;
	private String telefone;
	private String endereco;
	public double[] meses = new double[12];
	public double totalMeses;
			
	public Cliente(String nome, String email, String telefone, String endereco, double[] meses) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.meses = meses;
		
	}

	public double getTotalMeses() {
		return totalMeses;
	}

	public void setTotalMeses(double totalMeses) {
		this.totalMeses = totalMeses;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public double somar() {
		double soma = 0;
		for (int i = 0; i < meses.length; i++) {
			soma += meses[i];
		}
		return soma;
	}
	
	
	
}
