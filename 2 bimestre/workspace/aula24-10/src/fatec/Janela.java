package fatec;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Janela extends JFrame implements ActionListener{
	private JButton j1,j2;
	private int contador = 0;
	private JLabel lContador;
	
	
	public Janela() throws HeadlessException {
	/*	super("Exemplo de JButtons e Eventos");
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 3));
		j1 = new JButton("Somar");
		j2 = new JButton("Subtrair");
		lContador = new JLabel("  "+contador);
		c.add(j1); c.add(j2); c.add(lContador); 
		j1.addActionListener(this); 
		j2.addActionListener(this);
		pack();
		setVisible(true);
		setDefaultCloseOperation(3);
		*/
		
		/*super("Exemplo de JButtons e Eventos");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("C1"));
		c.add(new JLabel("Componente 1"));
		c.add(new JLabel("C2"));
		c.add(new JLabel("Componente 2"));
		c.add(new JLabel("C1"));
		c.add(new JLabel("Componente 1"));
		pack();
		setVisible(true);
		setDefaultCloseOperation(3);
		*/
		
		super("Exemplo de JButtons e Eventos");
		Container c = getContentPane();
		c.setLayout(new GridLayout(3,3));
		for (int i = 0; i <= 8; i++) {
			JLabel l = new JLabel("C"+i);
			l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			c.add(l);
		}

		pack();
		setVisible(true);
		setDefaultCloseOperation(3);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == j1){
			contador+=200;
		}else if (e.getSource() == j2)
			contador--;
		lContador.setText("  "+contador);
		
	}

}
