package Ex4;

public class Multiplicidade {
	public int n1,n2;
	
	public static boolean multiplo(int n1,int n2) {
		if(n1%n2 == 0 || n2%n1 == 0) 
			return true;
		else
			return false;
			
	}
	
}
