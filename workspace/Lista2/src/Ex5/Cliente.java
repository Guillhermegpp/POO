package Ex5;

public class Cliente {
	public int conta;
	public double saldo,despesa,credito,limite;
	
	public void novoSaldo(double saldo, double despesa, double credito) {
		double n = saldo - despesa + credito;
		System.out.println("Novo Saldo: "+ n );
		
		if (n > limite)
			System.out.println("Limite Excedido");
		else
			System.out.println("Saldo abaixo do limite");
	}
	
	public void limite(double n) {
		
	}
	
}
