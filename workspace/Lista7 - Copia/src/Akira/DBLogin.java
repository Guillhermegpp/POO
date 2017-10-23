package lista7;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DBLogin implements Manipulador,Serializable {
	ArrayList<Login> contas;
	
	public DBLogin(){
		contas = new ArrayList<Login>();
	}
	public void imprime(){
		int i = 1;
		for( Login conta : contas){
			System.out.print(String.format("%-2d- ",i));
			conta.imprime();
			i += 1;
		}
		System.out.print("\n");
		System.out.println("ESCOLHA UMA OPÇÃO:");
		System.out.println("1- Adicionar Conta");
		System.out.println("2- Editar Conta");
		System.out.println("3- Deletar Conta");
		System.out.println("4- Voltar");
	}
	
	public void addLogin(){
		Scanner input = new Scanner(System.in);
		System.out.println("qual será o nome do usuário?");
		String n = input.next();
		System.out.println("qual será a senha?");
		String s = input.next();
		Login temp = new Login(n,s);
		contas.add(temp);
		System.out.println("Adicionado com sucesso.\n");
	}
	
	public void editLogin(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual usuário gostaria de editar?");
		int i = input.nextInt();
		System.out.println("qual será o novo ID?");
		String n = input.next();
		System.out.println("Qual será a nova senha?");
		String s = input.next();
		contas.get(i-1).setId(n);
		contas.get(i-1).setSenha(s);
		System.out.println("Alterado com sucesso.\n");		
	}
	
	public void delLogin(){
		Scanner input = new Scanner(System.in);
		System.out.println("Qual usuário gostaria de deletar?");
		int i = input.nextInt();
		contas.remove(i-1);
		System.out.println("Deletado com sucesso.\n");
	}
	
	public void saveDB(){
		try {
			FileOutputStream fos = new FileOutputStream("senhas.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(contas);
			fos.close();
			oos.close();
			System.out.println("Salvo com sucesso.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Login> loadDB(){
		ArrayList<Login> temp = new ArrayList<Login>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("senhas.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
			temp = (ArrayList<Login>) ois.readObject();
			fis.close();
			ois.close();

		} catch (Exception e) {
			Login tempuser = new Login("gerentinho","flamengo");
			temp.add(tempuser);
		}
		return temp;	
	}
	
	public boolean efetuarLogin(){
		Scanner input = new Scanner(System.in);
		System.out.println("Entre com o ID:");
		String id = input.next();
		System.out.println("Entre com a senha:");
		String pw = input.next();
		for (Login conta : contas){
			if (conta.getId().equals(id)){
				if (conta.getSenha().equals(pw)){
					System.out.println("Seja bem-vindo.\n");
					return true;
				}
			}
		}
		System.out.println("Usuário ou senha incorreta.\n");
		return false;
	}
	
	public ArrayList<Login> getContas() {
		return contas;
	}
	
	public void setContas(ArrayList<Login> contas) {
		this.contas = contas;
	}
	
	
	
}
