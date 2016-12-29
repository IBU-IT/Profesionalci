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

public class PrikaziOdgovoreIzabraneAnkete {

	private JFrame frmUskoro;
	private ArrayList<String> list = new ArrayList<>();
	//private ArrayList<Integer> listID = new ArrayList<>();
	private String prviOdgovor = "";
	private String drugiOdgovor = "";
	private String treciOdgovor = "";
	private int prviID=0;
	private int drugiID=0;
	private int treciID=0;
	private int imalga = 0;

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
			// Registruj JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// Zapocni konekciju conn
			conn2 = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");	
			
			stmt2 = conn2.createStatement();
			String sql;
			sql = ("SELECT answer FROM answers WHERE question_id='"+pitanje.getId()+"' ");
			ResultSet rs2 = stmt2.executeQuery(sql);
			while(rs2.next()){    
				//listID.add(rs2.getInt("id")); //ID
				list.add(rs2.getString("answer")); //Odgovor
			}

			setPrviOdgovor(list.get(0));
			//setPrviID(listID.get(0));
			setDrugiOdgovor(list.get(1));
			//setDrugiID(listID.get(1));
			
			if(getTreciOdgovor().equals("")){
				setPostojilTreci(1);
			}else{
				setTreciOdgovor(list.get(2));
				//setTreciID(listID.get(2));
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
		
		
		JButton btnOdgovor1 = new JButton(getPrviOdgovor());
		btnOdgovor1.setBounds(10, 86, 424, 23);
		frmUskoro.getContentPane().add(btnOdgovor1);
		
		JButton btnOdgovor2 = new JButton(getDrugiOdgovor());
		btnOdgovor2.setBounds(10, 120, 424, 23);
		frmUskoro.getContentPane().add(btnOdgovor2);
		
		if(getPostojilTreci() == 0){
		JButton btnOdgovor3 = new JButton(getTreciOdgovor());
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
}
