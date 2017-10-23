package Ex5;

public class Primo {
	public int primo;
	
	public static boolean primo(int n) {
		int cont = 0;
		for(int i = n ; i > 1 ; i--) {
			if(n%i == 0)
				cont++;
			if (cont >= 2)
				break;
		}
		if (cont == 1)
			return true;
		else
			return false;
	}
	public static void imprimir(int i) {
		System.out.printf(i +" ");
	}
}
