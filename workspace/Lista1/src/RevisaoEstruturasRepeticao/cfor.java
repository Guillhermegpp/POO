package RevisaoEstruturasRepeticao;

import java.util.Scanner;

public class cfor {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int conta = 0;
		boolean exec = true;
		while(exec){
			System.out.println("Calculadora basica. Para fazer calculos com apenas dois numeros");
			System.out.println("Digite a opção desejada:");
			System.out.println("1 - SOMA \n2 - SUBTRACAO\n3 - MULTIPLICACAO\n4 - DIVISAO\n5 - SAIR");
			int opcao = leitor.nextInt();
			
			if (opcao != 5){
				System.out.println("n1:");
				int n1 = leitor.nextInt();
				System.out.println("n2:");
				int n2 = leitor.nextInt();
				if (opcao == 1)
					conta = n1+n2;
				else if(opcao == 2)
					conta = n1-n2;
				else if(opcao == 3)
					conta = n1*n2;
				else if(opcao == 4)
					conta = n1/n2;

				System.out.println("Resultado: "+conta);
							
			}
			else 
				exec = false;

					}
		leitor.close();

	}

}
