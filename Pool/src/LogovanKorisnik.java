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
import javax.swing.ImageIcon;


public class LogovanKorisnik{

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
		frmUserPanel.setBounds(100, 100, 520, 250);
		frmUserPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUserPanel.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Prijavljen kao:");
		lblNewLabel.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblNewLabel.setBounds(12, 57, 103, 23);
		frmUserPanel.getContentPane().add(lblNewLabel);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblIme.setBounds(12, 87, 85, 23);
		frmUserPanel.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPrezime.setBounds(12, 118, 85, 18);
		frmUserPanel.getContentPane().add(lblPrezime);
		
		JButton btnGlasajNaAnketi = new JButton("Glasaj na Anketi");
		btnGlasajNaAnketi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GlasajNaAnketi glasajNA = new GlasajNaAnketi();
				glasajNA.GlasajnaA();
			}
		});
		btnGlasajNaAnketi.setBackground(SystemColor.activeCaption);
		btnGlasajNaAnketi.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnGlasajNaAnketi.setBounds(293, 45, 211, 30);
		frmUserPanel.getContentPane().add(btnGlasajNaAnketi);
		
		JButton btnAnketeNaKojim = new JButton("<html><body><center><p>Ankete na kojim si glasao</p></center></body></html>");
		btnAnketeNaKojim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlasaneAnkete glasaneAA = new GlasaneAnkete();
				glasaneAA.GlasaneA();
				
			}
		});
		
		//btn
		btnAnketeNaKojim.setBackground(SystemColor.activeCaption);
		btnAnketeNaKojim.setFont(new Font("Gadugi", Font.BOLD, 14));
		btnAnketeNaKojim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnketeNaKojim.setBounds(293, 87, 211, 30);
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
		btnPrijaviGreku.setBounds(293, 128, 211, 30);
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
		btnodjaviSe.setBounds(12, 175, 492, 31);
		frmUserPanel.getContentPane().add(btnodjaviSe);
		
		Login drugi = new Login();
		JLabel privaljnenKaoTekst = new JLabel("<html><font color='red'>"+drugi.getUsername()+"</font></html>");
		privaljnenKaoTekst.setFont(new Font("Gadugi", Font.PLAIN, 14));
		privaljnenKaoTekst.setBounds(101, 57, 137, 19);
		frmUserPanel.getContentPane().add(privaljnenKaoTekst);
		
		JLabel prijavljenIme = new JLabel("<html><font color='black'>"+drugi.getFirstName()+"</font></html>");
		prijavljenIme.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prijavljenIme.setBounds(101, 87, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenIme);
		
		JLabel prijavljenPrezime = new JLabel("<html><font color='black'>"+drugi.getLastName()+"</font></html>");
		prijavljenPrezime.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prijavljenPrezime.setBounds(101, 118, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenPrezime);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(LogovanKorisnik.class.getResource("/images/korisnik1.png")));
		lblNewLabel_1.setBounds(10, 35, 221, 129);
		frmUserPanel.getContentPane().add(lblNewLabel_1);
	}
}
