


import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JRadioButton;



public class Register {

	private JFrame frame;
	/*private final Action action = new SwingAction();*/
	JButton button;
	JLabel lblAddPicture;
	Image img;
	//private Alert alert;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		JButton btnNewButton = new JButton("Browse");
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter=new FileNameExtensionFilter("Images", "jpg","gif","png");
					  chooser.addChoosableFileFilter(filter);
					chooser.showOpenDialog(null);
				    
				 try{
					 img=ImageIO.read(chooser.getSelectedFile());
				 }catch(IOException e1){
					 e1.printStackTrace();
				}
					ImageIcon icon = new ImageIcon(img); 
				//lblAddPicture.setIcon(icon);
					lblAddPicture.setIcon(ResizeImage(icon));
			}
				ImageIcon ResizeImage(ImageIcon i){
					Image img= i.getImage();
					Image newimg=img.getScaledInstance(lblAddPicture.getWidth(), lblAddPicture.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon image= new ImageIcon(newimg);
					return image;}
		});
		
		btnNewButton.setBounds(23, 160, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		lblAddPicture= new JLabel();
		lblAddPicture.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAddPicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddPicture.setText("ADD PICTURE");
		lblAddPicture.setBounds(23, 11, 89, 138);
		frame.getContentPane().add(lblAddPicture);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblName.setBounds(200, 32, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(266, 30, 153, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
			
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSurname.setBounds(200, 57, 51, 14);
		frame.getContentPane().add(lblSurname);
		
		
		textField_1 = new JTextField();
		textField_1.setBounds(266, 55, 153, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAge.setBounds(200, 82, 46, 14);
		frame.getContentPane().add(lblAge);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(266, 80, 51, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(200, 107, 67, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 105, 153, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPassword.setBounds(200, 132, 67, 14);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(266, 129, 153, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblGendre = new JLabel("Gender");
		lblGendre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblGendre.setBounds(200, 159, 67, 14);
		frame.getContentPane().add(lblGendre);
		
		JRadioButton Male = new JRadioButton("Male");
		Male.setFont(new Font("Arial", Font.PLAIN, 11));
		Male.setBounds(266, 160, 51, 23);
		frame.getContentPane().add(Male);
		
		JRadioButton Female = new JRadioButton("Female");
		Female.setFont(new Font("Arial", Font.PLAIN, 11));
		Female.setBounds(335, 160, 109, 23);
		frame.getContentPane().add(Female);
		
		
		
		JButton Done = new JButton("Done");
		Done.setFont(new Font("Arial", Font.PLAIN, 13));
		Done.setBounds(335, 224, 89, 36);
		frame.getContentPane().add(Done);
		Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Male.isSelected()&&!Female.isSelected()){
					 JOptionPane.showMessageDialog(null, "Choose a gender!!!", "Error",
		                     JOptionPane.ERROR_MESSAGE);
				}
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
		
