import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PrijaviGresku {

	private JFrame frmPrijaviGresku;
	private static String tekst;

	/**
	 * Launch the application.
	 */
	public void greska() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrijaviGresku window = new PrijaviGresku();
					window.frmPrijaviGresku.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrijaviGresku() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPrijaviGresku = new JFrame();
		frmPrijaviGresku.setTitle("Prijavi Gresku");
		frmPrijaviGresku.setBounds(100, 100, 520, 410);
		frmPrijaviGresku.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPrijaviGresku.getContentPane().setLayout(null);
		
		JLabel lblOpiiteProblemKoji = new JLabel("Opi\u0161ite problem koji imate :");
		lblOpiiteProblemKoji.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOpiiteProblemKoji.setBounds(10, 11, 262, 34);
		frmPrijaviGresku.getContentPane().add(lblOpiiteProblemKoji);
		
		JButton btnPrijaviGreku = new JButton("PRIJAVITE GRE\u0160KU");
		
			btnPrijaviGreku.setBackground(SystemColor.activeCaption);
			btnPrijaviGreku.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnPrijaviGreku.setBounds(43, 295, 414, 46);
			frmPrijaviGresku.getContentPane().add(btnPrijaviGreku);
			
			
			final JTextArea textArea = new JTextArea();
			textArea.setLineWrap(true);
			textArea.setBounds(10, 56, 484, 209);
			frmPrijaviGresku.getContentPane().add(textArea);
			btnPrijaviGreku.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					setTekst(textArea.getText());
					if(textArea.getDocument().getLength() < 25 ){
						JOptionPane.showMessageDialog(null, "Poruka mora sadrzavati minimalno 25 karaktera");
					}else{
						
					Connection conn = null;
					Statement stmt = null;
					try {
						// Registruj JDBC driver
						Class.forName("com.mysql.jdbc.Driver");

						// Zapocni konekciju conn
						conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/SurveyDB?verifyServerCertificate=false&useSSL=false", "root", "123456");

						// Napravi statement i izvrsi query
						stmt = conn.createStatement();
						
						int gotovo = stmt.executeUpdate("INSERT INTO greske (opis_greske) VALUES('"+ getTekst() +"')");
					
						if (gotovo>0){
							JOptionPane.showMessageDialog(null, "Greska uspjesno poslana.");
							textArea.setText("");
						}else{
							JOptionPane.showMessageDialog(null, "Doslo je do greške. molimo vas da pokusate ponovno.");
						}
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
					
					}
				}
			
			
		});
	
	
	}

	public static String getTekst() {
		return tekst;
	}

	public static void setTekst(String tekst) {
		PrijaviGresku.tekst = tekst;
	}
	
}