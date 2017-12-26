package fatec;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class main{

	public static void main(String[] args) {
		/*JOptionPane.showMessageDialog(null, "Testando interfaces graficas",
				"Titulo",1);
		*/
		
		
		/*
		String n1 = JOptionPane.showInputDialog("digite um numero");
		int n = Integer.parseInt(n1);
		StringBuilder sb = new StringBuilder();
		sb.append("Numero : ");sb.append(n);
		JOptionPane.showMessageDialog(null, sb.toString());
		
		*/
		
		
		/*
		JFrame janela = new JFrame("Titulo");
		JButton botao = new JButton("Text do Butao");
		botao.setSize(50,50);
		janela.getContentPane().add(botao);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
		
		*/
		
		/*
		MeuPainel mp = new MeuPainel();
		JFrame janela = new JFrame("Titulo");
		janela.getContentPane().add(mp);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);*/
		

		Janela jn = new Janela();
		JFrame janela = new JFrame("Titulo");
		janela.getContentPane().add(jn);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(400, 400);
		janela.setVisible(true);
		
	}
	

}
