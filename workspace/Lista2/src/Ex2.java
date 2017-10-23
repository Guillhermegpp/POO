import java.util.Scanner;

public class Ex2 {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("n1:");
		int n1 = leitor.nextInt();
		System.out.println("n2:");
		int n2 = leitor.nextInt();

		System.out.println("Soma: "+ (n1+n2));
		System.out.println("Media: "+ (double)(n1+n2)/2);
		if (n1 < n2)
			System.out.println("Ordenado: "+ n1 + " - " + n2);
		else 
			System.out.println("Ordenado: "+ n2 + " - " + n1);
			
		leitor.close();
	}
	
}
