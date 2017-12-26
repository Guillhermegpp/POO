package ativ1;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {
	public static void main(String args[]) {

		clientes = new Vector();
		try {
			ServerSocket s = new ServerSocket(8090);
			System.out.println("IP: " + InetAddress.getLocalHost().getHostAddress() + " Porta: 8090");
			while (true) {
				System.out.print("Esperando alguem se conectar...");
				Socket conexao = s.accept();
				System.out.println(" Conectou!");
				Thread t = new Server(conexao);
				t.start();
			}
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}

	private static Vector clientes;
	private Socket conexao;
	private String meuNome;

	public Server(Socket s) {
		conexao = s;
	}

	// execução da thread
	public void run() {
		try {
			//cria uma nova thread para o servidor mandar mensagem para os clientes
			new Thread() {
				public void run() {
					BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
					try {
						meuNome = "Servidor";
						PrintStream saida = new PrintStream(meuNome);
						System.out.println("\nMensagem: ");
						String linha = teclado.readLine();
						clientes.add(saida);
						while (linha != null && !(linha.trim().equals(""))) {
							sendTo(" disse: ", linha);
							linha = teclado.readLine();
						}
						sendTo("saiu ", "do chat!");
						clientes.remove(saida);
						conexao.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}.start();

			// objetos que permitem controlar fluxo de comunicação
			BufferedReader entrada = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			PrintStream saida = new PrintStream(conexao.getOutputStream());
			// primeiramente, espera-se pelo nome do cliente
			meuNome = entrada.readLine();
			if (meuNome == null) {
				return;
			}
			clientes.add(saida);

			String linha = entrada.readLine();
			while (linha != null && !(linha.trim().equals(""))) {
				sendToAll(saida, " disse: ", linha);
				linha = entrada.readLine();
			}
			sendToAll(saida, " saiu ", "do chat!");
			clientes.remove(saida);
			conexao.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}

	public void sendToAll(PrintStream saida, String acao, String linha) throws IOException {
		Enumeration e = clientes.elements();
		while (e.hasMoreElements()) {
			PrintStream chat = (PrintStream) e.nextElement();
			if (chat != saida) {
				chat.println(meuNome + acao + linha);
			}
		}
	}
	
	public void sendTo(String acao, String linha) throws IOException {
		Enumeration e = clientes.elements();
		while (e.hasMoreElements()) {
			PrintStream chat = (PrintStream) e.nextElement();
			// envia para todos, menos para o próprio usuário
				chat.println("Servidor" + acao + linha);
		}
	}
}
