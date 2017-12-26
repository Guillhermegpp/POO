package ativ1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Diretorio: ");
		String diretorio = scan.nextLine();
		visualizarArquivos(caminho(diretorio));
	}

	public static void visualizarArquivos(String directory) throws IOException {
		BufferedWriter escritor = new BufferedWriter(new FileWriter(directory+"\\ListarTdos.txt"));
		File file = new File(directory);
		File arquivos[] = file.listFiles();

		for (File files : arquivos) {
			escritor.write(files.getName());
			if (files.isDirectory())
				escritor.write(" <- Diretório");
			escritor.newLine();

		}
		System.out.println("Criado o arquivo em: " + directory);
		escritor.close();
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
}
