import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;


public class PregledStatistike {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void PregledS() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledStatistike window = new PregledStatistike();
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
	public PregledStatistike() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pregled Statistike");
		frame.setBounds(100, 100, 489, 357);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUkupnaStatistika = new JButton("Ukupna statistika");
		btnUkupnaStatistika.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUkupnaStatistika.setBounds(23, 64, 187, 52);
		frame.getContentPane().add(btnUkupnaStatistika);
		
		JButton btnPoAnketi = new JButton("Po anketi");
		btnPoAnketi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPoAnketi.setBounds(23, 151, 187, 52);
		frame.getContentPane().add(btnPoAnketi);
		
		JButton btnOdgovori = new JButton("Odgovori");
		btnOdgovori.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOdgovori.setBounds(23, 234, 187, 52);
		frame.getContentPane().add(btnOdgovori);
	}
}
