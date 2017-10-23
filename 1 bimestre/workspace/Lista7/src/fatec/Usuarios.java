package fatec;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Usuarios implements Serializable {
	private List<Login> contas;
	private Scanner scan;

	public Usuarios() {
		contas = new ArrayList<Login>();
		scan = new Scanner(System.in);
	}
	
	public void salvaUsuarios(){
		try {
			FileOutputStream fos = new FileOutputStream("senhas.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contas);
			fos.close();
			oos.close();
			System.out.println("Salvo com sucesso.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Login> carregaUsuarios(){
		ArrayList<Login> contass = new ArrayList<Login>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("senhas.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			contass = (ArrayList<Login>) ois.readObject();
			fis.close();
			ois.close();

		} catch (Exception e) {
			Login tempuser = new Login("admin","admin");
			contass.add(tempuser);
		}
		return contass;	
	}
	
	public void imprimir() {
		int i = 0;
		for (Login login : contas) {
			System.out.println(i + "\t " + login.getLogin());
			i++;
		}
		System.out.println("*Opções da conta:****************\n"
						+ "*1 - Adicionar\t" + "2 - Editar\t*\n"
						+ "*3 - Excluir\t" + "4 - Voltar\t*\n"
								+ "*********************************");
	}

	public void cadLogin() {
		System.out.printf("Usuario: ");
		String log = scan.next();
		System.out.printf("Senha: ");
		String sen = scan.next();
		contas.add(new Login(log, sen));
		System.out.println("Adicionado");

	}

	public void editLogin() {
		System.out.println("Id: ");
		int id = scan.nextInt();
		System.out.printf("Novo nome de usuario: ");
		String log = scan.next();
		System.out.printf("Nova senha: ");
		String sen = scan.next();
		contas.get(id).setLogin(log);
		contas.get(id).setSenha(sen);
		System.out.println("Alterado!!!");
	}
	
	public void excLogin() {
		imprimir();
		System.out.println("Id para exclusao: ");
		int id = scan.nextInt();
		contas.remove(id);
		System.out.println("Deletado!!!");
	}
	
	public boolean autenticacao() {
		System.out.printf("Usuario: ");
		String log = scan.next();
		System.out.printf("Senha: ");
		String sen = scan.next();
		for (Login conta : contas){
			if (conta.getLogin().equals(log)){
				if (conta.getSenha().equals(sen)){
					System.out.println("Seja bem-vindo.\n");
					return true;
				}
			}
		}
		System.out.println("Usuario ou senha incorreta \n");
		return false;
	}

	
	
	public Usuarios(List<Login> contas) {
		this.contas = contas;
	}

	public List<Login> getContas() {
		return contas;
	}

	public void setContas(List<Login> contas) {
		this.contas = contas;
	}

}
