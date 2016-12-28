import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class PrikaziGreskeAdmin {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void PrikaziGreskeAdmin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziGreskeAdmin window = new PrikaziGreskeAdmin();
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
	public PrikaziGreskeAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 715, 420);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	//}
	//public void DodajuBazu(String s){
		Connection conn = null;
		Statement stmt = null;
		try {
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "");

			// Napravi statement i izvrsi query
			stmt = conn.createStatement();
			String sql;
			
			sql = ("SELECT * FROM feedback");
			
			ResultSet rs = stmt.executeQuery(sql);
			String greska;
			while(rs.next())
			{
				greska=rs.getString("FeedBack");
				textField.setText(textField.getText()+"\n"+greska);
				
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

	}

}