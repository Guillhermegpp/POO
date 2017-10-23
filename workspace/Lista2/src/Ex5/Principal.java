package Ex5;

import java.util.Scanner;

/*Desenvolva um aplicativo que determinará se um cliente de uma loja de
departamentos excedeu o limite de crédito em uma conta-corrente. Para cada cliente,
os seguintes fatos estão disponíveis: 
	número da conta, 
	saldo no início do mês, 
	total de todos os itens cobrados desse cliente no mês, 
	total de créditos aplicados ao cliente no mês e 
	limite de crédito autorizado. 

O programa deve inserir todos esses fatos com
ponteiros, calcular o novo saldo (= saldo inicial + despesas - créditos), exibir o novo
saldo e determinar se o novo saldo excede o limite de crédito do cliente. Avisar se o
crédito do cliente está excedido ou não.*/
public class Principal {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Cliente cl = new Cliente();
		
		System.out.println("número da conta: "); 
		cl.conta = leitor.nextInt();
		System.out.println("saldo no início do mês:"); 
		cl.saldo = leitor.nextInt();
		System.out.println("total de todos os itens cobrados no mês:");
		cl.despesa = leitor.nextInt();
		System.out.println("total de créditos aplicados no mês:");
		cl.credito = leitor.nextInt();
		System.out.println("limite de crédito autorizado:");
		cl.limite = leitor.nextInt();

		
		cl.novoSaldo(cl.saldo, cl.despesa, cl.credito);
		
		leitor.close();
		
	}
	
	
}
