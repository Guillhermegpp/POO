package fatec;

public class Entrada extends Movimento {

	public Entrada(String nome, double valor) {
		super(nome, valor);
	}

	@Override
	public void imprime() {
		System.out.println(getNome() + "\t\t" + getValor());	
	}
	
}
