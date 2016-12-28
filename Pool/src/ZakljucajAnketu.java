import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JComboBox;


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
		frame.setResizable(false);
		frame.setTitle("Zakljucaj anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblZakljucajAnketu = new JLabel("ZAKLJUCAJ ANKETU");
		lblZakljucajAnketu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblZakljucajAnketu.setBounds(143, 22, 207, 45);
		frame.getContentPane().add(lblZakljucajAnketu);
		
		JButton btnZakljucaj = new JButton("ZAKLJUCAJ ");
		btnZakljucaj.setBackground(SystemColor.activeCaption);
		btnZakljucaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnZakljucaj.setBounds(50, 278, 200, 36);
		frame.getContentPane().add(btnZakljucaj);
		
		JButton btnOdaberiDrugu = new JButton("ODABERI DRUGU");
		btnOdaberiDrugu.setBackground(SystemColor.activeCaption);
		btnOdaberiDrugu.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnOdaberiDrugu.setBounds(260, 278, 200, 36);
		frame.getContentPane().add(btnOdaberiDrugu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(50, 85, 410, 182);
		frame.getContentPane().add(comboBox);
	}
}
