import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.SystemColor;



public class RegistracijaKorisnika {

	private static int spol = 0;
	private static int admin = 0;
	private static int godine = 0;
	
	// Definisi JDBC driver name i URL baze
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

		// Db podaci
		static final String USER = "root";
		static final String PASS = "123456";
	
	private JFrame frmRegistrujSe;
	/*private final Action action = new SwingAction();*/
	JButton button;
	Image img;
	//private Alert alert;
	private JTextField nField;
	private JTextField sField;
	private JTextField unameField;
	private JPasswordField pwField;

	/**
	 * Launch the application.
	 */
	//Nije jos zavrseno biti ce dodano na login da se korisnik u Login panelu moze registrovat
	public void RegistracijaIzLogina() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaKorisnika window = new RegistracijaKorisnika();
					window.frmRegistrujSe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistracijaKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrujSe = new JFrame();
		frmRegistrujSe.setResizable(false);
		frmRegistrujSe.setTitle("Registruj Se");
		frmRegistrujSe.setBounds(100, 100, 450, 270);
		frmRegistrujSe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrujSe.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(10, 13, 46, 14);
		frmRegistrujSe.getContentPane().add(lblName);
		
		nField = new JTextField();
		nField.setBounds(76, 11, 210, 20);
		frmRegistrujSe.getContentPane().add(nField);
		nField.setColumns(10);
		
		
			
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSurname.setBounds(10, 38, 51, 14);
		frmRegistrujSe.getContentPane().add(lblSurname);
		
		
		sField = new JTextField();
		sField.setBounds(76, 36, 210, 20);
		frmRegistrujSe.getContentPane().add(sField);
		sField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAge.setBounds(10, 63, 46, 14);
		frmRegistrujSe.getContentPane().add(lblAge);
		
		final JSpinner spinnerAge = new JSpinner();
		spinnerAge.setBounds(76, 61, 51, 20);
		frmRegistrujSe.getContentPane().add(spinnerAge);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 88, 67, 14);
		frmRegistrujSe.getContentPane().add(lblNewLabel);
		
		unameField = new JTextField();
		unameField.setBounds(76, 86, 210, 20);
		frmRegistrujSe.getContentPane().add(unameField);
		unameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(10, 113, 67, 14);
		frmRegistrujSe.getContentPane().add(lblPassword);
		
		pwField = new JPasswordField();
		pwField.setBounds(76, 110, 210, 20);
		frmRegistrujSe.getContentPane().add(pwField);
		
		JLabel lblGendre = new JLabel("Gender");
		lblGendre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGendre.setBounds(10, 140, 67, 14);
		frmRegistrujSe.getContentPane().add(lblGendre);
		
		final JRadioButton Male = new JRadioButton("Male");
		Male.setFont(new Font("Arial", Font.PLAIN, 11));
		Male.setBounds(76, 141, 51, 23);
		frmRegistrujSe.getContentPane().add(Male);
		
		final JRadioButton Female = new JRadioButton("Female");
		Female.setFont(new Font("Arial", Font.PLAIN, 11));
		Female.setBounds(157, 140, 109, 23);
		frmRegistrujSe.getContentPane().add(Female);
		
		final ButtonGroup grupa = new ButtonGroup();
	    grupa.add(Male);
	    grupa.add(Female);
		
		JButton RegistrujSe = new JButton("REGISTRUJ SE");
		RegistrujSe.setBackground(SystemColor.activeCaption);
		RegistrujSe.setFont(new Font("Gadugi", Font.BOLD, 16));
		RegistrujSe.setBounds(32, 171, 375, 44);
		frmRegistrujSe.getContentPane().add(RegistrujSe);
		RegistrujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int greska = 1;
				if(nField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Morate upisati ime");
					greska = 1;
				}else{greska = 0;}
				if(sField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Morate upisati prezime");
					greska = 2;
				}else{greska = 0;}
				
				setGodine((Integer) spinnerAge.getValue());
				
				if(getGodine() <= 0){
					JOptionPane.showMessageDialog(null, "Godine moraju biti unesene i ne mogu biti <0");
					greska = 3;
				}else{greska = 0;}
				
				if(unameField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Morate upisati username");
					greska = 4;
				}else{greska = 0;}
				if(pwField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Morate upisati password");
					greska = 5;
				}else{greska = 0;}
				if(Male.isSelected()){
		            setSpol(1);
		        }
		        else if(Female.isSelected()){
		        	setSpol(2);
		        }
				if(getSpol() == 0){
					JOptionPane.showMessageDialog(null, "Spol korisnika nije definisan.");
					greska = 6;
				}else{greska = 0;}
				
				//Spremi u varijable
				if(greska == 0){
				String bazaUname = unameField.getText();
				String bazaPwd = pwField.getText();
				String bazaFname = nField.getText();
				String bazaLname = sField.getText();
				int bazaGo = getGodine();
				int bazaSpoll = getSpol();
				int bazaRolee = getAdmin();
				
				//Kad je sve provjereno unesi to sve u bazu	
				Connection conn = null;
				Statement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					// Napravi statement i izvrsi query
					stmt = conn.createStatement();
					int gotovo = stmt.executeUpdate("INSERT INTO users (username, password, first_name, last_name, age, gender, user_role) VALUES ('" + bazaUname + "', '" + bazaPwd +"','" + bazaFname + "' , '" + bazaLname + "','" + bazaGo + "', '" + bazaSpoll + "', '" + bazaRolee + "') ");
					
					if (gotovo>0){
						JOptionPane.showMessageDialog(null, "Uspješno ste dodali korisnika");
						unameField.setText("");
						pwField.setText("");
						nField.setText("");
						sField.setText("");
						spinnerAge.setValue(0);
						grupa.clearSelection();
						CloseFrame();
						
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
				
			}else{
				JOptionPane.showMessageDialog(null, "GRESKA");
			}
				
		}

			private void CloseFrame() {
				frmRegistrujSe.dispose();
				
			}
			
		});
		
	}
	
	public int getGodine() {
		return godine;
	}

	public static void setGodine(int godine) {
		RegistracijaKorisnika.godine = godine;
	}
	public int getSpol() {
		return spol;
	}

	public static void setSpol(int spol) {
		RegistracijaKorisnika.spol = spol;
	}
	public int getAdmin() {
		return admin;
	}

	public static void setAdmin(int admin) {
		RegistracijaKorisnika.admin = admin;
	}
}

//ATIF IMA GRESKU. NE MOZE KOMITAT
		
