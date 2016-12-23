import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LogovanKorisnik {

	private JFrame frmUserPanel;

	/**
	 * Launch the application.
	 */
	public void LogovanProfil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanKorisnik window = new LogovanKorisnik();
					window.frmUserPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogovanKorisnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserPanel = new JFrame();
		frmUserPanel.setTitle("User Panel");
		frmUserPanel.setBounds(100, 100, 400, 206);
		frmUserPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserPanel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prijavljen Kao:");
		lblNewLabel.setBounds(10, 10, 85, 23);
		frmUserPanel.getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 37, 85, 23);
		frmUserPanel.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 66, 85, 23);
		frmUserPanel.getContentPane().add(lblPrezime);
		
		JButton btnGlasajNaAnketi = new JButton("Glasaj na Anketi");
		btnGlasajNaAnketi.setBounds(232, 5, 137, 23);
		frmUserPanel.getContentPane().add(btnGlasajNaAnketi);
		
		JButton btnAnketeNaKojim = new JButton("<html><body><center><p>Ankete na kojim<br>si glasao</p></center></body></html>");
		btnAnketeNaKojim.setBounds(232, 69, 137, 53);
		frmUserPanel.getContentPane().add(btnAnketeNaKojim);
		
		JButton btnPrijaviGreku = new JButton("Prijavi Gre\u0161ku");
		btnPrijaviGreku.setBounds(232, 37, 137, 23);
		frmUserPanel.getContentPane().add(btnPrijaviGreku);
		
		JButton btnodjaviSe = new JButton("<html><body><center><p>ODJAVI SE</p></center></body></html>");
		btnodjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnodjaviSe.setBounds(10, 133, 359, 28);
		frmUserPanel.getContentPane().add(btnodjaviSe);
	}

}
