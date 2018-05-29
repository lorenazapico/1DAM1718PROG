import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame {

	Lienzo lienzo;
	JSlider slider;

	public Main() {
		super("Lineas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		// crear y añadir el JSlider
		slider = new JSlider(3, 61, 3);
		slider.setMajorTickSpacing(2);
		slider.setToolTipText("Número de Líneas"); // mantener el raton y sale el texto
		slider.setPaintLabels(true);// muestra los numeros
		slider.setPaintTicks(true);
		

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				lienzo.setNumeroLineas(slider.getValue());
			}

		});
		c.add(slider);
		// crear y añadir el Lienzo
		lienzo = new Lienzo(500, 500, slider.getValue());
		c.add(lienzo);
		pack();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Main().setVisible(true);
			}
		});
	}

}
