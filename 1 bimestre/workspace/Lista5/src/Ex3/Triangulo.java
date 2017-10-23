package Ex3;

import java.util.Scanner;

public class Triangulo {
	private Scanner scan = new Scanner(System.in);
	private int a,b,c;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public void ler() {
		System.out.println("A: ");
		a = scan.nextInt();
		System.out.println("B: ");
		b = scan.nextInt();
		System.out.println("C: ");
		c = scan.nextInt();
	}
	
	public void triangulo(int a,int b,int c){
	    if (( a < (b+c)) && (b < (a+c)) && (c < (b+a))){ //Para formar triangulo
	        if (a == b && b == c)
	            System.out.println("Triangulo Equilatero");
	        else if ( a == b || a == c  || c == b)
	        	System.out.println("Triangulo Isosceles");
	        else
	        	System.out.println("Triangulo Escaleno");
	    }
	    else 
	    	System.out.println("Nao Forma Triangulo");
	}
	
	
}
