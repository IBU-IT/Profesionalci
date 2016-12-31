import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GlasajNaAnketi {

	ArrayList<String> groupNames = new ArrayList<String>();
	private static int id;
	private static String pitanje = "";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void GlasajnaA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlasajNaAnketi window = new GlasajNaAnketi();
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
	public GlasajNaAnketi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Glasaj na Anketi");
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblOdaberiAnketu = new JLabel("Izaberite anketu na kojoj \u017Eelite glasati:");
		lblOdaberiAnketu.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblOdaberiAnketu.setBounds(10, 11, 357, 20);
		frame.getContentPane().add(lblOdaberiAnketu);

		// TRY
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			
			Class.forName(DbConnection.JDBC_DRIVER);
			conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

			String sql = "SELECT question_text FROM questions AS q WHERE is_closed=0 AND id NOT IN (SELECT question_id FROM submited_answers WHERE user_id = ?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Login.getId());			
			ResultSet rs = stmt.executeQuery();

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

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Gadugi", Font.PLAIN, 12));
		comboBox.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(comboBox);
		DefaultComboBoxModel model = new DefaultComboBoxModel(groupNames.toArray());
		comboBox.setModel(model);

		JButton btnGlasaj = new JButton("Prikazi odgovore za anketu");
		btnGlasaj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setPitanje((String) comboBox.getSelectedItem());

				Connection conn2 = null;
				Statement stmt2 = null;
				try {
					
					Class.forName(DbConnection.JDBC_DRIVER);
					conn2 = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

					stmt2 = conn2.createStatement();
					String sql;
					sql = ("SELECT id FROM questions WHERE question_text='" + getPitanje() + "'  ");
					ResultSet rs2 = stmt2.executeQuery(sql);
					rs2.next();
					setId(rs2.getInt("id"));

					rs2.close();
					stmt2.close();
					conn2.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception x) {
					x.printStackTrace();
				}

				PrikaziOdgovoreIzabraneAnkete a = new PrikaziOdgovoreIzabraneAnkete();
				a.prikaziOdgovore();
				frame.dispose();
			}
		});
		btnGlasaj.setBackground(SystemColor.activeCaption);
		btnGlasaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnGlasaj.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnGlasaj);
	}

	public int getId() {
		return id;
	}

	public static void setId(int id) {
		GlasajNaAnketi.id = id;
	}

	public String getPitanje() {
		return pitanje;
	}

	public static void setPitanje(String pitanje) {
		GlasajNaAnketi.pitanje = pitanje;
	}

}
