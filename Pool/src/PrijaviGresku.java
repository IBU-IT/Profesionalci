
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JTextArea;
import java.awt.SystemColor;


public class PrijaviGresku {

	private JFrame frmPrijaviGresku;

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
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(10, 56, 484, 209);
		frmPrijaviGresku.getContentPane().add(textArea);
		
	}
}
