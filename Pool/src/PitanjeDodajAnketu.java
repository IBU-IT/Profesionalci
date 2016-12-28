import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.SystemColor;


public class PitanjeDodajAnketu extends DodajAnketu {

	private JFrame frame;
	private JTextField odgovor1;
	private JTextField odgovor2;
	private JTextField odgovor3;
	private int pitanjeID;
	
	// Definisi JDBC driver name i URL baze
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci 
			static final String USER = "root";
			static final String PASS = "123456";
			private JButton btnUnesiOdgovore;

	/**
	 * Launch the application.
	 */
	public void PDAnketu(final int pit) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PitanjeDodajAnketu window = new PitanjeDodajAnketu(pit);
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
	public PitanjeDodajAnketu(int a) {
		this.pitanjeID = a;
		initialize();
	}
	
	/**
	 * @wbp.parser.constructor
	 */
 
	public PitanjeDodajAnketu() {
		initialize();
	}



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Odgovori za anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUnesitePitanjeI = new JLabel("Unesite odgovor u svako polje :");
		lblUnesitePitanjeI.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblUnesitePitanjeI.setBounds(118, 37, 290, 50);
		frame.getContentPane().add(lblUnesitePitanjeI);
		
		odgovor1 = new JTextField();
		odgovor1.setBounds(91, 109, 317, 50);
		frame.getContentPane().add(odgovor1);
		odgovor1.setColumns(10);
		
		odgovor2 = new JTextField();
		odgovor2.setBounds(91, 170, 317, 50);
		frame.getContentPane().add(odgovor2);
		odgovor2.setColumns(10);
		
		
		odgovor3 = new JTextField();
		odgovor3.setBounds(91, 231, 317, 50);
		frame.getContentPane().add(odgovor3);
		odgovor3.setColumns(10);
		
		btnUnesiOdgovore = new JButton("UNESI ODGOVORE");
		btnUnesiOdgovore.setBackground(SystemColor.activeCaption);
		btnUnesiOdgovore.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnUnesiOdgovore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnesiOdgovore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// Spremi u varijable 
				int bazaId = pitanjeID;
				String getAnswer1 = odgovor1.getText();
				String getAnswer2 = odgovor2.getText();
				String getAnswer3 = odgovor3.getText();
				
				
				Connection conn = null;
				
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					int atif = 0;
					conn = DriverManager.getConnection(DB_URL, USER, PASS);

					// Napravi statement i izvrsi query
					//stmt = conn.createStatement();
					//stmt.executeUpdate("INSERT INTO questions (question_text,is_closed) VALUES ('" + bazaGetText + "', '" + bazaIsClosed +"') ");
					Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					
					String prva = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId + "', '" + getAnswer1 + "', '"+atif+"')";
					
					
					String druga = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId + "', '" + getAnswer2 + "', '"+atif+"')";
					
					
					String treca = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId + "', '" + getAnswer3+ "', '"+atif+"')";
					conn.setAutoCommit(false);
				      
				      stmt.addBatch(prva);
				      stmt.addBatch(druga);
				      stmt.addBatch(treca);
				      stmt.executeBatch();
				      conn.commit();
				      conn.close();	
					
					
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				} catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				} finally {
					
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}// zavrsi try try
				}// zavrsi glavni try try
			}
			});
		btnUnesiOdgovore.setBounds(141, 307, 200, 50);
		frame.getContentPane().add(btnUnesiOdgovore);
			//veno
		// radi
	}
}
		
		
			
		
	





		
	


	


