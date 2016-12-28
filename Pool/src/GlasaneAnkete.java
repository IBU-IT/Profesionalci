import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

public class GlasaneAnkete {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void GlasaneA() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlasaneAnkete window = new GlasaneAnkete();
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
	public GlasaneAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Ankete na kojima si glasao");
		frame.setBounds(100, 100, 520, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAnketeNaKojima = new JLabel("ANKETE NA KOJIMA SI GLASAO");
		lblAnketeNaKojima.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblAnketeNaKojima.setBounds(131, 23, 273, 48);
		frame.getContentPane().add(lblAnketeNaKojima);
	}

}
