package Ex3;
/*Um estacionamento cobra uma taxa m�nima de R$2,00 para estacionar por at� tr�s
horas. Um adicional de R$0,50 por hora n�o necessariamente inteira � cobrado ap�s
as tr�s primeiras horas. Escreva um aplicativo que calcule e exiba as taxas de
estacionamento para um cliente que estacionou. O aplicativo deve receber o intervalo
de tempo que o ve�culo ficou estacionado e exibir a cobran�a para o cliente.*/
public class Estacionamento {
	public int hora,min;

	public double cobranca() {
		int hr = hora*60+min;
		double conta = 2;
		if (hr > 180) {
			hr = hr - 180;
			while (hr > 0) {
				conta += 0.5;
				hr -= 60;
			}
		}
		return conta;
	}

}
