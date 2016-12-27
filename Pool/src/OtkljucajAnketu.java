import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;


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
		frame.setResizable(false);
		frame.setTitle("Otkljucaj anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOtkljucajAnketu = new JLabel("OTKLJUCAJ ANKETU");
		lblOtkljucajAnketu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOtkljucajAnketu.setBounds(148, 11, 216, 47);
		frame.getContentPane().add(lblOtkljucajAnketu);
		
		JButton btnOtkljucaj = new JButton("OTKLJUCAJ");
		btnOtkljucaj.setBackground(SystemColor.activeCaption);
		btnOtkljucaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnOtkljucaj.setBounds(50, 278, 200, 36);
		frame.getContentPane().add(btnOtkljucaj);
		
		JButton btnOdaberiDrugu = new JButton("ODABERI DRUGU");
		btnOdaberiDrugu.setBackground(SystemColor.activeCaption);
		btnOdaberiDrugu.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnOdaberiDrugu.setBounds(260, 278, 200, 36);
		frame.getContentPane().add(btnOdaberiDrugu);
		
		JTextArea OtkljucajAnketu = new JTextArea();
		
		OtkljucajAnketu.setBounds(50, 66, 410, 201);
		frame.getContentPane().add(OtkljucajAnketu);
	}
}
