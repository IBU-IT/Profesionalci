
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class DodajAnketu {

	private JFrame frame;
	private JTextField textField;
	
	// Definisi JDBC driver name i URL baze
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

    // Db podaci
		static final String USER = "root";
		static final String PASS = "123456";

	/**
	 * Launch the application.
	 */
	public void DodajAnk() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajAnketu window = new DodajAnketu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dodaj Anketu");
		frame.setResizable(false);
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUpiiteImeAnkete = new JLabel("Upi\u0161ite ime ankete :");
		lblUpiiteImeAnkete.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblUpiiteImeAnkete.setBounds(165, 70, 200, 50);
		frame.getContentPane().add(lblUpiiteImeAnkete);
		
		JButton btnNapraviAnketu = new JButton("NAPRAVI ANKETU");
		btnNapraviAnketu.setBackground(SystemColor.activeCaption);
	
		btnNapraviAnketu.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNapraviAnketu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNapraviAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Spremi u varijable 
				String bazaGetText = textField.getText();
				int bazaIsClosed = 0;
				int questionID = 0;
				Connection conn = null;
				PreparedStatement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					
					
					
					stmt = conn.prepareStatement("INSERT INTO questions (question_text,is_closed) VALUES ('" + bazaGetText + "', " + bazaIsClosed +") ", Statement.RETURN_GENERATED_KEYS);
					//int idIzBaze = Integer.parseInt(autogenColumns);
					
					int affectedRows = stmt.executeUpdate();
					
					if (affectedRows == 0) {
			            throw new SQLException("Kreiranje pitanja bezuspješno");
			        }
					
					try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
			            if (generatedKeys.next()) {
			                questionID = generatedKeys.getInt(1);
			            }
			            else {
			                throw new SQLException("Kreira, no ID obtained.");
			            }
			        }
					
					// Zatvori resultset, statement i db konekciju i ispisi greske ako postoje 
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
				
				PitanjeDodajAnketu nesto = new PitanjeDodajAnketu();
				nesto.PDAnketu(questionID);
			}
		});
		btnNapraviAnketu.setBounds(117, 269, 287, 50);
		frame.getContentPane().add(btnNapraviAnketu);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Gadugi", Font.PLAIN, 14));
		textField.setBounds(104, 138, 318, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		//dodaj anketu
	}
}
