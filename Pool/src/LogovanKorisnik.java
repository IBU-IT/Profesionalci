import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class LogovanKorisnik {

	private JFrame frmUserPanel;
	/**
	 * Launch the application.
	 */
	public void LogovanProfil() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogovanKorisnik window = new LogovanKorisnik();
					window.frmUserPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogovanKorisnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserPanel = new JFrame();
		frmUserPanel.setResizable(false);
		frmUserPanel.setTitle("User Panel");
		frmUserPanel.setBounds(100, 100, 653, 480);
		frmUserPanel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmUserPanel.getContentPane().setLayout(null);

		Login drugi = new Login();
		JLabel privaljnenKaoTekst = new JLabel("<html><font color='black'>" + drugi.getUsername() + "</font></html>");
		privaljnenKaoTekst.setFont(new Font("Gadugi", Font.PLAIN, 20));
		privaljnenKaoTekst.setBounds(111, 252, 137, 19);
		frmUserPanel.getContentPane().add(privaljnenKaoTekst);

		JLabel prijavljenIme = new JLabel("<html><font color='black'>" + drugi.getFirstName() + "</font></html>");
		prijavljenIme.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prijavljenIme.setBounds(111, 276, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenIme);

		JLabel prijavljenPrezime = new JLabel("<html><font color='black'>" + drugi.getLastName() + "</font></html>");
		prijavljenPrezime.setFont(new Font("Gadugi", Font.PLAIN, 14));
		prijavljenPrezime.setBounds(111, 296, 113, 19);
		frmUserPanel.getContentPane().add(prijavljenPrezime);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LogovanKorisnik.class.getResource("/images/loginuser.png")));
		lblNewLabel.setBounds(0, 0, 652, 472);
		frmUserPanel.getContentPane().add(lblNewLabel);
		
		JLabel glasajNaAnketibutt = new JLabel("");
		glasajNaAnketibutt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlasajNaAnketi glasajNA = new GlasajNaAnketi();
				glasajNA.GlasajnaA();
			}
		});
		glasajNaAnketibutt.setBounds(203, 48, 441, 73);
		frmUserPanel.getContentPane().add(glasajNaAnketibutt);
		
		JLabel ODJAVISEbutt = new JLabel("");
		ODJAVISEbutt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login x = new Login();
				x.pojaviSe();
				frmUserPanel.dispose();
			}
		});
		ODJAVISEbutt.setBounds(292, 350, 352, 77);
		frmUserPanel.getContentPane().add(ODJAVISEbutt);
		
		JLabel glasaneAnketebutt = new JLabel("");
		glasaneAnketebutt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GlasaneAnkete glasaneAA = new GlasaneAnkete();
				glasaneAA.GlasaneA();
				
			}
		});
		glasaneAnketebutt.setBounds(292, 146, 352, 77);
		frmUserPanel.getContentPane().add(glasaneAnketebutt);
		
		JLabel ostaviFeedbackbtt = new JLabel("");
		ostaviFeedbackbtt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PrijaviGresku greska = new PrijaviGresku();
				greska.greska();
			}
		});
		ostaviFeedbackbtt.setBounds(357, 252, 287, 73);
		frmUserPanel.getContentPane().add(ostaviFeedbackbtt);
	}
}
