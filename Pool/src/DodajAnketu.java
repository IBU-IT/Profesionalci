
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class DodajAnketu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public void DodajAnk() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajAnketu window = new DodajAnketu();
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
	public DodajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dodaj Anketu");
		frame.setResizable(false);
		frame.setBounds(100, 100, 520, 205);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblUpiiteImeAnkete = new JLabel("UNESITE IME ANKETE :");
		lblUpiiteImeAnkete.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblUpiiteImeAnkete.setBounds(10, 11, 360, 20);
		frame.getContentPane().add(lblUpiiteImeAnkete);

		JButton btnNapraviAnketu = new JButton("NAPRAVI ANKETU");
		btnNapraviAnketu.setBackground(SystemColor.activeCaption);

		btnNapraviAnketu.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNapraviAnketu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNapraviAnketu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String bazaGetText = textField.getText();
				int bazaIsClosed = 0;
				int questionID = 0;
				Connection conn = null;
				PreparedStatement stmt = null;
				try {

					Class.forName(DbConnection.JDBC_DRIVER);
					conn = DriverManager.getConnection(DbConnection.DB_URL, DbConnection.USER, DbConnection.PASS);

					stmt = conn.prepareStatement("INSERT INTO questions (question_text,is_closed) VALUES ('"
							+ bazaGetText + "', " + bazaIsClosed + ") ", Statement.RETURN_GENERATED_KEYS);
					int affectedRows = stmt.executeUpdate();
					if (affectedRows == 0) {
						throw new SQLException("Kreiranje pitanja bezuspješno");
					}

					try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							questionID = generatedKeys.getInt(1);
							CloseFrame();
						} else {
							throw new SQLException("Kreira, no ID obtained.");
						}
					}

					stmt.close();
					conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} catch (Exception x) {
					x.printStackTrace();
				} finally {
					try {
						if (stmt != null)
							stmt.close();
					} catch (SQLException se2) {
					}
					try {
						if (conn != null)
							conn.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}
				}

				PitanjeDodajAnketu nesto = new PitanjeDodajAnketu();
				nesto.PDAnketu(questionID);
			}

			private void CloseFrame() {
				frame.dispose();

			}
		});
		btnNapraviAnketu.setBounds(10, 121, 484, 31);
		frame.getContentPane().add(btnNapraviAnketu);

		textField = new JTextField();
		textField.setBackground(SystemColor.activeCaption);
		textField.setFont(new Font("Gadugi", Font.PLAIN, 14));
		textField.setBounds(10, 43, 484, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
