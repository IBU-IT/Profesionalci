import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;

public class GlasajNaAnketi {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void GlasajnaA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlasajNaAnketi window = new GlasajNaAnketi();
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
	public GlasajNaAnketi() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Glasaj na Anketi");
		frame.setResizable(false);
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblOdaberiAnketu = new JLabel("ODABERI ANKETU");
		lblOdaberiAnketu.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblOdaberiAnketu.setBounds(177, 22, 190, 44);
		frame.getContentPane().add(lblOdaberiAnketu);
		
		JButton btnGlasaj = new JButton("GLASAJ");
		btnGlasaj.setBackground(SystemColor.activeCaption);
		btnGlasaj.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnGlasaj.setBounds(146, 294, 229, 58);
		frame.getContentPane().add(btnGlasaj);
	}
}
