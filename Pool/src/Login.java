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

public class Login {
	
	public static int id;
	private static String username = "";
	private static String first_name = "";
	private static String last_name = "";
	private static String gender_is = "";
	private static int gender;
	private static String age_is;

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
		frmPoolSystem.setBounds(100, 100, 479, 335);
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
					setId(rs.getInt("id"));
					setUsername(rs.getString("username"));
					setFirstName(rs.getString("first_name"));
					setLastName(rs.getString("last_name"));
					int age = rs.getInt("age");
					setAgeIs(String.valueOf(age));
					setGender(rs.getInt("gender"));
					int user_role = rs.getInt("user_role");
					
					if (gender == 1){
						setGenderIs("Musko");
					}else{
						setGenderIs("Zensko");
					}
					
					//Provjera User_Role (admin 1, sve ostalo user)
					if (user_role == 1) {
						// OTVORI ADMIN
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
	
	//Getteri i setteri
	public String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		Login.username = username;
	}
	
	public int getId() {
		return id;
	}

	public static void setId(int id) {
		Login.id = id;
	}
	
	public String getFirstName() {
		return first_name;
	}

	public static void setFirstName(String first_name) {
		Login.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}

	public static void setLastName(String last_name) {
		Login.last_name = last_name;
	}
	
	public int getGender() {
		return gender;
	}

	public static void setGender(int gender) {
		Login.gender = gender;
	}
	
	public String getGenderIs() {
		return gender_is;
	}

	public static void setGenderIs(String gender_is) {
		Login.gender_is = gender_is;
	}
	
	public String getAgeIs() {
		return age_is;
	}

	public static void setAgeIs(String age_is) {
		Login.age_is = age_is;
	}
}