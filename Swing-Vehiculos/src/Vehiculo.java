import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Vehiculo extends JFrame implements ActionListener {

	JLabel marca;
	JComboBox<String> desplegablemarca;
	JLabel modelo;
	JTextField cajatexto1;
	JLabel motor;
	JComboBox<String> desplegablemotor;
	JLabel potencia;
	JTextField cajatexto2;
	JButton agregar;
	JButton eliminar;
	JButton limpiar;
	JButton guardar;
	JTable tabla;

	public Vehiculo() {
		super("Vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		marca = new JLabel("Marca:");
		p.add(marca);
		desplegablemarca = new JComboBox<String>();
		p.add(desplegablemarca);
		modelo = new JLabel("Modelo:");
		p.add(modelo);
		cajatexto1 = new JTextField();
		p.add(cajatexto1);
		motor = new JLabel("Motor:");
		p.add(motor);
		desplegablemotor = new JComboBox<String>();
		p.add(desplegablemotor);
		potencia = new JLabel("Potencia:");
		p.add(potencia);
		cajatexto2 = new JTextField();
		p.add(cajatexto2);
		tabla = new JTable(new DefaultTableModel(new String[] { "Marca", "Modelo", "Motor", "Potencia" }, 0));
		tabla.setFillsViewportHeight(true);
		p3.add(new JScrollPane(tabla));
		
		agregar = new JButton("Agregar");
		p2.add(agregar);
		eliminar = new JButton("Eliminar");
		p2.add(eliminar);
		limpiar = new JButton("Limpiar");
		p2.add(limpiar);
		guardar = new JButton("Guardar");
		p2.add(guardar);
		
		c.add(p);
		c.add(p2);
		c.add(p3);
		

		desplegablemotor.addItem("Gasolina");
		desplegablemotor.addItem("Diesel");
		desplegablemotor.addItem("Electrico");
		desplegablemotor.addItem("Hibrido");

		leerFichero();
		
		pack();
	}

	public void leerFichero() {
		BufferedReader br = null;

		try {
			br = new BufferedReader(
					new InputStreamReader(
							getClass().getResourceAsStream("/marcas.txt")));

			System.out.println("Leyendo el fichero marcas.txt");
			String linea;
			while ((linea = br.readLine()) != null)
				desplegablemarca.addItem(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != br) {
					br.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Vehiculo().setVisible(true);
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();

		if (actionCommand.equals("Agregar")) {
			JOptionPane.showMessageDialog(this, "Has seleccionado Agregar", "Agregar", JOptionPane.INFORMATION_MESSAGE);
		} else if (actionCommand.equals("Eliminar")) {
			JOptionPane.showMessageDialog(this, "Has seleccionado Eliminar", "Eliminar",
					JOptionPane.INFORMATION_MESSAGE);
		} else if (actionCommand.equals("Limpiar")) {
			JOptionPane.showMessageDialog(this, "Has seleccionado Limpiar", "Limpiar", JOptionPane.INFORMATION_MESSAGE);
		} else if (actionCommand.equals("Guardar")) {
			JOptionPane.showMessageDialog(this, "Has seleccionado Guardar", "Guardar", JOptionPane.INFORMATION_MESSAGE);
		} else {
			System.exit(EXIT_ON_CLOSE);

		}
	}
}
