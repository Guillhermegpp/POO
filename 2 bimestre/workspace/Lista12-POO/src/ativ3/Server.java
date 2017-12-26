package ativ3;

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) {
	try {
		ServerSocket serv = new ServerSocket(9292);;
		while (true) {
			System.out.println("Aguardando clientes...");
			Socket socket = serv.accept();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			String filename = in.readUTF();
			long size = in.readLong();
			FileOutputStream fos = new FileOutputStream(filename);
			byte [] buf = new byte[4096];
			while(true) {
				int len = in.read(buf);
				if (len == -1) break;
				
				fos.write(buf,0,len);
				
			}
			fos.flush();
			fos.close();
			System.out.println("Arquivo recebido e encontra-se no diretório do projeto JAVA");
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
}


}
