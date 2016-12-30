import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class PrikaziStatistikuIzabranog {

	private JFrame frame;
	private int idPitanja;
	ArrayList<String> odgovori = new ArrayList<String>();
	ArrayList<Integer> counter = new ArrayList<Integer>();
	private int PostojilGreska=0;

	/**
	 * Launch the application.
	 */
	public void stats() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziStatistikuIzabranog window = new PrikaziStatistikuIzabranog();
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
	public PrikaziStatistikuIzabranog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PREGLED STATISTIKE");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		PregledStatistike obj = new PregledStatistike();
		JLabel lblTextpitanja = new JLabel(obj.getIzabranoPitanje());
		lblTextpitanja.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblTextpitanja.setBounds(85, 11, 339, 20);
		frame.getContentPane().add(lblTextpitanja);
		
		//IZVUCI ID
				Connection conn = null;
				Statement stmt = null;			
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");				
					stmt = conn.createStatement();
					String sql;
					sql = ("SELECT id FROM questions WHERE question_text = '"+obj.getIzabranoPitanje()+"' ");
					ResultSet rs = stmt.executeQuery(sql);
					while (rs.next()) {
						setIdPitanja(rs.getInt("id"));
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
				//ID POVUCEN
				
				//IZVUCI ODGOVORE
				Connection conn2 = null;
				Statement stmt2 = null;			
				try {
					// Registruj JDBC driver
					Class.forName("com.mysql.jdbc.Driver");

					// Zapocni konekciju conn
					conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");				
					stmt2 = conn2.createStatement();
					String sql2;
					sql2 = ("SELECT answer, answer_count FROM answers WHERE question_id = '"+getIdPitanja()+"' ");
					ResultSet rs2 = stmt2.executeQuery(sql2);
					while (rs2.next()) {
						String odgovor = rs2.getString("answer");
						int broj = rs2.getInt("answer_count");
						odgovori.add(odgovor);
						counter.add(broj);
					}	
					rs2.close(); 
					stmt2.close();
					conn2.close();
				} catch (SQLException se) {
					// Errors JDBC
					se.printStackTrace();
				}
				catch (Exception x) {
					// Errors za Class.forName
					x.printStackTrace();
				}
				//IZVUCI ODGOVORE
		
		JLabel prviOdgovorText = new JLabel(odgovori.get(0));
		prviOdgovorText.setFont(new Font("Gadugi", Font.BOLD, 14));
		prviOdgovorText.setBounds(15, 83, 130, 20);
		frame.getContentPane().add(prviOdgovorText);
		
		JLabel brojac1 = new JLabel (String.valueOf(counter.get(0)));
		brojac1.setFont(new Font("Gadugi", Font.BOLD, 14));
		brojac1.setBounds(15, 103, 46, 20);
		frame.getContentPane().add(brojac1);
		
		JLabel drugiOdgovorText = new JLabel (odgovori.get(1));
		drugiOdgovorText.setFont(new Font("Gadugi", Font.BOLD, 14));
		drugiOdgovorText.setBounds(154, 83, 130, 20);
		frame.getContentPane().add(drugiOdgovorText);		
		
		JLabel brojac2 = new JLabel(String.valueOf(counter.get(1)));
		brojac2.setFont(new Font("Gadugi", Font.BOLD, 14));
		brojac2.setBounds(154, 103, 46, 20);
		frame.getContentPane().add(brojac2);
		
		JLabel lblOdgovor = new JLabel("1. ODGOVOR");
		lblOdgovor.setFont(new Font("Gadugi", Font.BOLD, 12));
		lblOdgovor.setBounds(15, 58, 96, 14);
		frame.getContentPane().add(lblOdgovor);
		
		JLabel lblOdgovor_1 = new JLabel("2. ODGOVOR");
		lblOdgovor_1.setFont(new Font("Gadugi", Font.BOLD, 12));
		lblOdgovor_1.setBounds(154, 58, 88, 14);
		frame.getContentPane().add(lblOdgovor_1);
		
		JLabel lblOdgovor_2 = new JLabel("3. ODGOVOR");
		lblOdgovor_2.setFont(new Font("Gadugi", Font.BOLD, 12));
		lblOdgovor_2.setBounds(294, 58, 96, 14);
		frame.getContentPane().add(lblOdgovor_2);
		
		JLabel lblPitanje = new JLabel("PITANJE :");
		lblPitanje.setForeground(SystemColor.activeCaption);
		lblPitanje.setFont(new Font("Gadugi", Font.BOLD, 14));
		lblPitanje.setBounds(10, 11, 77, 20);
		frame.getContentPane().add(lblPitanje);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(PrikaziStatistikuIzabranog.class.getResource("/images/pngzaanketu.png")));
		lblNewLabel.setBounds(10, 49, 427, 93);
		frame.getContentPane().add(lblNewLabel);
		
		
		try {
			odgovori.get(2);
			counter.get(2);
		} catch ( IndexOutOfBoundsException e ) {
			setPostojilGreska(1);
		}
		
		if(getPostojilGreska() == 0){
		JLabel treciOdgovorText = new JLabel(odgovori.get(2));
		treciOdgovorText.setFont(new Font("Gadugi", Font.BOLD, 14));
		treciOdgovorText.setBounds(294, 83, 130, 20);
		frame.getContentPane().add(treciOdgovorText);
		
		JLabel brojac3 = new JLabel (String.valueOf(counter.get(2)));
		brojac3.setFont(new Font("Gadugi", Font.BOLD, 14));
		brojac3.setBounds(294, 103, 46, 20);
		frame.getContentPane().add(brojac3);
		}
	}


	public int getIdPitanja() {
		return idPitanja;
	}

	public void setIdPitanja(int idPitanja) {
		this.idPitanja = idPitanja;
	}
	
	public int getPostojilGreska() {
		return PostojilGreska;
	}

	public void setPostojilGreska(int PostojilGreska) {
		this.PostojilGreska = PostojilGreska;
	}
}
