import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class GlasaneAnkete {
	
	// Definisi JDBC driver name i URL baze
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false";

		// Db podaci
		static final String USER = "root";
		static final String PASS = "123456";
		
	ArrayList<UserSurvey> userSurveys = new ArrayList<>();
	private JFrame frame;
	private JTable table;
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
		
		Object columnNames[] = { "Pitanje "};
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		
		//public void DodajuBazu(String s){
				Connection conn = null;
				PreparedStatement stmt = null;
				try {
					Login l = new Login();					
					int userID = l.getId();
					
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");
					String sqlSelect = "SELECT SA.question_id, SA.user_id, Q.question_text FROM `submited_answers` AS SA INNER JOIN questions AS Q ON SA.question_id = Q.id WHERE user_id = ?";
					
					// Napravi statement i izvrsi query
					stmt = conn.prepareStatement(sqlSelect);
					stmt.setInt(1, userID);
					ResultSet rs = stmt.executeQuery();
					
					while(rs.next())
					{
						UserSurvey us = new UserSurvey();
						us.questionId = rs.getInt("question_id");
						us.questionText = rs.getString("question_text");
						us.userID = rs.getInt("user_id");
						
						userSurveys.add(us);
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
				
				for (int i = 0; i < userSurveys.size(); i++){
					   String name = userSurveys.get(i).questionText;
					   Object[] data = {name};
					   tableModel.addRow(data);
					}
				
				table = new JTable(tableModel);
				table.setBounds(10, 104, 494, 266);
				frame.getContentPane().add(table);		
	}
}
