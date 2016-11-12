import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Login {

	private JFrame frame;
	private JTextField textField;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUname = new JLabel("Username");
		lblUname.setBounds(10, 90, 77, 14);
		frame.getContentPane().add(lblUname);
		
		JLabel lblPw = new JLabel("Password");
		lblPw.setBounds(10, 115, 77, 14);
		frame.getContentPane().add(lblPw);
		
		textField = new JTextField();
		textField.setBounds(96, 87, 89, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(97, 112, 89, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (textField.getText().equals("admin")){
					if (textField_1.getText().equals("admin")){
						JOptionPane.showMessageDialog(null, "Logovan Si");
					}else{
						JOptionPane.showMessageDialog(null, "Netaèni podatci");
					}
				}
			}
		});
		btnNewButton.setBounds(72, 166, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
