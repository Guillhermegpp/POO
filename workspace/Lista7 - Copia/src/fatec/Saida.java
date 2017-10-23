package fatec;

public class Saida extends Movimento {

	public Saida(String nome, double valor) {
		super(nome, valor);
	}

	@Override
	public void imprime() {
		System.out.println(getNome() + "\t\t -" + getValor());
	}

}
