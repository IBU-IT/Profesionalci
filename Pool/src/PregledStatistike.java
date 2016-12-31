import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
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

public class PregledStatistike {

	private JFrame frame;
	ArrayList<String> groupNames = new ArrayList<String>();
	private static String IzabranoPitanje = "";

	/**
	 * Launch the application.
	 */
	public void PregledS() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledStatistike window = new PregledStatistike();
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
	public PregledStatistike() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Pregled Statistike");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblStatistika = new JLabel("ODABERITE ANKETU DA VIDITE STATISTIKU :");
		lblStatistika.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblStatistika.setBounds(10, 11, 360, 20);
		frame.getContentPane().add(lblStatistika);

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
			sql = ("SELECT question_text from questions");
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
		} catch (Exception x) {
			// Errors za Class.forName
			x.printStackTrace();
		}
		// TRY

		final JComboBox listaAnketa = new JComboBox();
		listaAnketa.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(listaAnketa);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		listaAnketa.setModel(model);

		JButton btnNewButton = new JButton("PRIKAZI STATISTIKU");
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setIzabranoPitanje((String) listaAnketa.getSelectedItem());
				PrikaziStatistikuIzabranog x = new PrikaziStatistikuIzabranog();
				x.stats();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnNewButton);
	}

	public String getIzabranoPitanje() {
		return IzabranoPitanje;
	}

	public void setIzabranoPitanje(String IzabranoPitanje) {
		PregledStatistike.IzabranoPitanje = IzabranoPitanje;
	}

}
