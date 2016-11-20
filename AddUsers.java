package project;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class AddUsers{
	public static void main(String[] args) {
		
	 String name_surname, username, password, jmbg;
	 String[] options = new String[] {"Admin", "User"};

	
	
	
	int response = JOptionPane.showOptionDialog(null, "Message", "Title",
	        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	 
	 JOptionPane.showMessageDialog(null, "Welcome  to our survey");  
	name_surname=JOptionPane.showInputDialog(null, "Enter your name", "Name Surname");
	 username=JOptionPane.showInputDialog(null, "Enter your username", "Username");
	 password=JOptionPane.showInputDialog(null, "Enter your password", "Password");
	 jmbg=JOptionPane.showInputDialog(null, "Enter your jmbg", "JMBG");
	 JOptionPane.showMessageDialog(null,  "---------------------------------\nUSER INFO:\n---------------------------------\nName: "+name_surname+"\nUsername: "+username);
	}
}
