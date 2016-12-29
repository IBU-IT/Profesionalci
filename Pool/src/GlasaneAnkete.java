import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.List;

public class GlasaneAnkete {
	ArrayList<String> groupNames = new ArrayList<String>();
	private JFrame frame;
 //
	/**
	 * Launch the application.
	 */
	public void GlasaneA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlasaneAnkete window = new GlasaneAnkete();
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
	public GlasaneAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Ankete na kojima si glasao");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAnketeNaKojima = new JLabel("ANKETE NA KOJIMA SI GLASAO");
		lblAnketeNaKojima.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblAnketeNaKojima.setBounds(131, 23, 273, 48);
		frame.getContentPane().add(lblAnketeNaKojima);
		DefaultListModel<String> model = new DefaultListModel<>();
		JList menu = new JList();
		menu.setBounds(23, 109, 468, 250);
		frame.getContentPane().add(menu);
		
		//public void DodajuBazu(String s){
				Connection conn = null;
				Statement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");

					// Napravi statement i izvrsi query
					stmt = conn.createStatement();
					String sql;
					
					sql = ("SELECT * FROM submited_answers WHERE voted=1");
					
					ResultSet rs = stmt.executeQuery(sql);
				//	String ;
					while(rs.next())
					{
						String groupName = rs.getString("voted=1");
						groupNames.add(groupName);
						
					}
					for(String s:groupNames){
						model.addElement(s);
					}
					menu = new JList(model);
				
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
	}
}
