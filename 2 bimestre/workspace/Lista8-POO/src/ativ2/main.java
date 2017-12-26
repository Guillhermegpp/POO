package ativ2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o caminho para o arquivo: ");
		String arq = scan.nextLine();
		
		
		try {
			lerEmails(caminho(arq));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String caminho(String cam) {
		String[] caminhos = null;
		caminhos = cam.split("");
		cam = "";
		for (int i = 0; i < caminhos.length - 1; i++) {
			if (caminhos[i].equals("\\"))
				caminhos[i] = "\\\\";

		}
		for (String string : caminhos) {
			cam += string;
		}
		//System.out.println(cam);
		return cam;
	}
	static void lerEmails(String dado) throws IOException {
		long tempoInicial = System.currentTimeMillis();
		BufferedWriter escritor = new BufferedWriter(new FileWriter("emailfiltrados.txt"));
		File arq = new File(dado);
		FileReader ler = new FileReader(arq);
		BufferedReader leitor = new BufferedReader(ler);
		
		String linha = leitor.readLine();
		String [] elementos;
		while(linha != null) {
			elementos = linha.split(" ");
			for (String string : elementos) {
				String [] letras = string.split("");
				for (int i = 0; i < letras.length; i++) {
					if (letras[i].equals("@")) {
						escritor.write(string);
					}
				}
			}
			linha = leitor.readLine();
			escritor.newLine();
		}
		System.out.println("Arquivo criado no diretório do projeto JAVA");
		
		escritor.close();

		// execução do método
		long tempo = (System.currentTimeMillis() - tempoInicial);
		System.out.println("Tempo de Processamento: " + tempo + " milissegundos");
		
	}

}
