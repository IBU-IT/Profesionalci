import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;


public class Login {

	private JFrame frame;
	private JTextField textField;
	Profil mojprofil = new Profil();
	LoginError greska = new LoginError();
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 335, 276);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUname = new JLabel("Username");
		lblUname.setBounds(10, 132, 77, 14);
		frame.getContentPane().add(lblUname);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setBounds(10, 157, 77, 14);
		frame.getContentPane().add(lblPw);
		
		textField = new JTextField();
		textField.setBounds(96, 129, 223, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().equals("admin")){
					if (textField_1.getText().equals("admin")){
						mojprofil.OtvoriProfil();
					}else{
						greska.PrikaziError();
					}
				}
			}
		});
		btnNewButton.setBounds(10, 207, 150, 29);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(96, 154, 223, 20);
		frame.getContentPane().add(textField_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(171, 207, 150, 29);
		frame.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(Login.class.getResource("/images/nesto.png")));
		label.setBounds(0, 0, 331, 118);
		frame.getContentPane().add(label);
	}
}