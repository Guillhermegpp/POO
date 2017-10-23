package Ex6;

public class Vendas {
	public String nome;
	public double[] valor = new double[100];
	public String[] item = new String[100];
	
	
	
	public void soma() {
		double conta = 0;
		for(int c = 0;c < valor.length; c++)
			conta += valor[c];
		double salario = 200 + (conta*0.09);
		System.out.println("Salario total da semana: "+ salario +"\nRendimento: "+(conta*0.09));
	}
}
