import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSpinner;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class DodajKorisnika {
	
	private static int spol = 0;
	private static int admin = 0;
	private static int godine = 0;
	
	// Definisi JDBC driver name i URL baze
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci
	static final String USER = "root";
	static final String PASS = "123456";

	private JFrame frmDodajNovogKorisnika;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField imeField;
	private JTextField prezimeField;

	/**
	 * Launch the application.
	 */
	public void DodajK() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajKorisnika window = new DodajKorisnika();
					window.frmDodajNovogKorisnika.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodajKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDodajNovogKorisnika = new JFrame();
		frmDodajNovogKorisnika.setResizable(false);
		frmDodajNovogKorisnika.setTitle("Dodaj Korisnika");
		frmDodajNovogKorisnika.setBounds(100, 100, 520, 410);
		frmDodajNovogKorisnika.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDodajNovogKorisnika.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblUsername.setBounds(10, 68, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblPassword.setBounds(10, 93, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblPassword);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblIme.setBounds(10, 118, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblPrezime.setBounds(10, 143, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblPrezime);
		
		JLabel lblGodine = new JLabel("Godine:");
		lblGodine.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblGodine.setBounds(10, 168, 75, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblGodine);
		
		JLabel lblSpol = new JLabel("Spol:");
		lblSpol.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblSpol.setBounds(10, 193, 46, 26);
		frmDodajNovogKorisnika.getContentPane().add(lblSpol);
		
		JLabel lblIfAdmin = new JLabel("Da li je administrator?");
		lblIfAdmin.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblIfAdmin.setBounds(10, 230, 153, 14);
		frmDodajNovogKorisnika.getContentPane().add(lblIfAdmin);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Gadugi", Font.PLAIN, 12));
		usernameField.setBounds(93, 62, 170, 20);
		frmDodajNovogKorisnika.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Gadugi", Font.PLAIN, 12));
		passwordField.setColumns(10);
		passwordField.setBounds(93, 87, 170, 20);
		frmDodajNovogKorisnika.getContentPane().add(passwordField);
		
		imeField = new JTextField();
		imeField.setFont(new Font("Gadugi", Font.PLAIN, 12));
		imeField.setColumns(10);
		imeField.setBounds(93, 112, 170, 20);
		frmDodajNovogKorisnika.getContentPane().add(imeField);
		
		prezimeField = new JTextField();
		prezimeField.setFont(new Font("Gadugi", Font.PLAIN, 12));
		prezimeField.setColumns(10);
		prezimeField.setBounds(93, 137, 170, 20);
		frmDodajNovogKorisnika.getContentPane().add(prezimeField);
		
		final JSpinner spinner = new JSpinner();
		spinner.setBounds(95, 167, 46, 20);
		frmDodajNovogKorisnika.getContentPane().add(spinner);
		
		final JRadioButton rdbtnMusko = new JRadioButton("Musko");
		rdbtnMusko.setFont(new Font("Gadugi", Font.PLAIN, 12));
		rdbtnMusko.setBounds(93, 197, 84, 20);
		frmDodajNovogKorisnika.getContentPane().add(rdbtnMusko);
		
		final JRadioButton rdbtnensko = new JRadioButton("\u017Densko");
		rdbtnensko.setFont(new Font("Gadugi", Font.PLAIN, 12));
		rdbtnensko.setBounds(179, 199, 102, 17);
		frmDodajNovogKorisnika.getContentPane().add(rdbtnensko);
		
		final ButtonGroup group = new ButtonGroup();
	    group.add(rdbtnMusko);
	    group.add(rdbtnensko);
		
		final JCheckBox chckbxAdmin = new JCheckBox("");
		chckbxAdmin.setBounds(159, 230, 28, 14);
		frmDodajNovogKorisnika.getContentPane().add(chckbxAdmin);
		
		JButton btnDodajNovogKorisnika = new JButton("Dodaj Novog Korisnika");
		btnDodajNovogKorisnika.setBackground(SystemColor.activeCaption);
		btnDodajNovogKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDodajNovogKorisnika.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnDodajNovogKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int greska = 1;
			if(usernameField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Username mora biti unesen");
				greska = 1;
			}else{greska = 0;}
			if(passwordField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Password mora biti unesen");
				greska = 1;
			}else{greska = 0;}
			if(imeField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Ime mora biti uneseno");
				greska=1;
			}else{greska = 0;}
			if(prezimeField.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Prezime mora biti uneseno");
				greska = 1;
			}else{greska = 0;}
			
			//Postavi godine
			setGodine((Integer) spinner.getValue());
			
			if(getGodine() <= 0 ){
				JOptionPane.showMessageDialog(null, "Godine moraju biti unesene i ne mogu biti negativna vrijednost");
				greska = 1;
			}else{greska = 0;}
		    if(rdbtnMusko.isSelected()){
	            setSpol(1);
	        }
	        else if(rdbtnensko.isSelected()){
	        	setSpol(2);
	        }
			if(getSpol() == 0){
				JOptionPane.showMessageDialog(null, "Spol korisnika nije definisan.");
				greska = 1;
			}else{greska = 0;}
			if(chckbxAdmin.isSelected() == true) {
				setAdmin(1);
			}else{
				setAdmin(0);
			}
			
			//Spremi u varijable
			String bazaUsername = usernameField.getText();
			String bazaPassword = passwordField.getText();
			String bazaIme = imeField.getText();
			String bazaPrezime = prezimeField.getText();
			int bazaGodine = getGodine();
			int bazaSpol = getSpol();
			int bazaRole = getAdmin();
			
			//Kad je sve provjereno unesi to sve u bazu
			if(greska == 0){
			Connection conn = null;
			Statement stmt = null;
			try {
				// Registruj JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// Zapocni konekciju conn
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// Napravi statement i izvrsi query
				stmt = conn.createStatement();
				int gotovo = stmt.executeUpdate("INSERT INTO users (username, password, first_name, last_name, age, gender, user_role) VALUES ('" + bazaUsername + "', '" + bazaPassword +"','" + bazaIme + "' , '" + bazaPrezime + "','" + bazaGodine + "', '" + bazaSpol + "', '" + bazaRole + "') ");
				
				if (gotovo>0){
					JOptionPane.showMessageDialog(null, "Uspješno ste dodali korisnika");
					usernameField.setText("");
					passwordField.setText("");
					imeField.setText("");
					prezimeField.setText("");
					spinner.setValue(0);
					group.clearSelection();
					chckbxAdmin.setSelected(false);
					
				}else{
					JOptionPane.showMessageDialog(null, "Došlo je do greške izmedju aplikacije i dodavanja korisnika u bazu");
				}
				
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Errors JDBC
				se.printStackTrace();
			} catch (Exception x) {
				// Errors za Class.forName
				x.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}// zavrsi try try
			}// zavrsi glavni try try
			
			} //zavrsi bazu
		}
		});
		btnDodajNovogKorisnika.setBounds(64, 302, 359, 43);
		frmDodajNovogKorisnika.getContentPane().add(btnDodajNovogKorisnika);
		
		JLabel lblIspuniteSvaPolja = new JLabel("ISPUNITE SVA POLJA");
		lblIspuniteSvaPolja.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblIspuniteSvaPolja.setBounds(165, 11, 200, 50);
		frmDodajNovogKorisnika.getContentPane().add(lblIspuniteSvaPolja);
		
	}

	//get i set
	public int getSpol() {
		return spol;
	}

	public static void setSpol(int spol) {
		DodajKorisnika.spol = spol;
	}
	public int getAdmin() {
		return admin;
	}

	public static void setAdmin(int admin) {
		DodajKorisnika.admin = admin;
	}
	public int getGodine() {
		return godine;
	}

	public static void setGodine(int godine) {
		DodajKorisnika.godine = godine;
	}
}
