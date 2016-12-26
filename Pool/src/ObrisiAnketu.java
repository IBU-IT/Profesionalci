import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;


public class ObrisiAnketu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void ObrisiA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiAnketu window = new ObrisiAnketu();
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
	public ObrisiAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Obrisi Anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnObrisiAnketu = new JButton("OBRI\u0160I ");
		btnObrisiAnketu.setBackground(SystemColor.activeCaption);
		btnObrisiAnketu.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnObrisiAnketu.setBounds(144, 264, 213, 59);
		frame.getContentPane().add(btnObrisiAnketu);
		
		JLabel lblBrisanjeAnkete = new JLabel("BRISANJE ANKETE");
		lblBrisanjeAnkete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBrisanjeAnkete.setBounds(160, 11, 197, 50);
		frame.getContentPane().add(lblBrisanjeAnkete);
	}

}
