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

			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT question_text FROM questions WHERE is_closed=1");
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String groupName = rs.getString("question_text");
				groupNames.add(groupName);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		}

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

				Connection conn = null;
				Statement stmt = null;
				try {

					Class.forName(DbConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
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
					se.printStackTrace();
				} catch (Exception x) {
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
