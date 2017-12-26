package ativ2;

import java.io.*;
import java.net.*;

public class Client extends Thread { 
	private static boolean done = false;

	public static void main(String args[]) {
		try {
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("IP: ");
			String ip = teclado.readLine();
			System.out.println("Porta: ");
			String porta = teclado.readLine();
			
			Socket conexao = new Socket(ip,Integer.parseInt(porta));
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			System.out.print("Entre com o seu nome: ");
			String meuNome = teclado.readLine();
			saida.println(meuNome);
			Thread t = new Client(conexao);
			t.start();
			String linha;
			while (true) {
				System.out.print("> ");
				linha = teclado.readLine();
				if (done) {
					break;
				}
				// envia para o servidor
				saida.println(linha);
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}

	private Socket conexao;

	public Client(Socket s) {
		conexao = s;
	}

	// execução da thread
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			String linha;
			while (true) {
				// pega o que o servidor enviou
				linha = entrada.readLine();
				if (linha == null) {
					System.out.println("Conexão encerrada!");
					break;
				}
				System.out.println();
				System.out.println(linha);
				System.out.print("...> ");
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
		done = true;
	}
}