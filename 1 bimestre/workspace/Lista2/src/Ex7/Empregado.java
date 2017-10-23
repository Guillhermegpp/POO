package Ex7;
/*Desenvolva um aplicativo que determine o salário de um empregado que recebe por
hora trabalhada. A empresa paga “hora normal” para as primeiras 40 horas
trabalhadas e 50% a mais para todas as horas trabalhadas além das 40 horas. O
aplicativo deve receber a quantidade de horas trabalhadas e o valor da hora normal e
calcular o salário bruto do empregado.*/
public class Empregado {
	public double horas,valor;
	
	public double salario() {
		double sal = 0;
		if (horas > 40)
			sal = (40*valor) + ((horas-40)*(valor*1.5));
		else
			sal = (horas*valor);
		
		return sal;
	}
	
}
