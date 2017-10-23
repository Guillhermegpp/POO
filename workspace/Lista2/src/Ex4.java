import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("n1:");
		int n1 = leitor.nextInt();
		System.out.println("n2:");
		int n2 = leitor.nextInt();
		if (n1%n2 == 0)
			System.out.println("E' multiplo");
		else
			System.out.println("Nao e' multiplo");
			
		leitor.close();
	}

}
