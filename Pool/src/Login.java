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
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login {

	private static int id;
	private static String username = "";
	private static String first_name = "";
	private static String last_name = "";
	private static int age;
	private static String age_is;
	private static int gender;
	private static String gender_is = "";
	private static int user_role;

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
		frmPoolSystem.getContentPane().setBackground(SystemColor.control);
		frmPoolSystem.setBackground(SystemColor.activeCaption);
		frmPoolSystem.setTitle("MySurvey Login");
		frmPoolSystem.setResizable(false);
		frmPoolSystem.setBounds(100, 100, 520, 410);
		frmPoolSystem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPoolSystem.getContentPane().setLayout(null);

		JLabel unameText = new JLabel("Username:");
		unameText.setFont(new Font("Gadugi", Font.BOLD, 14));
		unameText.setBounds(84, 181, 77, 14);
		frmPoolSystem.getContentPane().add(unameText);

		JLabel pwText = new JLabel("Password:");
		pwText.setFont(new Font("Gadugi", Font.BOLD, 14));
		pwText.setBounds(84, 216, 77, 14);
		frmPoolSystem.getContentPane().add(pwText);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Gadugi", Font.PLAIN, 12));
		usernameField.setForeground(SystemColor.infoText);
		usernameField.setBackground(SystemColor.window);
		usernameField.setBounds(171, 179, 257, 20);
		frmPoolSystem.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBackground(SystemColor.activeCaption);

		loginButton.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				LoginUser();
			} // zavrsi bazu
		});

		loginButton.setBounds(44, 306, 200, 29);
		frmPoolSystem.getContentPane().add(loginButton);

		JButton registerButton = new JButton("Registruj Se");
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		registerButton.setBackground(SystemColor.activeCaption);
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistracijaKorisnika r = new RegistracijaKorisnika();
				r.RegistracijaIzLogina();
			}
		});
		registerButton.setBounds(275, 306, 200, 29);
		frmPoolSystem.getContentPane().add(registerButton);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Login.class.getResource("/images/logo.png")));
		logo.setBounds(52, 23, 423, 118);
		frmPoolSystem.getContentPane().add(logo);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		passwordField.setBounds(171, 215, 257, 20);
		frmPoolSystem.getContentPane().add(passwordField);

		passwordField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginUser();
			}
		});

	}

	public void LoginUser() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			String loginSelect = "SELECT id, username, password, first_name, last_name, age, gender, user_role FROM Users WHERE BINARY username = ? AND BINARY password = ?";
			stmt = conn.prepareStatement(loginSelect);
			stmt.setString(1, usernameField.getText());
			stmt.setString(2, passwordField.getText());

			ResultSet rs = stmt.executeQuery();

			if (rs.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}

			setId(rs.getInt("id"));
			setUsername(rs.getString("username"));
			setFirstName(rs.getString("first_name"));
			setLastName(rs.getString("last_name"));
			setAge(rs.getInt("age"));
			setAgeIs(String.valueOf(age));
			setGender(rs.getInt("gender"));
			setUserRole(rs.getInt("user_role"));

			if (getGender() == 1) {
				setGenderIs("Musko");
			} else {
				setGenderIs("Zensko");
			}

			if (getUserRole() == 1) {
				LogovanAdmin lAdmin = new LogovanAdmin();
				lAdmin.Admin();
				frmPoolSystem.dispose();
			} else {
				LogovanKorisnik IKorisnik = new LogovanKorisnik();
				IKorisnik.LogovanProfil();
				frmPoolSystem.dispose();
			}

			rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

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

	public int getAge() {
		return age;
	}

	public static void setAge(int age) {
		Login.age = age;
	}

	public String getAgeIs() {
		return age_is;
	}

	public static void setAgeIs(String age_is) {
		Login.age_is = age_is;
	}

	public int getUserRole() {
		return user_role;
	}

	public static void setUserRole(int user_role) {
		Login.user_role = user_role;
	}
}
