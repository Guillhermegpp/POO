package ativ2;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread  {
   public static void main(String args[]) {
		clientes = new Vector();
		try {
			ServerSocket s = new ServerSocket(8090);
			while (true) {
				System.out.print("Esperando alguem se conectar...");
				Socket conexao = s.accept();
				System.out.println(" Conectou!");
//				cria uma nova thread para tratar essa conexão
				Thread t = new Server(conexao);
				t.start();
			}
		}
		catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
	private static Vector clientes;
	private Socket conexao;
	private String meuNome;
	public Server(Socket s) {
            conexao = s;
	}
//	execução da thread
	public void run() {
		try {
//			objetos que permitem controlar fluxo de comunicação
			BufferedReader entrada = new BufferedReader(new
					InputStreamReader(conexao.getInputStream()));
			PrintStream saida = new
			PrintStream(conexao.getOutputStream());
			meuNome = entrada.readLine();
			if (meuNome == null) {return;}
			clientes.add(saida);
			String linha = entrada.readLine();
			while (linha != null && !(linha.trim().equals(""))) {
				sendToAll(saida, " disse: ", linha);
				linha = entrada.readLine();
			}
			sendToAll(saida, " saiu ", "do chat!");
			clientes.remove(saida);
			conexao.close();
		}
		catch (IOException e) {
			System.out.println("IOException: " + e);
		}
	}
	public void sendToAll(PrintStream saida, String acao,
			String linha) throws IOException {
		Enumeration e = clientes.elements();
		while (e.hasMoreElements()) {
			PrintStream chat = (PrintStream) e.nextElement();
			if (chat != saida) {chat.println(meuNome + acao + linha);}
		}
	}
}