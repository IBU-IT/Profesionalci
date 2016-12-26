import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;



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
		frmAdminPanel.setBounds(100, 100, 520, 410);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(null);
		
		JButton btnDodajKorisnika = new JButton("Dodaj Korisnika");
		btnDodajKorisnika.setBackground(SystemColor.activeCaptionBorder);
		btnDodajKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DodajKorisnika a = new DodajKorisnika();
				a.DodajK();
			}
		});
		btnDodajKorisnika.setBounds(340, 203, 165, 30);
		frmAdminPanel.getContentPane().add(btnDodajKorisnika);
		
		JButton btnObriiKorisnika = new JButton("Obri\u0161i Korisnika");
		btnObriiKorisnika.setBackground(SystemColor.activeCaptionBorder);
		btnObriiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BrisanjeKorisnika brisi = new BrisanjeKorisnika();
				brisi.ObrisiK();
			}
		});
		btnObriiKorisnika.setBounds(340, 254, 165, 30);
		frmAdminPanel.getContentPane().add(btnObriiKorisnika);
		
		JButton btnDodajAnketu = new JButton("Dodaj Anketu");
		btnDodajAnketu.setBackground(SystemColor.activeCaption);
		btnDodajAnketu.setBounds(340, 14, 165, 30);
		frmAdminPanel.getContentPane().add(btnDodajAnketu);
		
		JButton btnObriiAnketu = new JButton("Obri\u0161i Anketu");
		btnObriiAnketu.setBackground(SystemColor.activeCaption);
		btnObriiAnketu.addMouseListener (new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				ObrisiAnketu obrisi = new ObrisiAnketu();
				obrisi.ObrisiA();
			}
			});
		btnObriiAnketu.setBounds(340, 61, 165, 30);
		frmAdminPanel.getContentPane().add(btnObriiAnketu);
		
		JButton btnPregeldStatistike = new JButton("PREGELD STATISTIKE");
		btnPregeldStatistike.setBackground(SystemColor.activeCaption);
		btnPregeldStatistike.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				PregledStatistike pregled = new PregledStatistike();
				pregled.PregledS();
			}
		});
		btnPregeldStatistike.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPregeldStatistike.setBounds(180, 325, 155, 45);
		frmAdminPanel.getContentPane().add(btnPregeldStatistike);
		
		JLabel lblPrijavljeniKao = new JLabel("Prijavljen kao:");
		lblPrijavljeniKao.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPrijavljeniKao.setBackground(SystemColor.activeCaption);
		lblPrijavljeniKao.setBounds(10, 30, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrijavljeniKao);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblIme.setBounds(10, 64, 85, 23);
		frmAdminPanel.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblPrezime.setBounds(10, 102, 85, 23);
		frmAdminPanel.getContentPane().add(lblPrezime);
		
		JButton btnOdjaviSe = new JButton("ODJAVI SE");
		btnOdjaviSe.setBackground(SystemColor.activeCaption);
		btnOdjaviSe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnOdjaviSe.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOdjaviSe.setBounds(10, 325, 155, 45);
		frmAdminPanel.getContentPane().add(btnOdjaviSe);
		
		// Zakljucaj dugme
		
		JButton btnZakljucajAnketu = new JButton("Zaklju\u010Daj Anketu");
		btnZakljucajAnketu.setBackground(SystemColor.activeCaption);
		btnZakljucajAnketu.addMouseListener (new MouseAdapter(){
		@Override
		public void mouseClicked(MouseEvent e) {
			ZakljucajAnketu zakljucaj = new ZakljucajAnketu();
			zakljucaj.ZakljucajA();
		}
		});
		btnZakljucajAnketu.setBounds(340, 156, 165, 30);
		frmAdminPanel.getContentPane().add(btnZakljucajAnketu);
		
		// novi ce se koristit za sve get i set metode. Nije jos zavrseno
		Login novi = new Login();
		JLabel prikaziUsername = new JLabel("<html><font color='red'>"+novi.getUsername()+"</font></html>");
		prikaziUsername.setBackground(SystemColor.activeCaption);
		prikaziUsername.setBounds(105, 30, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziUsername);
		
		JLabel prikaziIme = new JLabel("<html><font color='black'>"+novi.getFirstName()+"</font></html>");
		prikaziIme.setBounds(105, 68, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziIme);
		
		JLabel prikaziPrezime = new JLabel("<html><font color='black'>"+novi.getLastName()+"</font></html>");
		prikaziPrezime.setBounds(105, 102, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziPrezime);
		
		JLabel lblSpol = new JLabel("Spol:");
		lblSpol.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblSpol.setBounds(10, 142, 85, 23);
		frmAdminPanel.getContentPane().add(lblSpol);
		
		JLabel lblGodina = new JLabel("Godina:");
		lblGodina.setFont(new Font("Gadugi", Font.PLAIN, 12));
		lblGodina.setBounds(10, 180, 85, 23);
		frmAdminPanel.getContentPane().add(lblGodina);
		
		JLabel prikaziSpol = new JLabel("<html><font color='black'>"+novi.getGenderIs()+"</font></html>");
		prikaziSpol.setBounds(105, 136, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziSpol);
		
		JLabel prikaziGodine = new JLabel("<html><font color='black'>"+novi.getAgeIs()+"</font></html>");
		prikaziGodine.setBounds(105, 181, 104, 23);
		frmAdminPanel.getContentPane().add(prikaziGodine);
		
		JButton btnOtkljucajAnketu = new JButton("Otkljucaj Anketu");
		btnOtkljucajAnketu.setBackground(SystemColor.activeCaption);
		btnOtkljucajAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OtkljucajAnketu otkljucaj = new OtkljucajAnketu();
				otkljucaj.OtkljucajA();
			}
			});
		btnOtkljucajAnketu.setBounds(340, 107, 165, 30);
		frmAdminPanel.getContentPane().add(btnOtkljucajAnketu);
	}

}
