import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LogovanKorisnik extends Login {

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
		frmUserPanel.setResizable(false);
		frmUserPanel.setTitle("User Panel");
		frmUserPanel.setBounds(100, 100, 520, 410);
		frmUserPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUserPanel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prijavljen kao:");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 57, 103, 23);
		frmUserPanel.getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblIme.setBounds(10, 87, 85, 23);
		frmUserPanel.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblPrezime.setBounds(10, 118, 85, 18);
		frmUserPanel.getContentPane().add(lblPrezime);
		
		JButton btnGlasajNaAnketi = new JButton("Glasaj na Anketi");
		btnGlasajNaAnketi.setBackground(SystemColor.activeCaption);
		btnGlasajNaAnketi.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnGlasajNaAnketi.setBounds(53, 203, 183, 30);
		frmUserPanel.getContentPane().add(btnGlasajNaAnketi);
		
		JButton btnAnketeNaKojim = new JButton("<html><body><center><p>Ankete na kojim si glasao</p></center></body></html>");
		btnAnketeNaKojim.setBackground(SystemColor.activeCaption);
		btnAnketeNaKojim.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnAnketeNaKojim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnketeNaKojim.setBounds(123, 257, 278, 30);
		frmUserPanel.getContentPane().add(btnAnketeNaKojim);
		
		JButton btnPrijaviGreku = new JButton("Prijavi Gre\u0161ku");
		btnPrijaviGreku.setBackground(SystemColor.activeCaption);
		btnPrijaviGreku.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnPrijaviGreku.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrijaviGresku greska = new PrijaviGresku();
				greska.greska();
			}
		});
		btnPrijaviGreku.setBounds(256, 203, 183, 30);
		frmUserPanel.getContentPane().add(btnPrijaviGreku);
		
		JButton btnodjaviSe = new JButton("<html><body><center><p>ODJAVI SE</p></center></body></html>");
		btnodjaviSe.setBackground(SystemColor.activeCaption);
		btnodjaviSe.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnodjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnodjaviSe.setBounds(53, 307, 386, 31);
		frmUserPanel.getContentPane().add(btnodjaviSe);
		
		Login drugi = new Login();
		JLabel privaljnenKaoTekst = new JLabel("<html><font color='red'>"+drugi.getUsername()+"</font></html>");
		privaljnenKaoTekst.setFont(new Font("Gadugi", Font.PLAIN, 14));
		privaljnenKaoTekst.setBounds(123, 61, 202, 19);
		frmUserPanel.getContentPane().add(privaljnenKaoTekst);
		
		JLabel prijavljenIme = new JLabel("<html><font color='red'>"+drugi.getFirstName()+"</font></html>");
		prijavljenIme.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prijavljenIme.setBounds(123, 91, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenIme);
		
		JLabel prijavljenPrezime = new JLabel("<html><font color='red'>"+drugi.getLastName()+"</font></html>");
		prijavljenPrezime.setBounds(123, 117, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenPrezime);
	}
}
