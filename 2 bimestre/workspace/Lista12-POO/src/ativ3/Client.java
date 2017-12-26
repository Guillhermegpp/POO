package ativ3;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
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
		return cam;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o caminho para o arquivo: ");
		String arq = scan.nextLine();
		File f = new File(caminho(arq));
		try {
			Socket socket = new Socket("127.0.0.1",9292);
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeUTF(f.getName());
			out.writeLong(f.length());
			FileInputStream in = new FileInputStream(f);
			byte [] buf = new byte[4096];
			
			while(true) {
				int len = in.read(buf);
				if (len == -1) break;
				out.write(buf,0,len);
			}
			out.close();
			socket.close();
			System.out.println("Enviado");
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
