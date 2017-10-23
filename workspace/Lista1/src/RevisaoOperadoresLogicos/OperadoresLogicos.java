package RevisaoOperadoresLogicos;

public class OperadoresLogicos {
	
	public void and(boolean[] c1,boolean[] c2,boolean[] result){
		for(int n =0;n<4;n++){
			result[n] = c1[n] && c2[n];
			System.out.printf("%s and %s = %s \n",c1[n],c2[n],result[n]);
		}
	}
	
	public void or(boolean[] c1,boolean[] c2,boolean[] result){
		for(int n =0;n<4;n++){
			result[n] = c1[n] || c2[n];
			System.out.printf("%s or %s = %s \n",c1[n],c2[n],result[n]);
		}
	}
	
	public void not(boolean[] c1,boolean[] result){
		for(int n =0;n<4;n+=2){
			result[n] = !c1[n];
			System.out.printf("NOT %s = %s \n",c1[n],result[n]);
		}
	}
	
	public static void main(String[] args) {
		boolean[] coluna1 = {true,true,false,false};
		boolean[] coluna2 = {true,false,true,false};
		boolean[] resultado = new boolean[4];
		OperadoresLogicos operadores = new OperadoresLogicos();
		operadores.and(coluna1,coluna2,resultado);
		System.out.println("************");
		operadores.or(coluna1,coluna2,resultado);
		System.out.println("************");
		operadores.not(coluna1,resultado);
	}
}
