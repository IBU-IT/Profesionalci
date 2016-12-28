import java.awt.EventQueue;

import javax.swing.JFrame;

public class PrikaziOdgovoreIzabraneAnkete {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void prikaziOdgovore() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikaziOdgovoreIzabraneAnkete window = new PrikaziOdgovoreIzabraneAnkete();
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
	public PrikaziOdgovoreIzabraneAnkete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
