import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

import java.sql.*;

import javax.swing.JPasswordField;
import java.awt.Font;

public class Login {
	
	public static int id;
	public static String username = "";
	public static String first_name = "";
	public static String last_name = "";
	public static String gender_is = "";
	public static int gender;
	public static String age_is;

	// Definisi JDBC driver name i URL baze
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci
	static final String USER = "root";
	static final String PASS = "123456";

	private JFrame frmPoolSystem;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmPoolSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPoolSystem = new JFrame();
		frmPoolSystem.setTitle("Pool System - Login");
		frmPoolSystem.setResizable(false);
		frmPoolSystem.setBounds(100, 100, 479, 333);
		frmPoolSystem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPoolSystem.getContentPane().setLayout(null);

		JLabel unameText = new JLabel("Username:");
		unameText.setBounds(10, 182, 77, 14);
		frmPoolSystem.getContentPane().add(unameText);

		JLabel pwText = new JLabel("Password:");
		pwText.setBounds(10, 218, 77, 14);
		frmPoolSystem.getContentPane().add(pwText);

		usernameField = new JTextField();
		usernameField.setBounds(96, 179, 367, 20);
		frmPoolSystem.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JButton loginButton = new JButton("Login");

		loginButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				Connection conn = null;
				Statement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					// Napravi statement i izvrsi query
					stmt = conn.createStatement();
					String sql;
					sql = ("SELECT id, username, password, first_name, last_name, age, gender, user_role FROM Users WHERE username='"+usernameField.getText()+"' AND password='"+passwordField.getText()+"'");
					ResultSet rs = stmt.executeQuery(sql);

					// Provjeri da li su uname i pw tacni tj. da li query daje rezultat
					if (rs.next() == false) {
						JOptionPane.showMessageDialog(null, "Pogresni Podaci");
					}

					// Povuci podatke
					// ZA PRIMJER KORISTIMO ID KAO USER_ROLE (1-admin, 2-user)
					id = rs.getInt("id");
					username = rs.getString("username");
					first_name = rs.getString("first_name");
					last_name = rs.getString("last_name");
					int age = rs.getInt("age");
					age_is = String.valueOf(age);
					gender = rs.getInt("gender");
					
					if (gender == 1){
						gender_is = "Musko";
					}else{
						gender_is = "Zensko";
					}
					
					int user_role = rs.getInt("user_role");
					
					//Provjera ID-a (kasnije ce biti provjera User_Role
					if (user_role == 1) {
						// OTVORI ADMINA
						LogovanAdmin lAdmin = new LogovanAdmin();
						lAdmin.Admin();
						frmPoolSystem.dispose();
					}else{
						// OTVORI USERA
						LogovanKorisnik IKorisnik = new LogovanKorisnik();
						IKorisnik.LogovanProfil();
						frmPoolSystem.dispose();
					}

					// Zatvori resultset, statement i db konekciju i ispisi greske ako postoje 
					rs.close();
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
			}
		});
		loginButton.setBounds(21, 260, 200, 29);
		frmPoolSystem.getContentPane().add(loginButton);

		JButton registerButton = new JButton("Registruj Se");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistracijaKorisnika r = new RegistracijaKorisnika();
				r.RegistracijaIzLogina();
			}
		});
		registerButton.setBounds(248, 260, 200, 29);
		frmPoolSystem.getContentPane().add(registerButton);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		logo.setBounds(21, 24, 423, 118);
		frmPoolSystem.getContentPane().add(logo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(97, 215, 366, 20);
		frmPoolSystem.getContentPane().add(passwordField);
		
		
	}
}