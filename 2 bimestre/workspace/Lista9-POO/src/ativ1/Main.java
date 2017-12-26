package ativ1;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		MeuPainel mp = new MeuPainel();
		JFrame janela = new JFrame("Titulo");
		janela.getContentPane().add(mp);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
		
	}

}
