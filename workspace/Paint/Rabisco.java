//Guilherme Pinto   RA 1460481621038
//Caroline Teixeira RA 1460481521091
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Rabisco extends JComponent implements MouseListener, MouseMotionListener {
	private ArrayList<Point> pontos, removePonto;
	private int tamanho = 8;
	private int metade = tamanho / 2;
	private Color cor;

	public Rabisco(Color cor) {
		this.cor = cor;
		pontos = new ArrayList<Point>(1024);
		removePonto = new ArrayList<Point>();
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setColor(cor);
		for (Point ponto : pontos) {
			g2d.fillOval(ponto.x - metade, ponto.y - metade, tamanho, tamanho);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		if (SwingUtilities.isRightMouseButton(e)) {
			for (Point point : pontos) {
				if (point.distance(p) <= 12) {
					removePonto.add(point);
				}
			}
			pontos.removeAll(removePonto);
		}
		else
			pontos.add(p);
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point p = e.getPoint();
		if (SwingUtilities.isRightMouseButton(e)) {
			for (Point point : pontos) {
				if (point.distance(p) <= 12) {
					removePonto.add(point);
				}
			}
			pontos.removeAll(removePonto);
		}
		else
			pontos.add(p);
		repaint();
	}


	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}