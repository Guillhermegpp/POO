package Ex5;

public class Principal {

	public static void main(String[] args) {
		int[] vet = new int[1000];
		System.out.println("Numeros Primos: ");
		for (int i=0; i < 1000 ; i++) {
			vet[i] = i;
			
			if (Primo.primo(i) == true)
				Primo.imprimir(i);
		}

	}

}
