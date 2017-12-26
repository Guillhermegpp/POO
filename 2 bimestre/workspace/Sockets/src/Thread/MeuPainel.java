package Thread;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MeuPainel extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g) {
		/*super.paintComponent(g);
		int largura = getWidth();
		int altura = getHeight();
		int mlargura = 0;
		int maltura = altura/2;
		for (int i = 0; i < 15; i++) {
			if (maltura >= 0 & mlargura <= largura) {
				g.drawLine(0, 0, mlargura, maltura);
				mlargura+=30;
				maltura-=30;
				
			}
			
		}
		g.drawLine(0, 0, largura, altura);
		g.drawLine(0, altura, largura, 0);*/
		
		
		super.paintComponent(g);
		/*for (int i = 0; i < 15; i++) {
			g.drawRect(10+i*10, 10+i*10, 50+i*10, 50+i*10);
			
		}*/
		
		
		
	}

}
