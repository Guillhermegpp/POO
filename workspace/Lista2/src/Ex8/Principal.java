package Ex8;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Cripto ct = new Cripto();
		Descripto dct = new Descripto();
		System.out.println("1 - Criptografar\n2 - Descriptografar"); 
		int opcao = sc.nextInt();
		if (opcao == 1) {
			ct.dado = sc.nextInt();
			ct.crip();
		}
		else if (opcao == 2){
			dct.dado = sc.nextInt();
			dct.descrip();
		}
		
		sc.close();
	}

}
