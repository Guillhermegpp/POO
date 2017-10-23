package lista7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Caixa implements Manipulador{
	double saldo;
	ArrayList<Object> movimentacoes;

	
	public Caixa(){
		movimentacoes = new ArrayList<Object>();
		saldo = 0;
	}
	
	public void imprime(){
		int i = 1;
		double totalsaida = 0;
		double totalentrada = 0;
		for (Object movimentacao : movimentacoes){
			System.out.print(String.format("%-5s",Integer.toString(i)));
			if ( movimentacao instanceof Entrada){
				((Entrada) movimentacao).imprime();
				totalentrada += ((Entrada) movimentacao).getValor();
			}
			else if (movimentacao instanceof Saida){
				((Saida) movimentacao).imprime();
				totalsaida += ((Saida) movimentacao).getValor();				
			}
			i += 1;
		}
		System.out.print("\n");
		System.out.println(String.format("%-15s %-8.2f","Total Entrada:",totalentrada));
		System.out.println(String.format("%-15s %-8.2f","Total Saída:",totalsaida));
		System.out.println(String.format("%-15s %-8.2f\n","Saldo:",saldo));

		
	}
	
	public void imprimeEntradas(){
		int i = 1;
		for (Object movimentacao : movimentacoes){
			if (movimentacao instanceof Entrada){
				System.out.print(String.format("%-5d",i));
				((Entrada) movimentacao).imprime();
				i += 1;
			}
		}
		System.out.print("\n");
	}
	
	public void imprimeSaidas(){
		int i = 1;
		for (Object movimentacao : movimentacoes){
			if (movimentacao instanceof Saida){
				System.out.print(String.format("%-5s",Integer.toString(i)));
				((Saida) movimentacao).imprime();
				i += 1;
			}
		}
	}
	
	public void imprimeOpcoes(){
		System.out.println("ESCOLHA UMA OPÇÃO:");
		System.out.println("1- Adicionar Entrada");
		System.out.println("2- Editar Entrada");
		System.out.println("3- Excluir Entrada");
		System.out.println("4- Adicionar Saída");
		System.out.println("5- Editar Saída");
		System.out.println("6- Excluir Saída");
		System.out.println("7- Gerenciar Usuários");
		System.out.println("8- Sair");
	}
	
	
	public void addEntrada(){
		Scanner input = new Scanner(System.in);
		Entrada temp;
		System.out.println("O que se refere a entrada?");
		String n = input.nextLine();
		System.out.println("Entre com o valor:");
		double v = input.nextDouble();
		temp = new Entrada(n,v);
		movimentacoes.add(temp);
	}
	
	public void delEntrada(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual entrada você gostaria de deletar?");
		int e = input.nextInt();
		int j = 1;
		for(int i = 0; i < movimentacoes.size(); i++){
			if (movimentacoes.get(i) instanceof Entrada){
				if ( j == e){
					movimentacoes.remove(i);
					break;
				}
				else j += 1;
			}
		}
		
	}
	
	public void editEntrada(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual entrada você gostaria de editar?");
		int e = input.nextInt();
		System.out.println("O que se refere a entrada?");
		input.nextLine();
		String n = input.nextLine();
		System.out.println("Entre com o novo valor:");
		double v = input.nextDouble();
		int j = 1;
		for(int i = 0; i < movimentacoes.size(); i++){
			if (movimentacoes.get(i) instanceof Entrada){
				if (j == e){
					((Entrada) movimentacoes.get(i)).setNome(n);
					((Entrada) movimentacoes.get(i)).setValor(v);
					break;
				}
				else j += 1;
			}
		}
	}
	
	public void addSaida(){
		Scanner input = new Scanner(System.in);
		Saida temp;
		System.out.println("O que se refere a saida?");
		String n = input.nextLine();
		System.out.println("Entre com o valor:");
		double v = input.nextDouble();
		temp = new Saida(n,v);
		movimentacoes.add(temp);
	}
	
	public void delSaida(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual saída você gostaria de deletar?");
		int e = input.nextInt();
		int j = 1;
		for(int i = 0; i < movimentacoes.size(); i++){
			if (movimentacoes.get(i) instanceof Saida){
				if (j == e){
					movimentacoes.remove(i);
					break;
				}
				else j += 1;
			}
		}
	}
	
	public void editSaida(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual saída você gostaria de editar?");
		int e = input.nextInt();
		System.out.println("O que se refere a saída?");
		input.nextLine();
		String n = input.nextLine();
		System.out.println("Entre com o novo valor:");
		double v = input.nextDouble();
		int j = 1;
		for(int i = 0; i < movimentacoes.size(); i++){
			if (movimentacoes.get(i) instanceof Saida){
				if (j == e){
					((Saida) movimentacoes.get(i)).setNome(n);
					((Saida) movimentacoes.get(i)).setValor(v);
					break;
				}
				else j += 1;
			}
		}		
	}
	
	public void saveCaixa(){
		try {
			FileOutputStream fos = new FileOutputStream("caixa.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(movimentacoes);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Object> loadCaixa(){
		ArrayList<Object> temp = new ArrayList<Object>();
		try {
			FileInputStream fis = new FileInputStream("caixa.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			temp = (ArrayList<Object>) ois.readObject();
			ois.close();
			
		} catch (Exception e) {
			System.out.println("Nenhum banco carregado.");
		}
		return temp;
	}
}
