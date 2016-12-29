import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JLabel;

public class PrikaziOdgovoreIzabraneAnkete {

	private JFrame frmUskoro;
	private ArrayList<String> list = new ArrayList<>();
	private String prviOdgovor = "";
	private String drugiOdgovor = "";
	private String treciOdgovor = "";

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
		frmUskoro.setTitle("Uskoro");
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
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
			
			stmt2 = conn2.createStatement();
			String sql;
			sql = ("SELECT answer FROM answers WHERE question_id='"+pitanje.getId()+"' ");
			ResultSet rs2 = stmt2.executeQuery(sql);
			while(rs2.next()){    
		       list.add(rs2.getString("answer"));
			}

			setPrviOdgovor(list.get(0));
			setDrugiOdgovor(list.get(1));
			setTreciOdgovor(list.get(2));
			
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
		
		
		JButton btnOdgovor1 = new JButton(getPrviOdgovor());
		btnOdgovor1.setBounds(10, 86, 89, 23);
		frmUskoro.getContentPane().add(btnOdgovor1);
		
		JButton btnOdgovor2 = new JButton(getDrugiOdgovor());
		btnOdgovor2.setBounds(109, 86, 89, 23);
		frmUskoro.getContentPane().add(btnOdgovor2);
		
		JButton btnOdgovor3 = new JButton(getTreciOdgovor());
		btnOdgovor3.setBounds(208, 86, 89, 23);
		frmUskoro.getContentPane().add(btnOdgovor3);
		
	}

	public String getPrviOdgovor() {
		return prviOdgovor;
	}

	public void setPrviOdgovor(String prviOdgovor) {
		this.prviOdgovor = prviOdgovor;
	}

	public String getDrugiOdgovor() {
		return drugiOdgovor;
	}

	public void setDrugiOdgovor(String drugiOdgovor) {
		this.drugiOdgovor = drugiOdgovor;
	}

	public String getTreciOdgovor() {
		return treciOdgovor;
	}

	public void setTreciOdgovor(String treciOdgovor) {
		this.treciOdgovor = treciOdgovor;
	}
}
