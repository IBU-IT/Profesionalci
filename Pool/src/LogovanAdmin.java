import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LogovanAdmin {

	private JFrame frmAdminPanel;

	/**
	 * Launch the application.
	 */
	public void Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanAdmin window = new LogovanAdmin();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogovanAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.getContentPane().setBackground(Color.WHITE);
		frmAdminPanel.setBackground(Color.WHITE);
		frmAdminPanel.setResizable(false);
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 781, 440);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);

		Login novi = new Login();
		JLabel prikaziUsername = new JLabel("<html><font color='white'>"+novi.getUsername()+"</font></html>");
		prikaziUsername.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prikaziUsername.setBackground(SystemColor.activeCaption);
		prikaziUsername.setBounds(365, 158, 104, 15);
		frmAdminPanel.getContentPane().add(prikaziUsername);

		JLabel prikaziIme = new JLabel("<html><font color='white'>" + novi.getFirstName() + "</font></html>");
		prikaziIme.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prikaziIme.setBounds(365, 175, 104, 15);
		frmAdminPanel.getContentPane().add(prikaziIme);

		JLabel prikaziPrezime = new JLabel("<html><font color='white'>" + novi.getLastName() + "</font></html>");
		prikaziPrezime.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prikaziPrezime.setBounds(365, 193, 104, 15);
		frmAdminPanel.getContentPane().add(prikaziPrezime);

		JLabel prikaziSpol = new JLabel("<html><font color='white'>" + novi.getGenderIs() + "</font></html>");
		prikaziSpol.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prikaziSpol.setBounds(365, 210, 104, 15);
		frmAdminPanel.getContentPane().add(prikaziSpol);

		JLabel prikaziGodine = new JLabel("<html><font color='white'>" + novi.getAgeIs() + "</font></html>");
		prikaziGodine.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prikaziGodine.setBounds(365, 226, 104, 15);
		frmAdminPanel.getContentPane().add(prikaziGodine);
		
		JLabel adminBCG = new JLabel("");
		adminBCG.setIcon(new ImageIcon(LogovanAdmin.class.getResource("/images/admin_back.png")));
		adminBCG.setBounds(4, 4, 767, 400);
		frmAdminPanel.getContentPane().add(adminBCG);
		
		JLabel odjaviSe = new JLabel("");
		odjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login a = new Login();
				a.pojaviSe();
				frmAdminPanel.dispose();
			}
		});
		odjaviSe.setBounds(508, 255, 263, 60);
		frmAdminPanel.getContentPane().add(odjaviSe);
		
		JLabel pregledStatistike = new JLabel("");
		pregledStatistike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PregledStatistike pregled = new PregledStatistike();
				pregled.PregledS();
			}
		});
		pregledStatistike.setBounds(4, 336, 336, 57);
		frmAdminPanel.getContentPane().add(pregledStatistike);
		
		JLabel prikaziGreske = new JLabel("");
		prikaziGreske.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrikaziGreskeAdmin Admin = new PrikaziGreskeAdmin();
				Admin.PrikaziGreskeAdmin();
			}
		});
		prikaziGreske.setBounds(4, 255, 267, 60);
		frmAdminPanel.getContentPane().add(prikaziGreske);
		
		JLabel zakljucajAnketu = new JLabel("");
		zakljucajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ZakljucajAnketu zakljucaj = new ZakljucajAnketu();
				zakljucaj.ZakljucajA();
			}
		});
		zakljucajAnketu.setBounds(4, 175, 216, 57);
		frmAdminPanel.getContentPane().add(zakljucajAnketu);
		
		JLabel dodajKorisnika = new JLabel("");
		dodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajKorisnika a = new DodajKorisnika();
				a.DodajK();
			}
		});
		dodajKorisnika.setBounds(4, 93, 267, 60);
		frmAdminPanel.getContentPane().add(dodajKorisnika);
		
		JLabel dodajAnketu = new JLabel("");
		dodajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajAnketu dodaj = new DodajAnketu();
				dodaj.DodajAnk();
			}
		});
		dodajAnketu.setBounds(4, 13, 336, 57);
		frmAdminPanel.getContentPane().add(dodajAnketu);
		
		JLabel otkljucajAnketu = new JLabel("");
		otkljucajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OtkljucajAnketu otkljucaj = new OtkljucajAnketu();
				otkljucaj.OtkljucajA();
			}
		});
		otkljucajAnketu.setBounds(557, 175, 214, 60);
		frmAdminPanel.getContentPane().add(otkljucajAnketu);
		
		JLabel obrisiKorisnika = new JLabel("");
		obrisiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BrisanjeKorisnika brisi = new BrisanjeKorisnika();
				brisi.ObrisiK();
			}
		});
		obrisiKorisnika.setBounds(508, 93, 263, 60);
		frmAdminPanel.getContentPane().add(obrisiKorisnika);
		
		JLabel obrisiAnketu = new JLabel("");
		obrisiAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ObrisiAnketu obrisi = new ObrisiAnketu();
				obrisi.ObrisiA();
			}
		});
		obrisiAnketu.setBounds(435, 13, 336, 57);
		frmAdminPanel.getContentPane().add(obrisiAnketu);
	}
}
