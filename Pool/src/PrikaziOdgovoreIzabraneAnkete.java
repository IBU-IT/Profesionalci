import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrikaziOdgovoreIzabraneAnkete {

	private JFrame frmUskoro;
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<Integer> listID = new ArrayList<>();
	private String prviOdgovor = "";
	private String drugiOdgovor = "";
	private String treciOdgovor = "";
	private int prviID = 0;
	private int drugiID = 0;
	private int treciID = 0;
	private int imalga = 0;
	private int userID = 0;
	private int pitanjeID = 0;

	/**
	 * Launch the application.
	 */
	public void prikaziOdgovore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziOdgovoreIzabraneAnkete window = new PrikaziOdgovoreIzabraneAnkete();
					window.frmUskoro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrikaziOdgovoreIzabraneAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUskoro = new JFrame();
		frmUskoro.setTitle("Glasajte");
		frmUskoro.setResizable(false);
		frmUskoro.setBounds(100, 100, 450, 300);
		frmUskoro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUskoro.getContentPane().setLayout(null);

		GlasajNaAnketi pitanje = new GlasajNaAnketi();
		JLabel lblNewLabel = new JLabel(pitanje.getPitanje());
		lblNewLabel.setBounds(10, 11, 424, 14);
		frmUskoro.getContentPane().add(lblNewLabel);

		Connection conn2 = null;
		Statement stmt2 = null;
		try {

			Class.forName(DbConnection.JDBC_DRIVER);
			conn2 = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			stmt2 = conn2.createStatement();
			String sql;
			sql = ("SELECT id, answer FROM answers WHERE question_id='" + pitanje.getId() + "' ");
			ResultSet rs2 = stmt2.executeQuery(sql);
			while (rs2.next()) {
				listID.add(rs2.getInt("id"));
				list.add(rs2.getString("answer"));
			}

			Login povuci = new Login();
			setPitanjeID(pitanje.getId());
			setUserID(povuci.getId());
			setPrviOdgovor(list.get(0));
			setPrviID(listID.get(0));
			setDrugiOdgovor(list.get(1));
			setDrugiID(listID.get(1));

			try {
				list.get(2);
				setPostojilTreci(0);
				setTreciOdgovor(list.get(2));
				setTreciID(listID.get(2));
			} catch (IndexOutOfBoundsException e) {
				setPostojilTreci(1);
			}

			rs2.close();
			stmt2.close();
			conn2.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception x) {
			x.printStackTrace();
		}

		JButton btnOdgovor1 = new JButton(getPrviOdgovor());
		btnOdgovor1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn = null;
				try {

					Class.forName(DbConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

					Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String prvi = "INSERT INTO submited_answers (question_id, user_id, answer_id) VALUES('"
							+ getPitanjeID() + "', '" + getUserID() + "', '" + getPrviID() + "')";
					String drugi = "UPDATE answers SET answer_count = answer_count + 1 WHERE id = '" + getPrviID()
							+ "' ";

					conn.setAutoCommit(false);
					stmt1.addBatch(prvi);
					stmt1.addBatch(drugi);
					int[] count = stmt1.executeBatch();
					conn.commit();
					if (count.length != 0) {
						JOptionPane.showMessageDialog(null, "Uspjesno");
						frmUskoro.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovno");
					}
					stmt1.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception x) {
					x.printStackTrace();
				}

			}
		});
		btnOdgovor1.setBounds(10, 86, 424, 23);
		frmUskoro.getContentPane().add(btnOdgovor1);

		JButton btnOdgovor2 = new JButton(getDrugiOdgovor());
		btnOdgovor2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connection conn = null;
				try {

					Class.forName(DbConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

					Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
					String prvi = "INSERT INTO submited_answers (question_id, user_id, answer_id) VALUES('"
							+ getPitanjeID() + "', '" + getUserID() + "', '" + getDrugiID() + "')";
					String drugi = "UPDATE answers SET answer_count = answer_count + 1 WHERE id = '" + getDrugiID()
							+ "' ";

					conn.setAutoCommit(false);
					stmt1.addBatch(prvi);
					stmt1.addBatch(drugi);
					int[] count = stmt1.executeBatch();
					conn.commit();
					if (count.length != 0) {
						JOptionPane.showMessageDialog(null, "Uspjesno");
						frmUskoro.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovno");
					}
					stmt1.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception x) {
					x.printStackTrace();
				}
			}

		});
		btnOdgovor2.setBounds(10, 120, 424, 23);
		frmUskoro.getContentPane().add(btnOdgovor2);

		if (getPostojilTreci() == 0) {
			JButton btnOdgovor3 = new JButton(getTreciOdgovor());
			btnOdgovor3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Connection conn = null;
					try {

						Class.forName(DbConnection.JDBC_DRIVER);
						conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);
						Statement stmt1 = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
								ResultSet.CONCUR_UPDATABLE);
						String prvi = "INSERT INTO submited_answers (question_id, user_id, answer_id) VALUES('"
								+ getPitanjeID() + "', '" + getUserID() + "', '" + getTreciID() + "')";
						String drugi = "UPDATE answers SET answer_count = answer_count + 1 WHERE id = '" + getTreciID()
								+ "' ";

						conn.setAutoCommit(false);
						stmt1.addBatch(prvi);
						stmt1.addBatch(drugi);
						int[] count = stmt1.executeBatch();
						conn.commit();
						if (count.length != 0) {
							JOptionPane.showMessageDialog(null, "Uspjesno");
							frmUskoro.dispose();
						} else {
							JOptionPane.showMessageDialog(null, "Doslo je do greske, pokusajte ponovno");
						}
						stmt1.close();
						conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					} catch (Exception x) {
						x.printStackTrace();
					}
				}
			});
			frmUskoro.dispose();
			btnOdgovor3.setBounds(10, 154, 424, 23);
			frmUskoro.getContentPane().add(btnOdgovor3);
		}

	}

	public String getPrviOdgovor() {
		return prviOdgovor;
	}

	public void setPrviOdgovor(String prviOdgovor) {
		this.prviOdgovor = prviOdgovor;
	}

	public int getPrviID() {
		return prviID;
	}

	public void setPrviID(int prviID) {
		this.prviID = prviID;
	}

	public int getDrugiID() {
		return drugiID;
	}

	public void setDrugiID(int drugiID) {
		this.drugiID = drugiID;
	}

	public int getTreciID() {
		return treciID;
	}

	public void setTreciID(int treciID) {
		this.treciID = treciID;
	}

	public String getDrugiOdgovor() {
		return drugiOdgovor;
	}

	public void setDrugiOdgovor(String drugiOdgovor) {
		this.drugiOdgovor = drugiOdgovor;
	}

	public int getPostojilTreci() {
		return imalga;
	}

	public void setPostojilTreci(int imalga) {
		this.imalga = imalga;
	}

	public String getTreciOdgovor() {
		return treciOdgovor;
	}

	public void setTreciOdgovor(String treciOdgovor) {
		this.treciOdgovor = treciOdgovor;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getPitanjeID() {
		return pitanjeID;
	}

	public void setPitanjeID(int pitanjeID) {
		this.pitanjeID = pitanjeID;
	}
}
