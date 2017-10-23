package Ex8;

public class Descripto {
	public int dado;
	
	public void descrip() {
		
		int resto=dado;
		int n[] = new int[4];
		for (int i = 3; i >=0 ; i--) {
			n[i] = ((resto%10)+10) - 7;
			resto /= 10;
			if (n[i] > 10) 
				n[i] -= 10;
		}
		System.out.println(n[2]+""+n[3]+""+n[0]+""+n[1]);
	}
}
