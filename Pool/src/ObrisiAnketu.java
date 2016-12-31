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
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblBrisanjeAnkete = new JLabel("ODABERI ANKETU ZA BRISANJE :");
		lblBrisanjeAnkete.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblBrisanjeAnkete.setBounds(10, 11, 360, 20);
		frame.getContentPane().add(lblBrisanjeAnkete);

		Connection conn = null;
		Statement stmt = null;

		try {

			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			stmt = conn.createStatement();
			String sql;
			sql = ("SELECT question_text FROM questions");
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

		@SuppressWarnings("rawtypes")
		final JComboBox comboBoxObrisiAnketu = new JComboBox();
		comboBoxObrisiAnketu.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBoxObrisiAnketu);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBoxObrisiAnketu.setModel(model);

		JButton btnObrisi = new JButton("OBRISI ");
		btnObrisi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String zakkank = (String) comboBoxObrisiAnketu.getSelectedItem();
				Connection conn = null;

				try {
					Class.forName(DbConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

					Statement stmt3 = null;
					stmt3 = conn.createStatement();
					String queri = ("SELECT id FROM questions WHERE question_text = '" + zakkank + "' ");
					ResultSet rs = stmt3.executeQuery(queri);
					rs.next();
					int id = rs.getInt("id");

					Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String insertEmp2 = "DELETE FROM questions WHERE id = '" + id + "' ";
					String insertEmp3 = "DELETE FROM answers WHERE question_id = '" + id + "' ";

					conn.setAutoCommit(false);
					stmt1.addBatch(insertEmp2);
					stmt1.addBatch(insertEmp3);
					stmt1.executeBatch();
					conn.commit();

					if (id > 0) {
						JOptionPane.showMessageDialog(null, "Anketa uspjesno obrisana");
						CloseFrame();
					}

					stmt1.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception x) {
					x.printStackTrace();
				}
			}

			private void CloseFrame() {
				frame.dispose();

			}
		});
		btnObrisi.setBackground(SystemColor.activeCaption);
		btnObrisi.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnObrisi.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnObrisi);
	}

	public void UgasiGa() {
		frame.dispose();
	}
}
