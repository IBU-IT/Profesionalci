import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.SystemColor;

public class PitanjeDodajAnketu extends DodajAnketu {

	private JFrame frame;
	private JTextField odgovor1;
	private JTextField odgovor2;
	private JTextField odgovor3;
	private int pitanjeID;
	public int provjera = 0;
	private JButton btnUnesiOdgovore;

	/**
	 * Launch the application.
	 */
	public void PDAnketu(final int pit) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PitanjeDodajAnketu window = new PitanjeDodajAnketu(pit);
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
	public PitanjeDodajAnketu(int a) {
		this.pitanjeID = a;
		initialize();
	}

	/**
	 * @wbp.parser.constructor
	 */

	public PitanjeDodajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Odgovori za anketu");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUnesitePitanjeI = new JLabel("UNESITE ODGOVORE U SVAKO POLJE:");
		lblUnesitePitanjeI.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblUnesitePitanjeI.setBounds(106, 36, 290, 50);
		frame.getContentPane().add(lblUnesitePitanjeI);

		odgovor1 = new JTextField();
		odgovor1.setBounds(91, 109, 317, 50);
		frame.getContentPane().add(odgovor1);
		odgovor1.setColumns(10);

		odgovor2 = new JTextField();
		odgovor2.setBounds(91, 170, 317, 50);
		frame.getContentPane().add(odgovor2);
		odgovor2.setColumns(10);

		odgovor3 = new JTextField();
		odgovor3.setBounds(91, 231, 317, 50);
		frame.getContentPane().add(odgovor3);
		odgovor3.setColumns(10);

		btnUnesiOdgovore = new JButton("UNESI ODGOVORE");
		btnUnesiOdgovore.setBackground(SystemColor.activeCaption);
		btnUnesiOdgovore.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnUnesiOdgovore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUnesiOdgovore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (odgovor1.getText().equals("") || odgovor2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Minimalno 2 odgovora");
				} else {

					int bazaId = pitanjeID;
					String getAnswer1 = odgovor1.getText();
					String getAnswer2 = odgovor2.getText();
					String getAnswer3 = odgovor3.getText();

					if (odgovor3.getText().equals("")) {
						provjera = 1;
					} else {
						provjera = 2;
					}

					Connection conn = null;

					try {
						int defaultCounter = 0;
						Class.forName(DbConnection.JDBC_DRIVER);
						conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
						Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
								ResultSet.CONCUR_UPDATABLE);

						String prva = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId
								+ "', '" + getAnswer1 + "', '" + defaultCounter + "')";

						String druga = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId
								+ "', '" + getAnswer2 + "', '" + defaultCounter + "')";

						String treca = "INSERT INTO answers (question_id,answer,answer_count) VALUES ('" + bazaId
								+ "', '" + getAnswer3 + "', '" + defaultCounter + "')";

						conn.setAutoCommit(false);

						if (provjera == 1) {
							stmt.addBatch(prva);
							stmt.addBatch(druga);
							stmt.executeBatch();
						} else if (provjera == 2) {
							stmt.addBatch(prva);
							stmt.addBatch(druga);
							stmt.addBatch(treca);
							stmt.executeBatch();
						}

						conn.commit();
						conn.close();

					} catch (SQLException se) {
						se.printStackTrace();
					} catch (Exception x) {
						x.printStackTrace();
					} finally {

						try {
							if (conn != null)
								conn.close();
							CloseFrame();
						} catch (SQLException se) {
							se.printStackTrace();
						}
					}
				}
			}

			private void CloseFrame() {
				frame.dispose();
			}
		});
		btnUnesiOdgovore.setBounds(141, 307, 200, 50);
		frame.getContentPane().add(btnUnesiOdgovore);
	}
}
