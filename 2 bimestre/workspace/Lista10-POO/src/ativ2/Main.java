package ativ2;

import java.util.Scanner;

/*Se voc� pensar em um papel como um plano e uma letra como uma marca��o
neste plano, ent�o estas letras dividem o plano em regi�es. Por exemplo, as letras
A, D e O dividem o plano em 2 pois possuem um espa�o confinado em seu
desenho, ou um �buraco�. Outras letras como B possuem 2 buracos e letras como
C e E n�o possuem buracos.
Deste modo podemos considerar que o n�mero de buracos em um texto � igual a
soma dos buracos nas palavras dele.
A sua tarefa �, dado um texto qualquer, encontre a quantidade de buracos nele.
*/

public class Main {

	public static void main(String[] args) {
		Letras l;
		System.out.println("Palavra");
		Scanner scan = new Scanner(System.in);
		String pal = scan.next();
		l = new Letras(pal);
		l.contaBurracos();
	}

}
