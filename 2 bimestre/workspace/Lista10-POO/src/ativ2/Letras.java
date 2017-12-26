package ativ2;

public class Letras {
	String palavra;
	String[] umBurraco = { "A", "Q", "R", "O", "P", "D", "4", "6", "9", "0" }, doisBurracos = { "B", "8" };

	public Letras(String palavra) {
		this.palavra = palavra;
	}

	public void contaBurracos() {
		int conta = 0;
		String[] letra = palavra.split("");
		for (int i = 0; i < letra.length; i++) {
			letra[i] = letra[i].toUpperCase();
			for (int j = 0; j < umBurraco.length; j++) {
				try {
					if (letra[i].equals(umBurraco[j]))
						conta += 1;
					else if (letra[i].equals(doisBurracos[j]))
						conta += 2;
				} catch (Exception e) {
					if (letra[i].equals(umBurraco[j]))
						conta += 1;
				}
			}
		}
		System.out.println(conta + " burracos!!!");
	}

}
