import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OtkljucajAnketu {

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
	public void OtkljucajA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OtkljucajAnketu window = new OtkljucajAnketu();
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
	public OtkljucajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Otkljucaj anketu");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOtkljucajAnketu = new JLabel("ODABERI ANKETU ZA OTKLJUCAVANJE : ");
		lblOtkljucajAnketu.setBounds(10, 11, 360, 20);
		lblOtkljucajAnketu.setFont(new Font("Gadugi", Font.BOLD, 14));
		frame.getContentPane().add(lblOtkljucajAnketu);
		// TRY
		Connection conn = null;
		Statement stmt = null;

		try {
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root",
					"123456");

			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT question_text FROM questions WHERE is_closed=1");
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
		} catch (Exception x) {
			// Errors za Class.forName
			x.printStackTrace();
		}
		// TRY

		final JComboBox comboBoxOtkljucajAnketu = new JComboBox();
		comboBoxOtkljucajAnketu.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBoxOtkljucajAnketu);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxOtkljucajAnketu.setModel(model);

		JButton btnOtkljucaj = new JButton("OTKLJUCAJ");
		btnOtkljucaj.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				String zakkank = (String) comboBoxOtkljucajAnketu.getSelectedItem();
				// Spremi u varijable

				Connection conn = null;
				Statement stmt = null;
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection(
							"jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root",
							"123456");
					stmt = conn.createStatement();

					int zakAnk = stmt.executeUpdate(
							"UPDATE questions SET is_closed = 0 WHERE question_text = '" + zakkank + "'");
					if (zakAnk > 0) {
						JOptionPane.showMessageDialog(null, "Anketa uspjesno otkljucana !");
						UgasiGa();

					}

					stmt.close();
					conn.close();
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				} catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				}
			}
		});
		btnOtkljucaj.setBackground(SystemColor.activeCaption);
		btnOtkljucaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnOtkljucaj.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnOtkljucaj);

	}

	public void UgasiGa() {
		frame.dispose();

	}
}
