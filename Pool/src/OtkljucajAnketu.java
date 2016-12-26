import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;


public class OtkljucajAnketu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void OtkljucajA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtkljucajAnketu window = new OtkljucajAnketu();
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
	public OtkljucajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Otkljucaj anketu");
		frame.setBounds(100, 100, 526, 372);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOtkljucajAnketu = new JLabel("OTKLJUCAJ ANKETU");
		lblOtkljucajAnketu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOtkljucajAnketu.setBounds(148, 11, 216, 47);
		frame.getContentPane().add(lblOtkljucajAnketu);
		
		JButton btnOtkljucaj = new JButton("OTKLJUCAJ");
		btnOtkljucaj.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOtkljucaj.setBounds(39, 246, 188, 39);
		frame.getContentPane().add(btnOtkljucaj);
		
		JButton btnOdaberiDrugu = new JButton("ODABERI DRUGU");
		btnOdaberiDrugu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOdaberiDrugu.setBounds(237, 246, 205, 39);
		frame.getContentPane().add(btnOdaberiDrugu);
		
		JTextArea OtkljucajAnketu = new JTextArea();
		
		OtkljucajAnketu.setBounds(39, 66, 400, 161);
		frame.getContentPane().add(OtkljucajAnketu);
	}
}
