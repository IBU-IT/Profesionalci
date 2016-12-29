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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setTitle("BRISANJE KORSINIKA");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel tekstInfo = new JLabel("ODABERITE KORISNIKA ZA BRISANJE :");
		tekstInfo.setFont(new Font("Gadugi", Font.BOLD, 14));
		tekstInfo.setBounds(10, 11, 360, 20);
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
		comboBoxKorisnici.setFont(new Font("Gadugi", Font.BOLD, 14));
		comboBoxKorisnici.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBoxKorisnici);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxKorisnici.setModel(model);
		
		
		JButton btnObrisiKorisnika = new JButton("OBRISI");
		btnObrisiKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnObrisiKorisnika.setFont(new Font("Gadugi", Font.BOLD, 16));
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
						CloseFrame();
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
		btnObrisiKorisnika.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnObrisiKorisnika);
	}

	public void CloseFrame() {
		frame.dispose();
		
	}
}
