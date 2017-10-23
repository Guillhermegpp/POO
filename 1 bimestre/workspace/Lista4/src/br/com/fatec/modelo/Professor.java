package br.com.fatec.modelo;

public class Professor extends Pessoa{
	
	private String numeoResistro;
	private String quantidaddeHoraAula;

	public Professor(String nome, String telefone, String email, String numeoResistro, String quantidaddeHoraAula) {
		super(nome, telefone, email);
		this.numeoResistro = numeoResistro;
		this.quantidaddeHoraAula = quantidaddeHoraAula;
	}
	
	@Override
	public String dadosFormatados() {
		String dadosFormatados =  super.dadosFormatados();
		dadosFormatados = dadosFormatados+"\nRegistro: "+this.getNumeoResistro();
		dadosFormatados = dadosFormatados+"\nHora/Aula: "+this.getQuantidaddeHoraAula();
		return dadosFormatados();
	}
	public String getNumeoResistro() {
		return numeoResistro;
	}
	public void setNumeoResistro(String numeoResistro) {
		this.numeoResistro = numeoResistro;
	}
	public String getQuantidaddeHoraAula() {
		return quantidaddeHoraAula;
	}
	public void setQuantidaddeHoraAula(String quantidaddeHoraAula) {
		this.quantidaddeHoraAula = quantidaddeHoraAula;
	}
	
}
