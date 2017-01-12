import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class PrikaziGreskeAdmin {

	ArrayList<UserSurvey> userSurveys = new ArrayList<>();
	private JFrame frame;
	private JTable table;

	//
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
		frame.setResizable(false);
		frame.setTitle("Prijavljene greske :");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAnketeNaKojima = new JLabel("PRIJAVLJENE GREŠKE:");
		lblAnketeNaKojima.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblAnketeNaKojima.setBounds(131, 23, 273, 48);
		frame.getContentPane().add(lblAnketeNaKojima);

		Object columnNames[] = { "GRESKE " };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			String sqlSelect = "SELECT * FROM greske ORDER BY id DESC";
			stmt = conn.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				UserSurvey us = new UserSurvey();
				us.questionText = rs.getString("opis_greske");

				userSurveys.add(us);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		}

		for (int i = 0; i < userSurveys.size(); i++) {
			String name = userSurveys.get(i).questionText;
			Object[] data = { name };
			tableModel.addRow(data);
		}

		table = new JTable(tableModel);
		table.setFont(new Font("Gadugi", Font.PLAIN, 12));
		table.setEnabled(false);
		table.setBounds(10, 104, 494, 266);
		table.setFillsViewportHeight(true);

		JScrollPane js = new JScrollPane(table);
		js.setEnabled(false);
		js.setSize(494, 266);
		js.setLocation(10, 104);
		js.setVisible(true);
		frame.getContentPane().add(js);

	}

}
