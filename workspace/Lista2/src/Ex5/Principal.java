package Ex5;

import java.util.Scanner;

/*Desenvolva um aplicativo que determinar� se um cliente de uma loja de
departamentos excedeu o limite de cr�dito em uma conta-corrente. Para cada cliente,
os seguintes fatos est�o dispon�veis: 
	n�mero da conta, 
	saldo no in�cio do m�s, 
	total de todos os itens cobrados desse cliente no m�s, 
	total de cr�ditos aplicados ao cliente no m�s e 
	limite de cr�dito autorizado. 

O programa deve inserir todos esses fatos com
ponteiros, calcular o novo saldo (= saldo inicial + despesas - cr�ditos), exibir o novo
saldo e determinar se o novo saldo excede o limite de cr�dito do cliente. Avisar se o
cr�dito do cliente est� excedido ou n�o.*/
public class Principal {
	
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Cliente cl = new Cliente();
		
		System.out.println("n�mero da conta: "); 
		cl.conta = leitor.nextInt();
		System.out.println("saldo no in�cio do m�s:"); 
		cl.saldo = leitor.nextInt();
		System.out.println("total de todos os itens cobrados no m�s:");
		cl.despesa = leitor.nextInt();
		System.out.println("total de cr�ditos aplicados no m�s:");
		cl.credito = leitor.nextInt();
		System.out.println("limite de cr�dito autorizado:");
		cl.limite = leitor.nextInt();

		
		cl.novoSaldo(cl.saldo, cl.despesa, cl.credito);
		
		leitor.close();
		
	}
	
	
}
