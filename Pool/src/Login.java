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
	private JTextField usernameField;
	Profil mojprofil = new Profil();
	LoginError greska = new LoginError();
	private JTextField passwordBox;

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
		
		JLabel unameText = new JLabel("Username");
		unameText.setBounds(10, 132, 77, 14);
		frame.getContentPane().add(unameText);
		
		JLabel pwText = new JLabel("Password");
		pwText.setBounds(10, 157, 77, 14);
		frame.getContentPane().add(pwText);
		
		usernameField = new JTextField();
		usernameField.setBounds(96, 129, 223, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (usernameField.getText().equals("admin")){
					if (passwordBox.getText().equals("admin")){
						mojprofil.OtvoriProfil();
					}else{
						greska.PrikaziError();
					}
				}
			}
		});
		loginButton.setBounds(10, 207, 150, 29);
		frame.getContentPane().add(loginButton);
		
		passwordBox = new JTextField();
		passwordBox.setColumns(10);
		passwordBox.setBounds(96, 154, 223, 20);
		frame.getContentPane().add(passwordBox);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(171, 207, 150, 29);
		frame.getContentPane().add(exitButton);
		
		JLabel logo = new JLabel("New label");
		logo.setIcon(new ImageIcon(Login.class.getResource("/images/nesto.png")));
		logo.setBounds(0, 0, 331, 118);
		frame.getContentPane().add(logo);
	}
}