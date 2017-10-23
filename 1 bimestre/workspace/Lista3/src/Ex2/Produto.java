package Ex2;
/*Uma empresa que faz negócios por reembolso postal vende cinco produtos cujos
preços de varejo são como segue: P1 R$1,00 – P2 R$2,98 – P3 R$9,98 – P4 R$4,49
e P5 R$6,87. Escreva um aplicativo que leia uma série de pares de números como
segue: código do produto, quantidade vendida. Seu programa deve determinar o
valor total de produtos vendidos, discriminando a porcentagem vendida em dinheiro
de cada produto.*/
public class Produto {
	public String code;
	public int qt;
	public static int qttotal=0,qtp1=0,qtp2=0,qtp3=0,qtp4=0;
	
	public double somar(double b) {
		double soma = 0;
		switch(code) {
		case "P1" : {
			soma = 	qt * 1;	
			qtp1 += qt;
			break;
		}
		case "P2" : {
			soma = 	qt * 2.98;	
			qtp2 += qt;	
			break;
		}
		case "P3" : {
			soma = 	qt * 9.98;	
			qtp3 += qt;	
			break;
		}
		case "P4" :{
			soma = qt * 4.49;
			qtp4 += qt;
			break;
		}
		}
		b += soma;
		qttotal += qt;
		return b;
	}
	public void imprimir() {

		System.out.println("Total vendido: "+qttotal+"\nPorcentagem:");
		System.out.println("P1: "+((qtp1*100)/qttotal)+"%");
		System.out.println("P2: "+((qtp2*100)/qttotal)+"%");
		System.out.println("P3: "+((qtp3*100)/qttotal)+"%");
		System.out.println("P4: "+((qtp4*100)/qttotal)+"%");	
	}
}
