import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class Lienzo extends JPanel implements ComponentListener {

	int n;
	double dx;
	double dy;

	public Lienzo(int ancho, int alto, int numLineas) {
		addComponentListener(this);
		setPreferredSize(new Dimension(ancho, alto));
		n = numLineas + 1;
		dx = (double) ancho / (double) n;
		dy = (double) alto / (double) n;
	}

	public void setNumeroLineas(int numLineas) {
		if(numLineas%2!=0) {
		n = numLineas + 1;
		dx = (double) getWidth() / (double) n;
		dy = (double) getHeight() / (double) n;
		repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		setBackground(Color.BLACK);
		for (int i = 1; i < n; i++) {
			g.drawLine(0, 0, (int) (dx * (n - i)), (int)(dy * i));
			g.drawLine(getWidth() - 1, getHeight() - 1,(int)( dx * (n - i)), (int)(dy * i));
			g.drawLine(getWidth() - 1, 0,(int)( dx * i),(int)( dy * i));
			g.drawLine(0, getHeight() - 1, (int)(dx * i), (int)(dy * i));
		}
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		dx = (double) getWidth() / (double) n;
		dy = (double) getHeight() / (double) n;
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
