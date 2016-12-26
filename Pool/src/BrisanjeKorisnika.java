import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;


public class BrisanjeKorisnika {

	private JFrame frame;
	private JButton btnBriiKorisnika;
	private JLabel lblBrisanjeKorisnika;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	// Treba uraditi i ostalo 
	// pisi komentare
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
	 *  Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Brisanje Korisnika");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUnesiIme = new JLabel("Unesi username :");
		lblUnesiIme.setBounds(10, 82, 112, 50);
		frame.getContentPane().add(lblUnesiIme);
		
		btnBriiKorisnika = new JButton("Obriši korisnika");
		btnBriiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBriiKorisnika.setBounds(143, 153, 200, 50);
		frame.getContentPane().add(btnBriiKorisnika);
		
		lblBrisanjeKorisnika = new JLabel("BRISANJE KORISNIKA");
		lblBrisanjeKorisnika.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBrisanjeKorisnika.setBounds(143, 26, 200, 50);
		frame.getContentPane().add(lblBrisanjeKorisnika);
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		scrollPane.setBounds(132, 82, 200, 50);
		frame.getContentPane().add(scrollPane);
		
		// Brisanje korsinika ////
	}
}
