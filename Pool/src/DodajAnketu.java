import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;


public class DodajAnketu {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodajAnketu window = new DodajAnketu();
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
	public DodajAnketu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Dodaj Anketu");
		frame.setResizable(false);
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUpiiteImeAnkete = new JLabel("Upi\u0161ite ime ankete :");
		lblUpiiteImeAnkete.setBounds(187, 11, 200, 50);
		frame.getContentPane().add(lblUpiiteImeAnkete);
		
		JButton btnNapraviAnketu = new JButton("NAPRAVI ANKETU");
		btnNapraviAnketu.setBounds(117, 269, 287, 50);
		frame.getContentPane().add(btnNapraviAnketu);
		
		textField = new JTextField();
		textField.setBounds(123, 131, 264, 50);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
