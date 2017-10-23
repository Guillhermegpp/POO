package Ex6;

import java.util.Scanner;

public class Principal {
/*Considere uma grande empresa que paga seu pessoal de vendas com base em
comissões. O pessoal de vendas recebe R$ 200 por semana mais 9% de suas vendas
brutas durante a semana. Desenvolva um aplicativo que receba a entrada de itens
vendidos por um vendedor durante a última semana e calcule e exibe os rendimentos
do vendedor. */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vendas venda = new Vendas();
		System.out.printf("Vendedor:");
		venda.nome = sc.next();
		System.out.printf("Qt de itens:");
		int cont = sc.nextInt();
		for(int c=0;c<cont;c++){
			System.out.printf("Item " + (c+1) +": ");
			venda.item[c] = sc.next();
			System.out.printf("Valor :");
			venda.valor[c] = sc.nextDouble();
		}
		
		venda.soma();
		
		sc.close();

	}

}
