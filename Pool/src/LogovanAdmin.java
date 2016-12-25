import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
		frmAdminPanel.setTitle("Admin Panel");
		frmAdminPanel.setBounds(100, 100, 420, 300);
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
		btnDodajKorisnika.setBounds(231, 113, 163, 23);
		frmAdminPanel.getContentPane().add(btnDodajKorisnika);
		
		JButton btnObriiKorisnika = new JButton("Obri\u0161i Korisnika");
		btnObriiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RemoveUser brisi = new RemoveUser();
				brisi.TestnoBrisanje();
			}
		});
		btnObriiKorisnika.setBounds(231, 147, 163, 23);
		frmAdminPanel.getContentPane().add(btnObriiKorisnika);
		
		JButton btnDodajAnketu = new JButton("Dodaj Anketu");
		btnDodajAnketu.setBounds(231, 11, 163, 23);
		frmAdminPanel.getContentPane().add(btnDodajAnketu);
		
		JButton btnObriiAnketu = new JButton("Obri\u0161i Anketu");
		btnObriiAnketu.setBounds(231, 79, 163, 23);
		frmAdminPanel.getContentPane().add(btnObriiAnketu);
		
		JButton btnPregeldStatistike = new JButton("PREGELD STATISTIKE");
		btnPregeldStatistike.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPregeldStatistike.setBounds(231, 187, 163, 63);
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
		btnOdjaviSe.setBounds(10, 187, 163, 63);
		frmAdminPanel.getContentPane().add(btnOdjaviSe);
		
		JButton btnZakljuajAnketu = new JButton("Zaklju\u010Daj Anketu");
		btnZakljuajAnketu.setBounds(231, 45, 163, 23);
		frmAdminPanel.getContentPane().add(btnZakljuajAnketu);
	}
}
