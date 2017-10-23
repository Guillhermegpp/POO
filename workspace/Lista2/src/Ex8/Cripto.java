package Ex8;
/*Uma empresa de grande porte quer transmitir dados via internet, mas está
preocupada com a possibilidade de seus telefones estarem grampeados. Ela pediu
para você escrever um programa que criptografe os dados de modo que estes possam
ser transmitidos mais seguramente. Todos os dados são transmitidos como inteiros de
quatro dígitos. 

Seu aplicativo deve ler um inteiro de quatro dígitos inserido pelo
usuário e criptográfa-lo desta maneira: 
	Substitua cada dígito pelo resultado da adição de 7 ao dígito e 
	obtendo o resto depois da visão do novo valor por 10. 
	Troque então o primeiro dígito pelo terceiro e o segundo dígito pelo quarto. 
	Então imprima o inteiro criptográfado. 
Escreva um outro aplicativo separado que receba como entrada um inteiro de quatro 
dígitos criptografado e o descriptografe para forma o número original.  */
public class Cripto {
	
	public int dado;
	
	public void crip() {
		
		int n[] = new int [4];
		
		
		int resto=dado;
		for (int i = 3; i >= 0 ; i--) {
			n[i] =  ((resto%10)+7)%10;
			resto/=10;
		}
		System.out.println(n[2]+""+n[3]+""+n[0]+""+n[1]);
	}
	
}
