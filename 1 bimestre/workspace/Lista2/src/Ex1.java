import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		System.out.println("n1:");
		int n1 = leitor.nextInt();
		System.out.println("n2:");
		int n2 = leitor.nextInt();
		System.out.println("Soma: "+ (n1+n2));
		System.out.println("Subtracao: "+(n1-n2));
		System.out.println("Divisao: "+(n1/n2));
		System.out.println("Multiplicacao: "+(n1*n2));
		leitor.close();
		

		
	}
}
