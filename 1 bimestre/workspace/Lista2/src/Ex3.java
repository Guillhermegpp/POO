import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Digite 5 numeros inteiros: ");
		int maior=0;int menor = 1000000;
		int[] vet = new int[5];
		for(int c = 0; c < 5;c++) {
			vet[c] = leitor.nextInt();
			if (vet[c] > maior)
				maior = vet[c];
			if (vet[c] < menor)
				menor = vet[c];
		}

		System.out.println("Maior : " + maior);
		System.out.println("Menor : " + menor);
		
		leitor.close();
	}

}
