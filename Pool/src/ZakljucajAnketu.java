import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class ZakljucajAnketu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void ZakljucajA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZakljucajAnketu window = new ZakljucajAnketu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ZakljucajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Zakljucaj anketu");
		frame.setBounds(100, 100, 512, 373);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblZakljucajAnketu = new JLabel("ZAKLJUCAJ ANKETU");
		lblZakljucajAnketu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblZakljucajAnketu.setBounds(143, 37, 207, 45);
		frame.getContentPane().add(lblZakljucajAnketu);
		
		JButton btnZakljucaj = new JButton("ZAKLJUCAJ ");
		btnZakljucaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnZakljucaj.setBounds(87, 234, 153, 45);
		frame.getContentPane().add(btnZakljucaj);
		
		JButton btnOdaberiDrugu = new JButton("ODABERI DRUGU");
		btnOdaberiDrugu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOdaberiDrugu.setBounds(250, 235, 185, 44);
		frame.getContentPane().add(btnOdaberiDrugu);
		
		JTextArea txtrListaAnketa = new JTextArea();
		txtrListaAnketa.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtrListaAnketa.setText("LISTA ANKETA");
		txtrListaAnketa.setBounds(87, 85, 349, 133);
		frame.getContentPane().add(txtrListaAnketa);
	}
}
