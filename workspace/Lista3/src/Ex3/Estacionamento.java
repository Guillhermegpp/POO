package Ex3;
/*Um estacionamento cobra uma taxa mínima de R$2,00 para estacionar por até três
horas. Um adicional de R$0,50 por hora não necessariamente inteira é cobrado após
as três primeiras horas. Escreva um aplicativo que calcule e exiba as taxas de
estacionamento para um cliente que estacionou. O aplicativo deve receber o intervalo
de tempo que o veículo ficou estacionado e exibir a cobrança para o cliente.*/
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
