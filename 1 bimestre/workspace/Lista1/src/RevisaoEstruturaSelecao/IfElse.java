package RevisaoEstruturaSelecao;

public class IfElse {
	public static void main(String[] args) {
		java.util.Scanner leitor = new java.util.Scanner(System.in);
		int n1 = 0;
		int n2 = 0;
		System.out.println("Insira um valor inteiro para n1: ");
		n1 = leitor.nextInt();
		System.out.println("Insira um valor inteiro para n2: ");
		n2 = leitor.nextInt();
		
		if(n1 > n2)
			System.out.println("Numero 1 maior que numero 2");
		else if(n1 < n2)
			System.out.println("Numero 2 maior que numero 1");
		if(n1 == n2)
			System.out.println("Numero 1 igual ao numero 2");
		else if(n1 != n2)
			System.out.println("Numero 1 diferente do numero 2");
		
		leitor.close();
	}
}
