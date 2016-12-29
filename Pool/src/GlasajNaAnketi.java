import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GlasajNaAnketi {
	
	ArrayList<String> groupNames = new ArrayList<String>();
	private static int id;
	private static String pitanje="";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void GlasajnaA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlasajNaAnketi window = new GlasajNaAnketi();
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
	public GlasajNaAnketi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Glasaj na Anketi");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOdaberiAnketu = new JLabel("Izaberite anketu na kojoj \u017Eelite glasati:");
		lblOdaberiAnketu.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblOdaberiAnketu.setBounds(10, 11, 357, 20);
		frame.getContentPane().add(lblOdaberiAnketu);
		
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
			sql = ("SELECT question_text FROM questions WHERE is_closed=0");
			ResultSet rs = stmt.executeQuery(sql);
		
			while (rs.next()) { 
			    String groupName = rs.getString("question_text"); 
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
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Gadugi", Font.PLAIN, 12));
		comboBox.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBox.setModel(model);
		
		JButton btnGlasaj = new JButton("Prikazi odgovore za anketu");
		btnGlasaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setPitanje((String)comboBox.getSelectedItem());
				
				//Izvuci ID
				Connection conn2 = null;
				Statement stmt2 = null;		
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
					
					stmt2 = conn2.createStatement();
					String sql;
					sql = ("SELECT id FROM questions WHERE question_text='"+getPitanje()+"'  ");
					ResultSet rs2 = stmt2.executeQuery(sql);
					rs2.next();
					setId(rs2.getInt("id"));
					
					rs2.close(); 
					stmt2.close();
					conn2.close();
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				}
				catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				}
				
				//OTVORI ODGOVORE ZA IZABRANU ANKETU USKORO
				PrikaziOdgovoreIzabraneAnkete a = new PrikaziOdgovoreIzabraneAnkete();
				a.prikaziOdgovore();
			
			}
		});
		btnGlasaj.setBackground(SystemColor.activeCaption);
		btnGlasaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnGlasaj.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnGlasaj);
	}
	
	public int getId() {
		return id;
	}

	public static void setId(int id) {
		GlasajNaAnketi.id = id;
	}
	
	public String getPitanje() {
		return pitanje;
	}

	public static void setPitanje(String pitanje) {
		GlasajNaAnketi.pitanje = pitanje;
	}
}
