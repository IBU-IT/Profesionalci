import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;


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
		frame.setResizable(false);
		frame.setTitle("Pregled Statistike");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnUkupnaStatistika = new JButton("Ukupna statistika");
		btnUkupnaStatistika.setBackground(SystemColor.activeCaption);
		btnUkupnaStatistika.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnUkupnaStatistika.setBounds(272, 234, 187, 52);
		frame.getContentPane().add(btnUkupnaStatistika);
		
		JButton btnPoAnketi = new JButton("Po anketi");
		btnPoAnketi.setBackground(SystemColor.activeCaption);
		btnPoAnketi.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnPoAnketi.setBounds(23, 151, 187, 52);
		frame.getContentPane().add(btnPoAnketi);
		
		JButton btnOdgovori = new JButton("Odgovori");
		btnOdgovori.setBackground(SystemColor.activeCaption);
		btnOdgovori.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnOdgovori.setBounds(23, 234, 187, 52);
		frame.getContentPane().add(btnOdgovori);
		
		JLabel lblStatistika = new JLabel("STATISTIKA");
		lblStatistika.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblStatistika.setBounds(191, 11, 112, 50);
		frame.getContentPane().add(lblStatistika);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton.setBounds(272, 154, 187, 52);
		frame.getContentPane().add(btnNewButton);
	}
}
