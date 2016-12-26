import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LogovanAdmin extends Login{

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
		frmAdminPanel.setResizable(false);
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 411, 329);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);
		
		JButton btnDodajKorisnika = new JButton("Dodaj Korisnika");
		btnDodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajKorisnika a = new DodajKorisnika();
				a.DodajK();
			}
		});
		btnDodajKorisnika.setBounds(231, 148, 163, 23);
		frmAdminPanel.getContentPane().add(btnDodajKorisnika);
		
		JButton btnObriiKorisnika = new JButton("Obri\u0161i Korisnika");
		btnObriiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BrisanjeKorisnika brisi = new BrisanjeKorisnika();
				brisi.ObrisiK();
			}
		});
		btnObriiKorisnika.setBounds(231, 182, 163, 23);
		frmAdminPanel.getContentPane().add(btnObriiKorisnika);
		
		JButton btnDodajAnketu = new JButton("Dodaj Anketu");
		btnDodajAnketu.setBounds(231, 11, 163, 23);
		frmAdminPanel.getContentPane().add(btnDodajAnketu);
		
		JButton btnObriiAnketu = new JButton("Obri\u0161i Anketu");
		btnObriiAnketu.setBounds(231, 79, 163, 23);
		frmAdminPanel.getContentPane().add(btnObriiAnketu);
		
		JButton btnPregeldStatistike = new JButton("PREGELD STATISTIKE");
		btnPregeldStatistike.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPregeldStatistike.setBounds(231, 216, 163, 63);
		frmAdminPanel.getContentPane().add(btnPregeldStatistike);
		
		JLabel lblPrijavljeniKao = new JLabel("Prijavljen kao:");
		lblPrijavljeniKao.setBounds(10, 11, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrijavljeniKao);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(10, 38, 85, 23);
		frmAdminPanel.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(10, 65, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrezime);
		
		JButton btnOdjaviSe = new JButton("ODJAVI SE");
		btnOdjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnOdjaviSe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOdjaviSe.setBounds(10, 216, 163, 63);
		frmAdminPanel.getContentPane().add(btnOdjaviSe);
		
		JButton btnZakljuajAnketu = new JButton("Zaklju\u010Daj Anketu");
		btnZakljuajAnketu.setBounds(231, 45, 163, 23);
		frmAdminPanel.getContentPane().add(btnZakljuajAnketu);
		
		// novi ce se koristit za sve get i set metode. Nije jos zavrseno
		Login novi = new Login();
		JLabel prikaziUsername = new JLabel("<html><font color='red'>"+novi.getUsername()+"</font></html>");
		prikaziUsername.setBounds(105, 11, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziUsername);
		
		JLabel prikaziIme = new JLabel("<html><font color='red'>"+novi.getFirstName()+"</font></html>");
		prikaziIme.setBounds(105, 38, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziIme);
		
		JLabel prikaziPrezime = new JLabel("<html><font color='red'>"+novi.getLastName()+"</font></html>");
		prikaziPrezime.setBounds(105, 65, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziPrezime);
		
		JLabel lblSpol = new JLabel("Spol:");
		lblSpol.setBounds(10, 91, 85, 23);
		frmAdminPanel.getContentPane().add(lblSpol);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setBounds(10, 113, 85, 23);
		frmAdminPanel.getContentPane().add(lblGodina);
		
		JLabel prikaziSpol = new JLabel("<html><font color='red'>"+novi.getGenderIs()+"</font></html>");
		prikaziSpol.setBounds(105, 91, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziSpol);
		
		JLabel prikaziGodine = new JLabel("<html><font color='red'>"+novi.getAgeIs()+"</font></html>");
		prikaziGodine.setBounds(105, 113, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziGodine);
		
		JButton btnNewButton = new JButton("Otkljucaj Anketu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(231, 114, 163, 23);
		frmAdminPanel.getContentPane().add(btnNewButton);
	}

}
