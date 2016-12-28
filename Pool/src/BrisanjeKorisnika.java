import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BrisanjeKorisnika {
	
	// Definisi JDBC driver name i URL baze
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

	// Db podaci
	static final String USER = "root";
	static final String PASS = "123456";
	
	ArrayList<String> groupNames = new ArrayList<String>();
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void ObrisiK() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrisanjeKorisnika window = new BrisanjeKorisnika();
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
	public BrisanjeKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tekstInfo = new JLabel("Odabreite korisnika kojega zelite obrisati:");
		tekstInfo.setBounds(10, 11, 235, 14);
		frame.getContentPane().add(tekstInfo);
		
		Connection conn = null;
		Statement stmt = null;
				
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
			
			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT username FROM users");
			ResultSet rs = stmt.executeQuery(sql);
		
			while (rs.next()) { 
			    String groupName = rs.getString("username"); 
			    groupNames.add(groupName);
			} 
			
			rs.close(); 
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Errors JDBC
			se.printStackTrace();
		}
		catch (Exception x) {
			// Errors za Class.forName
			x.printStackTrace();
		}
		//TRY
		
		final JComboBox comboBoxKorisnici = new JComboBox();
		comboBoxKorisnici.setBounds(217, 8, 207, 20);
		frame.getContentPane().add(comboBoxKorisnici);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxKorisnici.setModel(model);
		
		
		JButton btnObrisiKorisnika = new JButton("OBRISI !");
		btnObrisiKorisnika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String anketa = (String)comboBoxKorisnici.getSelectedItem();
				Connection conn = null;
				Statement stmt = null;

				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
					
					stmt = conn.createStatement();
					int gotovo = stmt.executeUpdate("DELETE FROM users WHERE username = '"+anketa+"' ");				
					
					if(gotovo>0){
						JOptionPane.showMessageDialog(null, "Korisnik uspjesno obrisan");
					}
					
					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				}
				catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				}	
			}
		});
		btnObrisiKorisnika.setBounds(10, 48, 414, 23);
		frame.getContentPane().add(btnObrisiKorisnika);
	}
}
