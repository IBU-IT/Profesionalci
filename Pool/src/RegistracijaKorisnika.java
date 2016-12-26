import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;



public class RegistracijaKorisnika {

	private JFrame frmRegistrujSe;
	/*private final Action action = new SwingAction();*/
	JButton button;
	Image img;
	//private Alert alert;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	//Nije jos zavrseno biti ce dodano na login da se korisnik u Login panelu moze registrovat
	public void RegistracijaIzLogina() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistracijaKorisnika window = new RegistracijaKorisnika();
					window.frmRegistrujSe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistracijaKorisnika() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrujSe = new JFrame();
		frmRegistrujSe.setTitle("Registruj Se");
		frmRegistrujSe.setBounds(100, 100, 520, 410);
		frmRegistrujSe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrujSe.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(10, 13, 46, 14);
		frmRegistrujSe.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(76, 11, 153, 20);
		frmRegistrujSe.getContentPane().add(textField);
		textField.setColumns(10);
		
		
			
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSurname.setBounds(10, 38, 51, 14);
		frmRegistrujSe.getContentPane().add(lblSurname);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(76, 36, 153, 20);
		frmRegistrujSe.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAge.setBounds(10, 63, 46, 14);
		frmRegistrujSe.getContentPane().add(lblAge);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(76, 61, 51, 20);
		frmRegistrujSe.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 88, 67, 14);
		frmRegistrujSe.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 86, 153, 20);
		frmRegistrujSe.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(10, 113, 67, 14);
		frmRegistrujSe.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(76, 110, 153, 20);
		frmRegistrujSe.getContentPane().add(passwordField);
		
		JLabel lblGendre = new JLabel("Gender");
		lblGendre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGendre.setBounds(10, 140, 67, 14);
		frmRegistrujSe.getContentPane().add(lblGendre);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setFont(new Font("Arial", Font.PLAIN, 11));
		Male.setBounds(76, 141, 51, 23);
		frmRegistrujSe.getContentPane().add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.setFont(new Font("Arial", Font.PLAIN, 11));
		Female.setBounds(157, 140, 109, 23);
		frmRegistrujSe.getContentPane().add(Female);
		
		ButtonGroup grupa = new ButtonGroup();
	    grupa.add(Male);
	    grupa.add(Female);
		
		JButton RegistrujSe = new JButton("Registruj Se");
		RegistrujSe.setFont(new Font("Arial", Font.PLAIN, 13));
		RegistrujSe.setBounds(10, 171, 219, 44);
		frmRegistrujSe.getContentPane().add(RegistrujSe);
		RegistrujSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		if(passwordField.getPassword().toString() == null || passwordField.getPassword().length == 0 || passwordField.getPassword().toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "Password field is empty!!!", "Error",
                    JOptionPane.ERROR_MESSAGE);
		}
		 if( textField_2.getText() == null || textField_2.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Username field is empty!!!", "Error",
                    JOptionPane.ERROR_MESSAGE);
		}
			}
			
		});
		
	}
	
}
		
