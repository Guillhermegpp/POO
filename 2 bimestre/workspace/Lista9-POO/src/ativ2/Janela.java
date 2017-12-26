package ativ2;

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

import com.sun.org.apache.bcel.internal.generic.AALOAD;

public class Janela extends JFrame implements ActionListener {
	private JButton del, soma, sub, div, multi, 
					one, two, three, four, five, six, 
					seven, eight, nine, zero, equals;
	private int contador = 0;
	static String a = "", b = "";
	static String painel = " ";
	double result;
	private JLabel lContador;
	private JLabel mostra;

	public void calcular(double x, double y, String op) {
		switch (op) {
		case "+":
			mostra.setText("  "+(double)(x+y));
			break;
		case "-":
			mostra.setText("  "+(double)(x-y));
			break;
		case "*":
			mostra.setText("  "+(double)(x*y));
			break;
		case "/":
			mostra.setText("  "+ (double)(x/y));
			break;

		default:
			break;
		}
	}

	@SuppressWarnings("deprecation")
	public Janela() throws HeadlessException {
		super("Calculadora");
		Container c = getContentPane();
		c.setLayout(new GridLayout(6,3));
		soma = new JButton("+");
		sub = new JButton("-");
		div = new JButton("/");
		multi = new JButton("x");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		zero = new JButton("0");
		del = new JButton("AC");
		equals = new JButton("=");
		mostra = new JLabel("" + painel);
		mostra.setSize(20,20);
				
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));c.add(mostra);
		
		c.add(seven);c.add(eight);c.add(nine);c.add(soma);
		c.add(four);c.add(five);c.add(six);c.add(sub);
		c.add(one);c.add(two);c.add(three);c.add(div);
		c.add(zero);c.add(del);c.add(equals);c.add(multi);
		
		del.addActionListener(this);
		zero.addActionListener(this);
		one.addActionListener(this);
		two.addActionListener(this);
		three.addActionListener(this);
		four.addActionListener(this);
		five.addActionListener(this);
		six.addActionListener(this);
		seven.addActionListener(this);
		eight.addActionListener(this);
		nine.addActionListener(this);
		soma.addActionListener(this);
		sub.addActionListener(this);
		div.addActionListener(this);
		multi.addActionListener(this);
		equals.addActionListener(this);
		
		setSize(250,450);
		setVisible(true);
		setDefaultCloseOperation(3);

	}

	int flag = 1;
	String op = "";
	static boolean add = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == one) 
			if (flag == 1)
				a  += "1";
			else
				b += "1";
		else if (e.getSource() == two)
			if (flag == 1)
				a  += "2";
			else
				b  += "2";
		else if (e.getSource() == three)
			if (flag == 1)
				a += "3";
			else
				b  += "3";
		else if (e.getSource() == four)
			if (flag == 1)
				a  += "4";
			else
				b  += "4";
		else if (e.getSource() == five)
			if (flag == 1)
				a  += "5";
			else
				b += "5";
		else if (e.getSource() == six)
			if (flag == 1)
				a  += "6";
			else
				b += "6";
		else if (e.getSource() == seven)
			if (flag == 1)
				a  += "7";
			else
				b += "7";
		else if (e.getSource() == eight)
			if (flag == 1)
				a  += "8";
			else
				b += "8";
		else if (e.getSource() == nine)
			if (flag == 1)
				a  += "9";
			else
				b += "9";
		else if (e.getSource() == zero)
			if (flag == 1)
				a  += "0";
			else
				b += "0";
		else if (e.getSource() == soma){
			flag = 2;
			op = "+";
		}else if (e.getSource() == sub){
			flag = 2;
			op = "-";
		}else if (e.getSource() == div){
			flag = 2;
			op = "/";
		}else if (e.getSource() == multi){
			flag = 2;
			op = "*";
		}else if (e.getSource() == equals){
			flag = 1;
			calcular(Double.parseDouble(a),Double.parseDouble(b),op);
			add = true;
			a = b = op = "";
			painel = "0";
		}else if (e.getSource() == del) {
			flag = 1;
			a = b = op = "";
			painel = "0";
		}if (!add) {
		painel = (a + " " + op + " " + b);
		mostra.setText(painel);
		}
		add = false;
	}

}
