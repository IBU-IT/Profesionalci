import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class BrisanjeKorisnika {

	private JFrame frame;
	private JTextField textField;
	private JButton btnBriiKorisnika;
	private JLabel lblBrisanjeKorisnika;

	/**
	 * Launch the application.
	 */
	public void ObrisiK() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKorisnika window = new BrisanjeKorisnika();
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
	public BrisanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Brisanje Korisnika");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(143, 105, 200, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUnesiIme = new JLabel("Unesi username :");
		lblUnesiIme.setBounds(10, 102, 103, 27);
		frame.getContentPane().add(lblUnesiIme);
		
		btnBriiKorisnika = new JButton("Obriši korisnika");
		btnBriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBriiKorisnika.setBounds(143, 163, 200, 50);
		frame.getContentPane().add(btnBriiKorisnika);
		
		lblBrisanjeKorisnika = new JLabel("BRISANJE KORISNIKA");
		lblBrisanjeKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBrisanjeKorisnika.setBounds(143, 26, 200, 50);
		frame.getContentPane().add(lblBrisanjeKorisnika);
	}
}
