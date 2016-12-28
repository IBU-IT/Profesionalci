import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;


public class ObrisiAnketu {
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
	public void ObrisiA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObrisiAnketu window = new ObrisiAnketu();
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
	public ObrisiAnketu() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Obrisi Anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblBrisanjeAnkete = new JLabel("ODABERI ANKETU ZA BRISANJE :");
		lblBrisanjeAnkete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBrisanjeAnkete.setBounds(93, 33, 327, 50);
		frame.getContentPane().add(lblBrisanjeAnkete);
		
		//TRY
		Connection conn = null;
		Statement stmt = null;
		
		
		
		try {
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
			
			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT question_text FROM questions");
			ResultSet rs = stmt.executeQuery(sql);
		
			while (rs.next()) { 
			    String groupName = rs.getString("question_text"); 
			    // add group names to the array list
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
		
		@SuppressWarnings("rawtypes")
		final JComboBox comboBoxObrisiAnketu = new JComboBox();
		comboBoxObrisiAnketu.setBounds(93, 119, 327, 36);
		frame.getContentPane().add(comboBoxObrisiAnketu);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxObrisiAnketu.setModel(model);
		
		JButton btnObrisi = new JButton("OBRISI ");
		btnObrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zakkank = (String)comboBoxObrisiAnketu.getSelectedItem();
				// Spremi u varijable 
				
				Connection conn = null;
				
				
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");
					
					// Poziv id-a iz baze, brisanje ankete i odgovora
					Statement stmt3 = null;
					  stmt3 = conn.createStatement();
					  String queri = ("SELECT id FROM questions WHERE question_text = '"+zakkank+"' ");
				      ResultSet rs = stmt3.executeQuery(queri);
				      rs.next();
				      int id = rs.getInt("id");
				      
				      Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				      String insertEmp2 = "DELETE FROM questions WHERE id = '"+id+"' ";
				      String insertEmp3 = "DELETE FROM answers WHERE question_id = '"+id+"' ";
				      
				      conn.setAutoCommit(false);
				      stmt1.addBatch(insertEmp2);
				      stmt1.addBatch(insertEmp3);
				      stmt1.executeBatch();
				      conn.commit();
				      
				      if(id>0){
							JOptionPane.showMessageDialog(null, "Anketa uspjesno obrisana");
							CloseFrame();
						}
			
					stmt1.close();
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

			private void CloseFrame() {
				frame.dispose();
				
			}
		});
		btnObrisi.setBackground(SystemColor.activeCaption);
		btnObrisi.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnObrisi.setBounds(157, 289, 200, 36);
		frame.getContentPane().add(btnObrisi);
	}
	public void UgasiGa() {
		frame.dispose();
}
}
